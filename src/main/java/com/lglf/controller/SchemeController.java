package com.lglf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.livfast.model.LivFastSchemeRequest;
import com.livfast.model.LivfastSerialNumber;
import com.livfast.service.LivFastSchemeService;
import com.livfast.service.LivfastSerialNumberService;
import com.livguard.model.SchemeRequest;
import com.livguard.model.SerialNumber;
import com.livguard.service.SchemeService;
import com.livguard.service.SerialNumberService;

@Controller
public class SchemeController 
{
private static final Logger log = LoggerFactory.getLogger(SchemeController.class);
	
	@Autowired
	private SchemeService schemeService;
	 
    @Autowired
    private LivfastSerialNumberService livfastSerialNumberService;
    
    @Autowired
    private SerialNumberService serialNumberService;
    
    @Autowired
    private LivFastSchemeService schemeLFService;

    ObjectMapper mapper = new ObjectMapper();
	
	
	//Tertiary Scheme Part
	@RequestMapping("/schemeTertiaryScheme")
	public String showNewProductPage(Model model, HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			log.info("Tertiary Scheme Controller");
			List<LivFastSchemeRequest> schemeList = this.schemeLFService.activeTertiarySchemeList();					
	        String state = this.schemeLFService.getTeritaryStateList();
			model.addAttribute("schemeList", schemeList);
			model.addAttribute("scheme", new SchemeRequest());		
			model.addAttribute("state", state);
			return "scheme";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			log.info("Tertiary Scheme Controller");
			List<SchemeRequest> schemeList = this.schemeService.activeTertiarySchemeList();			
	        String state = this.schemeService.getTeritaryStateList();
			model.addAttribute("schemeList", schemeList);
			model.addAttribute("scheme", new SchemeRequest());		
			model.addAttribute("state", state);
			return "scheme";
		}
		return "error";

	}
	
	
	
	@RequestMapping(value = "/saveTertiaryScheme", method = RequestMethod.POST)
	public String saveTertitaryScheme(@ModelAttribute("scheme") SchemeRequest scheme,HttpSession session) throws JsonProcessingException 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			log.info("Save Tertiary Scheme");
		    
		    LivFastSchemeRequest schemeLFRequest = new LivFastSchemeRequest();
			schemeLFRequest.setSchemeName(scheme.getSchemeName());
			schemeLFRequest.setConversionRatio(scheme.getConversionRatio());
			schemeLFRequest.setCreatedTimestamp(scheme.getCreatedTimestamp());
			schemeLFRequest.setEndTimestamp(scheme.getEndTimestamp());
			schemeLFRequest.seteRickShaw(scheme.geteRickShaw());
			schemeLFRequest.setFourW(scheme.getFourW());
			schemeLFRequest.setIbUPS(scheme.getIbUPS());
			schemeLFRequest.setIsManual(scheme.getIsManual());
			schemeLFRequest.setSchemeDetail(scheme.getSchemeDetail());
			schemeLFRequest.setSchemeScandate(scheme.getSchemeScandate());
			schemeLFRequest.setSchemeState(scheme.getSchemeState());
			schemeLFRequest.setStartTimestamp(scheme.getStartTimestamp());
			log.info("Tertiary scehem to be saved={}",mapper.writeValueAsString(schemeLFRequest));
			this.schemeLFService.saveScheme(schemeLFRequest);	
			return "redirect:/schemeTertiaryScheme";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			log.info("Save Tertiary Scheme");
			this.schemeService.saveScheme(scheme);	
			return "redirect:/schemeTertiaryScheme";
		}
		return "error";

	}
	
	
	@RequestMapping(value = "/editTertiaryScheme", method = RequestMethod.POST)
	public String editTertiaryScheme(@ModelAttribute("scheme") SchemeRequest scheme,HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			log.info("Edit Tertiary Scheme");
		    
		    LivFastSchemeRequest schemeLFRequest = new LivFastSchemeRequest();
			schemeLFRequest.setId(scheme.getId());
			schemeLFRequest.setSchemeName(scheme.getSchemeName());
			schemeLFRequest.setConversionRatio(scheme.getConversionRatio());
			schemeLFRequest.setCreatedTimestamp(scheme.getCreatedTimestamp());
			schemeLFRequest.setEndTimestamp(scheme.getEndTimestamp());
			schemeLFRequest.seteRickShaw(scheme.geteRickShaw());
			schemeLFRequest.setFourW(scheme.getFourW());
			schemeLFRequest.setIbUPS(scheme.getIbUPS());
			schemeLFRequest.setIsManual(scheme.getIsManual());
			schemeLFRequest.setSchemeDetail(scheme.getSchemeDetail());
			schemeLFRequest.setSchemeScandate(scheme.getSchemeScandate());
			schemeLFRequest.setSchemeState(scheme.getSchemeState());
			schemeLFRequest.setStartTimestamp(scheme.getStartTimestamp());
			this.schemeLFService.editScheme(schemeLFRequest);	
			return "redirect:/schemeTertiaryScheme";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			this.schemeService.editScheme(scheme);	
			return "redirect:/schemeTertiaryScheme";
		}
		return "error";
	}
	
