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
import com.livfast.model.LivFastTertiaryScheme;
import com.livfast.service.LivFastSchemeService;
import com.livfast.service.LivFastTertiaryServiceScheme;
import com.livfast.utility.LivFastTertiaryCSVHelper;
import com.livguard.model.SchemeRequest;
import com.livguard.model.TertiaryScheme;
import com.livguard.service.SchemeService;
import com.livguard.service.TertiaryServiceScheme;
import com.livguard.utility.TertiaryCSVHelper;

@Controller
public class TertiaryController {
	private static final Logger log = LoggerFactory.getLogger(TertiaryController.class);

	@Autowired
	TertiaryServiceScheme tertiaryService;

	@Autowired
	SchemeService schemeService;
	
	@Autowired
	LivFastTertiaryServiceScheme tertiaryLFService;

	@Autowired
	LivFastSchemeService schemeLFService;
	
	

	@RequestMapping("/uploadTertiary")
	public String tertiaryModelList(Model model,HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{		
			log.info("Tertiary Controller....");
			List<LivFastTertiaryScheme> tertiaryList = this.tertiaryLFService.getTertiarySchemeList();
			List<LivFastSchemeRequest> schemeList = this.schemeLFService.activeTertiarySchemeList();
			model.addAttribute("tertiaryList", tertiaryList);
			model.addAttribute("schemeList", schemeList);
			model.addAttribute("tertiary", new TertiaryScheme());
			return "upload_tertiary_model";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			log.info("Tertiary Controller....");
			List<TertiaryScheme> tertiaryList = this.tertiaryService.getTertiarySchemeList();
			List<SchemeRequest> schemeList = this.schemeService.activeTertiarySchemeList();
			model.addAttribute("tertiaryList", tertiaryList);
			model.addAttribute("schemeList", schemeList);
			model.addAttribute("tertiary", new TertiaryScheme());
			return "upload_tertiary_model";			
		}
		return "error";
	}

	@PostMapping("/uploadTertiaryModel")
	public ModelAndView uploadTertiaryFile(@RequestParam("file") MultipartFile file, @RequestParam("schemeId") int id,HttpSession session) 
	{
		ModelAndView mav = new ModelAndView("redirect:/uploadTertiary");
		if(session.getAttribute("database").equals("Livfast"))
		{			
			if (LivFastTertiaryCSVHelper.hasCSVFormat(file)) {
				try {
					this.tertiaryLFService.saveTertiaryScheme(file, id);
					mav.addObject("msg", "Uploaded Tertiary Model successfully: " + file.getOriginalFilename());
				} catch (Exception e) {
					mav.addObject("msg", "Could not upload the file: " + file.getOriginalFilename() + "!");
				}
			} else {
				mav.addObject("msg", "Please upload a csv file!");
			}
			return mav;
		}else if(session.getAttribute("database").equals("Livguard"))
		{		
			if (TertiaryCSVHelper.hasCSVFormat(file)) {
				try {
					this.tertiaryService.saveTertiaryScheme(file, id);
					mav.addObject("msg", "Uploaded Tertiary Model successfully: " + file.getOriginalFilename());
				} catch (Exception e) {
					mav.addObject("msg", "Could not upload the file: " + file.getOriginalFilename() + "!");
				}
			} else {
				mav.addObject("msg", "Please upload a csv file!");
			}
			return mav;			
		}
		return mav;

	}

	@RequestMapping(value = "/editTertiaryModel", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute("tertiary") TertiaryScheme tertiaryScheme,HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{			
			LivFastTertiaryScheme LFT = new LivFastTertiaryScheme(); 
			LFT.setId(tertiaryScheme.getId());
			LFT.setBatteryModel(tertiaryScheme.getBatteryModel());
			LFT.setCapacity(tertiaryScheme.getCapacity());
			LFT.setCreatedTimestamp(tertiaryScheme.getCreatedTimestamp());
			LFT.setFuel(tertiaryScheme.getFuel());
			LFT.setLivguardBrand(tertiaryScheme.getLivguardBrand());
			LFT.setPoints(tertiaryScheme.getPoints());
			LFT.setRange(tertiaryScheme.getRange());
			LFT.setSchemeId(tertiaryScheme.getSchemeId());
			LFT.setSegment(tertiaryScheme.getSegment());
			LFT.setState(tertiaryScheme.getState());
			LFT.setUpdatedTimestamp(tertiaryScheme.getUpdatedTimestamp());
			LFT.setVehicleManufacturer(tertiaryScheme.getVehicleManufacturer());
			LFT.setWarrantyMonth(tertiaryScheme.getWarrantyMonth());
			LFT.setVehicleModel(tertiaryScheme.getVehicleModel());
			LFT.setWithoutOtpPoint(tertiaryScheme.getWithoutOtpPoint());
			this.tertiaryLFService.editTertiaryScheme(LFT);
			return "redirect:/uploadTertiary";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			this.tertiaryService.editTertiaryScheme(tertiaryScheme);
			return "redirect:/uploadTertiary";
		}
		return "error";
			
	}

//	@RequestMapping("/deleteTertiaryModel/{id}")
//	public String deleteTertiaryModel(@PathVariable(name = "id") int id,HttpSession session) 
//	{
//		if(session.getAttribute("database").equals("Livfast"))
//		{	
//			
//			this.tertiaryLFService.deleteTertiaryScheme(id);
//			return "redirect:/uploadTertiary";
//		}else if(session.getAttribute("database").equals("Livguard"))
//		{
//			this.tertiaryService.deleteTertiaryScheme(id);
//			return "redirect:/uploadTertiary";			
//		}
//		return "error";
//	}
	
	
	@RequestMapping(value = "/searchTertiaryModel", method = RequestMethod.POST)
	public String searchTertiaryModel(@RequestParam(value = "bmodal")String bmodal, Model model,HttpSession session)
	{
		
		if(session.getAttribute("database").equals("Livfast"))
		{			
			List<LivFastTertiaryScheme> secondaryList=this.tertiaryLFService.getSearchTertiary(bmodal);
			if(secondaryList != null)
			{
				model.addAttribute("tertiaryList", secondaryList);
				model.addAttribute("tertiary", new TertiaryScheme());
				return "upload_tertiary_model";
			}else
			{
				System.out.println("Else Section controller"+bmodal);
				model.addAttribute("","The value against "+bmodal+" not found");
				return "redirect:/upload_tertiary_model";
			}
		}else if(session.getAttribute("database").equals("Livguard"))
		{			
			List<TertiaryScheme> secondaryList=this.tertiaryService.getSearchTertiary(bmodal);
			if(secondaryList != null)
			{
				model.addAttribute("tertiaryList", secondaryList);
				model.addAttribute("tertiary", new TertiaryScheme());
				return "upload_tertiary_model";
			}else
			{
				System.out.println("Else Section controller"+bmodal);
				model.addAttribute("","The value against "+bmodal+" not found");
				return "redirect:/upload_tertiary_model";
			}
			
		}
		return "error";

			
	}
	
	
}
