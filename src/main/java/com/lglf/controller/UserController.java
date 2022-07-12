package com.lglf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.livfast.model.LivFastUser;
import com.livfast.service.LivFastUserDetailsService;
import com.livguard.model.User;
import com.livguard.service.SecurityService;
import com.livguard.service.UserDetailsServiceCust;
@Controller
public class UserController 
{
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDetailsServiceCust userService;
	
	@Autowired
	private LivFastUserDetailsService userLFService;
	
	@Autowired
	private SecurityService securityService;
	 
	@Autowired
	private LivFastUser lfUser ;
	
	ObjectMapper mapper = new ObjectMapper();
	//private final SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout, HttpSession session) {
		log.info("Login Controller..."+session.getId());
        if (securityService.isAuthenticated()) 
        {       
        		return "redirect:/dashboard";
        }
        System.out.println("Login Condition");        
        System.out.println("Session Value Controller: "+session.getAttribute("database"));

        if (error != null)
        {
        	System.out.println("Error happened"+error.getBytes());
        	model.addAttribute("error", "Your username and password is invalid.");
        }
        if (logout != null)
        {
        	System.out.println("LogOut");
        	model.addAttribute("message", "You have been logged out successfully.");
        }
        return "login";
    }
	
	
	@RequestMapping("/user")
	public String showNewProductPage(Model model,HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			List<LivFastUser> userList = this.userLFService.getUserList();
			model.addAttribute("session",session);
			model.addAttribute("userList", userList);
			model.addAttribute("user", new User());		
			return "user";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			List<User> userList = this.userService.getUserList();
			model.addAttribute("session",session);
			model.addAttribute("userList", userList);
			model.addAttribute("user", new User());		
			return "user";	
		}
		return "error";
	}
	
	
//	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUsers(@Valid @ModelAttribute("user") User user, BindingResult error, Model model, HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			lfUser.setId(user.getId());
			lfUser.setName(user.getName());
			lfUser.setRole(user.getRole());
			lfUser.setEmail(user.getEmail());
			lfUser.setEmpCode(user.getEmpCode());
			lfUser.setMsisdn(user.getMsisdn());
			lfUser.setEntryDate(user.getEntryDate());
			lfUser.setStatus(user.getStatus());
			lfUser.setPassword(user.getPassword());
			this.userLFService.saveUser(lfUser);	
			return "redirect:/user";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			this.userService.saveUser(user);
			return "redirect:/user";
		}
		return "error";
	
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String editUsers(@ModelAttribute("user") User user, HttpSession session)
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
//			System.out.println("Edited----- The Data"+user.getId());
			lfUser.setId(user.getId());
			lfUser.setName(user.getName());
			lfUser.setRole(user.getRole());
			lfUser.setEmail(user.getEmail());
			lfUser.setEmpCode(user.getEmpCode());
			lfUser.setMsisdn(user.getMsisdn());
			lfUser.setEntryDate(user.getEntryDate());
			lfUser.setStatus(user.getStatus());
			lfUser.setPassword(user.getPassword());
			this.userLFService.editUser(lfUser);
			return "redirect:/user";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			this.userService.editUser(user);
			return "redirect:/user";
		}
		return "error";
	}
	
	
	@RequestMapping(value = "deactivateUser/{empCode}", method = RequestMethod.GET)
	public String deactivateUsers(@ModelAttribute("empCode") int empCode, HttpSession session)
	{
		   
       
        if(session.getAttribute("database").equals("Livfast"))
		{
			this.userLFService.deactivateUser(empCode);
			return "redirect:/user";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			this.userService.deactivateUser(empCode);
			return "redirect:/user";
		}
        return "error";
	}
	
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("user") User user, HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			if(user.getEmail()!= null && user.getPassword() != null)
			{
				LivFastUser uu = userLFService.checkUser(user.getEmail(), user.getPassword());
				if(uu != null)
					return "redirect:/home";
				else
					return "redirect:/";
			}
			else
				return "redirect:/";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			if(user.getEmail()!= null && user.getPassword() != null)
			{
				User uu = userService.checkUser(user.getEmail(), user.getPassword());
				if(uu != null)
					return "redirect:/home";
				else
					return "redirect:/";
			}
			else
				return "redirect:/";
		    
		}
		return "error";
	}
	
	@RequestMapping(value="/searchUser",method = RequestMethod.POST)
	public String searchUser(@RequestParam(value = "ecode")String ecode, Model model,HttpSession session)
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			List<LivFastUser> userList=this.userLFService.getSearchUser(ecode);
			if(userList != null )
			{
				model.addAttribute("userList", userList);
				model.addAttribute("user", new User());
				return "user";
			}else
			{
				System.out.println("Else Section controller"+ecode);
				model.addAttribute("couponList","The value against "+ecode+" not found");
				return "redirect:/user";
			}
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			List<User> userList=this.userService.getSearchUser(ecode);
			if(userList != null )
			{
				model.addAttribute("userList", userList);
				model.addAttribute("user", new User());
				return "user";
			}else
			{
				System.out.println("Else Section controller"+ecode);
				model.addAttribute("couponList","The value against "+ecode+" not found");
				return "redirect:/user";
			}
		}
		return "error";
	}
}