//	@RequestMapping("/deleteTertiaryScheme/{id}")
//	public String deleteProduct(@PathVariable(name = "id") int id,HttpSession session) 
//	{
//		if(session.getAttribute("database").equals("Livfast"))
//		{
//			log.info("Delete Tertiary Scheme");
//			this.schemeLFService.deleteScheme(id);
//			return "redirect:/schemeTertiaryScheme";		
//		}else if(session.getAttribute("database").equals("Livguard"))
//		{
//			log.info("Delete Tertiary Scheme");
//			this.schemeService.deleteScheme(id);
//			return "redirect:/schemeTertiaryScheme";					
//		}
//		return "error";
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	////////////SECONDARY
	/*	
	*	
	* @author Secondary Scheme	
	*	from here the Secondary SCheme is started
	*	
	*/	
	//Secondary SCheme Part
	@RequestMapping("/schemeSecondaryScheme")
	public String showSecondaryScheme(Model model, HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{		
			log.info("Secondary Scheme Controller");
			List<LivFastSchemeRequest> schemeList = this.schemeLFService.activeSecondarySchemeList();
			String state = this.schemeLFService.getSecondaryStateList();
			model.addAttribute("schemeList", schemeList);
			model.addAttribute("scheme", new SchemeRequest());	
			model.addAttribute("state", state);	
			return "scheme_secondary";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			log.info("Secondary Scheme Controller");
			List<SchemeRequest> schemeList = this.schemeService.activeSecondarySchemeList();
			String state = this.schemeService.getSecondaryStateList();
			model.addAttribute("schemeList", schemeList);
			model.addAttribute("scheme", new SchemeRequest());	
			model.addAttribute("state", state);	
			return "scheme_secondary";
			
		}
		return "error";
	}
	
	
	
	@RequestMapping(value = "/editSecondaryScheme", method = RequestMethod.POST)
	public String editSecondaryScheme(@ModelAttribute("scheme") SchemeRequest scheme,HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{		
			log.info("Edit Secondary Scheme");
		    
		    LivFastSchemeRequest schemeLFRequest = new LivFastSchemeRequest();
			schemeLFRequest.setId(scheme.getId());
			schemeLFRequest.setSchemeName(scheme.getSchemeName());
			schemeLFRequest.setConversionRatio(scheme.getConversionRatio());
			schemeLFRequest.setCreatedTimestamp(scheme.getCreatedTimestamp());
			schemeLFRequest.setEndTimestamp(scheme.getEndTimestamp());
			schemeLFRequest.seteRickShaw(scheme.geteRickShaw());
			schemeLFRequest.setFourW(scheme.getFourW());
			schemeLFRequest.setIbUPS(scheme.getIbUPS());
			schemeLFRequest.setIsManual(scheme.getIsManual());
			schemeLFRequest.setSchemeDetail(scheme.getSchemeDetail());
			schemeLFRequest.setSchemeScandate(scheme.getSchemeScandate());
			schemeLFRequest.setSchemeState(scheme.getSchemeState());
			schemeLFRequest.setStartTimestamp(scheme.getStartTimestamp());
			this.schemeLFService.editScheme(schemeLFRequest);	
			return "redirect:/schemeSecondaryScheme";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			log.info("Edit Secondary Scheme");
			this.schemeService.editScheme(scheme);	
			return "redirect:/schemeSecondaryScheme";			
		}
		return "error";
	}
	
	@RequestMapping(value = "/saveSecondaryScheme", method = RequestMethod.POST)
	public String saveSecondaryScheme(@ModelAttribute("scheme") SchemeRequest scheme,HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{		
			log.info("Edit Secondary Scheme");
		    
		    LivFastSchemeRequest schemeLFRequest = new LivFastSchemeRequest();
		//	schemeLFRequest.setId(scheme.getId());
			schemeLFRequest.setSchemeName(scheme.getSchemeName());
			schemeLFRequest.setConversionRatio(scheme.getConversionRatio());
			schemeLFRequest.setCreatedTimestamp(scheme.getCreatedTimestamp());
			schemeLFRequest.setEndTimestamp(scheme.getEndTimestamp());
			schemeLFRequest.seteRickShaw(scheme.geteRickShaw());
			schemeLFRequest.setFourW(scheme.getFourW());
			schemeLFRequest.setIbUPS(scheme.getIbUPS());
			schemeLFRequest.setIsManual(scheme.getIsManual());
			schemeLFRequest.setSchemeDetail(scheme.getSchemeDetail());
			schemeLFRequest.setSchemeScandate(scheme.getSchemeScandate());
			schemeLFRequest.setSchemeState(scheme.getSchemeState());
			schemeLFRequest.setStartTimestamp(scheme.getStartTimestamp());
			this.schemeLFService.saveScheme(schemeLFRequest);	
			return "redirect:/schemeSecondaryScheme";
			
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			log.info("Edit Secondary Scheme");
			this.schemeService.saveScheme(scheme);	
			return "redirect:/schemeSecondaryScheme";		
		}
		return "error";	
	}
	
//	@RequestMapping("/deleteSecondaryScheme/{id}")
//	public String deleteSecondaryScheme(@PathVariable(name = "id") int id,HttpSession session) 
//	{
//		if(session.getAttribute("database").equals("Livfast"))
//		{		
//			log.info("Delete Secondary Scheme");
//			String schemeType = "Secondary";
//			this.schemeLFService.deleteScheme(id,schemeType);
//			return "redirect:/schemeSecondaryScheme";		
//		}else if(session.getAttribute("database").equals("Livguard"))
//		{
//			log.info("Delete Secondary Scheme");
//			String schemeType = "Secondary";
//			this.schemeService.deleteScheme(id,schemeType);
//			return "redirect:/schemeSecondaryScheme";		
//			
//		}
//		return "error";
//	}
}
