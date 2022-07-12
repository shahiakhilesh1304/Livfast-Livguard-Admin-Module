package com.livguard.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livfast.model.LivFastUser;
import com.livguard.model.Status;
import com.livguard.model.User;
import com.livguard.repository.UserRepository;

//@Service("userDetailsService")
@Service
@Transactional("primaryTransactionManager")
public class UserDetailsServiceCust 
{
	private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceCust.class); 
	
	@Autowired
	UserRepository userRepository;
	
//	@Autowired
//	LivfastSerialNumberRepository livfat;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;	

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username, String password) 
    {
    	System.out.println("Password :: "+bCryptPasswordEncoder.encode(password));
        User user = userRepository.findByEmailAndPassword(username, password);
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new org.springframework.security.core.userdetails.User(user.getEmpCode(), user.getPassword(), grantedAuthorities);
    }
	
	
	public User checkUser(String email, String password)
	{
		try
		{
			return this.userRepository.findByEmailAndPassword(email, password);
		}
		catch (Exception e) 
		{
			log.error("Exception in Check User Service = {}",e);
		}
		return null;
	}
	
	public List<User> getUserList()
	{
		try
		{
			return (List<User>) this.userRepository.findAll();
		}
		catch (Exception e) 
		{
			log.error("Exception in Get User List ServiceImpl = {}",e);
		}
		return null;
	}
	
	
	
	public String saveUser(User user)
	{
		try
		{
			long count = this.userRepository.countByEmpCode(user.getEmpCode());
			if(count != 0)
			{
				return "User Alredy Exist";	
			}
			else
			{
				user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
				user.setEntryDate(new Date());
				user.setStatus(user.getStatus());
				this.userRepository.save(user);
				return "Success";
			}
		}
		catch (Exception e) 
		{
			log.error("Exception in Save User ServiceImpl = {}",e);
		}
		return "Failed";
	}
	
	public String editUser(User user)
	{
		try
		{
			Optional<User> u = this.userRepository.findById(user.getId());
			if(u.get() != null)
			{
				u.get().setName(user.getName());
				u.get().setEmail(user.getEmail());
				u.get().setEmpCode(user.getEmpCode());
				u.get().setMsisdn(user.getMsisdn());
				u.get().setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
				u.get().setRole(user.getRole());
				u.get().setStatus(user.getStatus());
				this.userRepository.save(u.get());
				return "Success";
			}			
		}
		catch (Exception e) 
		{
			log.error("Exception in Edit User ServiceImpl = {}",e);
		}
		return "Failed";
	}
	
	public String deactivateUser(int empcode)
	{
		try
		{			
			Optional<User> user = this.userRepository.findById(empcode);
			if(user.get() != null)
			{
				User u = user.get();
				String status = u.getStatus().toString();
				if(status.equals("active"))
				{
					u.setStatus(Status.inactive);
					this.userRepository.save(u);
				}else if(status.equals("inactive"))
				{
					u.setStatus(Status.active);
					this.userRepository.save(u);
				}
			}
			return "Success";		
		}
		catch (Exception e) 
		{
			log.error("Exception in Delete User ServiceImpl = {}",e);
		}
		return "Failed";
	}
	
	public List<User> getSearchUser(String ecode)
	{
		try
		{
			return this.userRepository.findByEmpCode(ecode);			
		}
		catch(Exception e)
		{
			log.error("Exception in Search User serviceimpl={}",e);
		}
		return null;
	}
	
	
	
	
//	public List<LivfastSerialNumber> getlivfast()
//	{
//		try
//		{
//			return this.livfat.findAll();			
//		}
//		catch(Exception e)
//		{
//			log.error("Exception in Search User serviceimpl={}",e);
//		}
//		return null;
//	}
}
