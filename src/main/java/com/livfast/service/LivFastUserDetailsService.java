package com.livfast.service;

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
import com.livfast.repository.LivFastUserRepository;
import com.livguard.model.Status;

@Service
@Transactional("secondaryTransactionManager")
public class LivFastUserDetailsService 
{
	private static final Logger log = LoggerFactory.getLogger(LivFastUserDetailsService.class); 
	
	@Autowired
	LivFastUserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;	

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username, String password) 
    {
    	System.out.println("Password :: "+bCryptPasswordEncoder.encode(password));
    	LivFastUser user = userRepository.findByEmailAndPassword(username, password);
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new org.springframework.security.core.userdetails.User(user.getEmpCode(), user.getPassword(), grantedAuthorities);
    }
	
	
	public LivFastUser checkUser(String email, String password)
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
	
	public List<LivFastUser> getUserList()
	{
		try
		{
			return (List<LivFastUser>) this.userRepository.findAll();
		}
		catch (Exception e) 
		{
			log.error("Exception in Get User List ServiceImpl = {}",e);
		}
		return null;
	}
	
	
	
	public String saveUser(LivFastUser user)
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
				user.setStatus(Status.active);
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
	
	public String editUser(LivFastUser user)
	{
		try
		{
			Optional<LivFastUser> u = this.userRepository.findById(user.getId());
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
	
	public String deleteUser(int id)
	{
		try
		{			
			this.userRepository.deleteById(id);
			return "Success";		
		}
		catch (Exception e) 
		{
			log.error("Exception in Delete User ServiceImpl = {}",e);
		}
		return "Failed";
	}
	
	public List<LivFastUser> getSearchUser(String ecode)
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
	
	public LivFastUser userResetEmailExistanceCheck(String email)
	{
		try 
		{
			return this.userRepository.findByEmail(email);
		} 
		catch (Exception e) 
		{
			log.error("Exception in userResetEmailExistanceCheck User serviceimpl={}",e);
		}
		return null;
	}
}
