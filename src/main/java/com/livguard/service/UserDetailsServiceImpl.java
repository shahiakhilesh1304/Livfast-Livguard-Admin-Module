package com.livguard.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livfast.model.LivFastUser;
import com.livfast.repository.LivFastUserRepository;
import com.livguard.model.User;
import com.livguard.repository.UserRepository;


//@Service
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class); 
	
    @Autowired
    private UserRepository userRepository;
   
    @Autowired
    private LivFastUserRepository userLFRepository;
    
   
    @Autowired
    public HttpSession session;

    
    @Override
    //@Transactional(readOnly = true)
    @Transactional("primaryTransactionManager")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
    	System.out.println(username);
    	System.out.println("username:"+username);
    	String[] data = username.split("@");
    	System.out.println("user name: "+data[0].toString()+" in database "+data[1].toString());
    	username = data[0].toString();
    	String Database = data[1].toString();
    	session.setAttribute("database", Database);
    	//System.out.println("\nlivfast"+this.userLFRepository.findAll());
    	//System.out.println("\n\nlivguard"+this.userRepository.findAll());
    	
    	System.out.println("Session Value Service: "+session.getAttribute("database"));
    	
    	
    	log.info("Username={}, database={}",username,Database);
    	
    	if(Database.equals("Livfast"))
    	{
    		List<LivFastUser> list = userLFRepository.findByEmpCode(username);   
    		if (list == null) throw new UsernameNotFoundException(username);
    		session.setAttribute("name", list.get(0).getName());
    		log.info("Role is={}",list.get(0).getRole());
    		session.setAttribute("role", list.get(0).getRole().toString());
    		String status = list.get(0).getStatus().toString();
    		if(status.equals("inactive"))
    		{
    			list.get(0).setPassword("");
    		}
    		session.setAttribute("empcode",list.get(0).getEmpCode().toString());
    		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();  
    		log.info("Password is:",list.get(0).getPassword());   		
    		return new org.springframework.security.core.userdetails.User(list.get(0).getEmpCode(), list.get(0).getPassword(), grantedAuthorities);
    	}else if(Database.equals("Livguard"))
    	{
    		List<User> list = userRepository.findByEmpCode(username);   
    		if (list == null) throw new UsernameNotFoundException(username);
    		session.setAttribute("name", list.get(0).getName());
    		log.info("Role is={}",list.get(0).getRole());
    		session.setAttribute("role", list.get(0).getRole().toString());
    		String status = list.get(0).getStatus().toString();
    		if(status.equals("inactive"))
    		{
    			list.get(0).setPassword("");
    		}
    		session.setAttribute("empcode",list.get(0).getEmpCode().toString());
    		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    		log.info("Password is:",list.get(0).getPassword());   
    		return new org.springframework.security.core.userdetails.User(list.get(0).getEmpCode(), list.get(0).getPassword(), grantedAuthorities);
    	}
		return null;
    
    }

}
