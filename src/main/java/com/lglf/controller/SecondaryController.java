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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.livfast.model.LivFastSchemeRequest;
import com.livfast.model.LivFastSecondaryScheme;
import com.livfast.service.LivFastSchemeService;
import com.livfast.service.LivFastSecondarySchemeService;
import com.livfast.utility.LivFastSecondaryCSVHelper;
import com.livguard.model.SchemeRequest;
import com.livguard.model.SecondaryScheme;
import com.livguard.service.SchemeService;
import com.livguard.service.SecondarySchemeService;
import com.livguard.utility.SecondaryCSVHelper;

@Controller
public class SecondaryController 
{
	private static final Logger log = LoggerFactory.getLogger(SecondaryController.class);

	@Autowired
	private SecondarySchemeService secondaryService;
	
	@Autowired
	private LivFastSecondarySchemeService secondaryLFService;
	
	@Autowired
	private SchemeService schemeService;
	
	@Autowired
	private LivFastSchemeService schemeLFService;

	
	@RequestMapping("/uploadSecondary")
	public String secondaryModelList(Model model,HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			log.info("Secondary Controller....");
			List<LivFastSecondaryScheme> secondaryList = this.secondaryLFService.getSecondarySchemeList();
			List<LivFastSchemeRequest> schemeList = this.schemeLFService.activeSecondarySchemeList();
			model.addAttribute("secondaryList", secondaryList);
			model.addAttribute("schemeList", schemeList);
			model.addAttribute("secondary", new SecondaryScheme());
			return "upload_secondary_model";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			log.info("Secondary Controller....");
			List<SecondaryScheme> secondaryList = this.secondaryService.getSecondarySchemeList();
			List<SchemeRequest> schemeList = this.schemeService.activeSecondarySchemeList();
			model.addAttribute("secondaryList", secondaryList);
			model.addAttribute("schemeList", schemeList);
			model.addAttribute("secondary", new SecondaryScheme());
			return "upload_secondary_model";
		}
		return "error";
	}

	@PostMapping("/uploadSecondaryModel")
	public ModelAndView uploadSecondaryFile(@RequestParam("file") MultipartFile file, @RequestParam("schemeId") int id, HttpSession session) 
	{
		ModelAndView mav = new ModelAndView("redirect:/uploadSecondary");
		if(session.getAttribute("database").equals("Livfast"))
		{
			if (LivFastSecondaryCSVHelper.hasCSVFormat(file)) 
			{
				System.out.println("entered if c");
				try 
				{
					System.out.println("Entered Try c");
					this.secondaryLFService.saveSecondaryScheme(file, id);
					mav.addObject("msg", "Uploaded Secondary Model successfully: " + file.getOriginalFilename());
				}catch (Exception e) 
				{
					System.out.println("Entered Catch c");
					mav.addObject("msg", "Could not upload the file: " + file.getOriginalFilename() + "!");
				}
			}
			else
			{
				System.out.println("Entered else c");
				mav.addObject("msg", "Please upload a csv file!");
			}
			return mav;
		}
		else if(session.getAttribute("database").equals("Livguard"))
		{
			if (SecondaryCSVHelper.hasCSVFormat(file)) 
			{
				System.out.println("entered if c");
				try 
				{
					System.out.println("Entered Try c");
					this.secondaryService.saveSecondaryScheme(file, id);
					mav.addObject("msg", "Uploaded Secondary Model successfully: " + file.getOriginalFilename());
				}catch (Exception e) 
				{
					System.out.println("Entered Catch c");
					mav.addObject("msg", "Could not upload the file: " + file.getOriginalFilename() + "!");
				}
			}
			else
			{
				System.out.println("Entered else c");
				mav.addObject("msg", "Please upload a csv file!");
			}
			return mav;
			
		}
		return mav;
	}

	@RequestMapping(value = "/editSecondaryModel", method = RequestMethod.POST)
	public String editSecondaryScheme(@ModelAttribute("secondary") SecondaryScheme secondary,HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			LivFastSecondaryScheme LFScheme = new LivFastSecondaryScheme();
			LFScheme.setId(secondary.getId());
			LFScheme.setProductName(secondary.getProductName());
			LFScheme.setLoyaltyPoints(secondary.getLoyaltyPoints());
			LFScheme.setBrandName(secondary.getBrandName());
			LFScheme.setBatterySchemeId(secondary.getBatterySchemeId());
			LFScheme.setProductDesc(secondary.getProductDesc());
			LFScheme.setRange(secondary.getRange());
			this.secondaryLFService.editSecondaryScheme(LFScheme);
			return "redirect:/uploadSecondary";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			this.secondaryService.editSecondaryScheme(secondary);
			return "redirect:/uploadSecondary";			
		}
		return "error";
	}

//	@RequestMapping("/deleteSecondaryModel/{id}")
//	public String deleteSecondaryModel(@PathVariable(name = "id") int id,HttpSession session) 
//	{
//		if(session.getAttribute("database").equals("Livfast"))
//		{
//			this.secondaryLFService.deleteSecondaryScheme(id);
//			return "redirect:/uploadSecondary";
//		}else if(session.getAttribute("database").equals("Livguard"))
//		{
//			this.secondaryService.deleteSecondaryScheme(id);
//			return "redirect:/uploadSecondary";			
//		}
//		return "error";
//
//	}
	
	
	@RequestMapping(value = "/searchSecondaryModel", method = RequestMethod.POST)
	public String searchSecondaryModel(@RequestParam(value = "bmodal")String bmodal, Model model, HttpSession session)
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			List<LivFastSecondaryScheme> secondaryList=this.secondaryLFService.getSecondaryModel(bmodal);
			if(secondaryList != null)
			{
				model.addAttribute("secondaryList", secondaryList);
				model.addAttribute("secondary", new SecondaryScheme());
				return "upload_secondary_model";
			}else
			{
				System.out.println("Else Section controller"+bmodal);
				model.addAttribute("","The value against "+bmodal+" not found");
				return "redirect:/upload_secondary_model";
			}
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			List<SecondaryScheme> secondaryList=this.secondaryService.getSecondaryModel(bmodal);
			if(secondaryList != null)
			{
				model.addAttribute("secondaryList", secondaryList);
				model.addAttribute("secondary", new SecondaryScheme());
				return "upload_secondary_model";
			}else
			{
				System.out.println("Else Section controller"+bmodal);
				model.addAttribute("","The value against "+bmodal+" not found");
				return "redirect:/upload_secondary_model";
			}
			
		}
		return "error";
	}
	
}
