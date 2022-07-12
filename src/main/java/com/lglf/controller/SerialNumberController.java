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

import com.livfast.model.LivfastSerialNumber;
import com.livfast.service.LivfastSerialNumberService;
import com.livfast.utility.LivFastSerialNumberCSVHelper;
import com.livguard.model.SerialNumber;
import com.livguard.service.SerialNumberService;
import com.livguard.utility.SerialNumberCSVHelper;

@Controller
public class SerialNumberController 
{
	private static final Logger log = LoggerFactory.getLogger(SerialNumberController.class);
	
	@Autowired
	private SerialNumberService serialService;
	
	@Autowired
	private LivfastSerialNumberService serialLFService;
	
	@RequestMapping("/serialnumber")
	public String showSerialNumber(Model model,HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			log.info("Tertiary Controller....");
			List<LivfastSerialNumber> serialList = this.serialLFService.getSerialNumberList();
			model.addAttribute("serialList", serialList);
			model.addAttribute("serial", new SerialNumber());
			return "serial_number";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			log.info("Tertiary Controller....");
			List<SerialNumber> serialList = this.serialService.getSerialNumberList();
			model.addAttribute("serialList", serialList);
			model.addAttribute("serial", new SerialNumber());
			return "serial_number";			
		}	
		return "error";
	}
	
	@PostMapping("/uploadSerialNumber")
	public ModelAndView uploadSerialNumberFile(@RequestParam("file") MultipartFile file,HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/serialnumber");
		if(session.getAttribute("database").equals("Livfast"))
		{
			if (LivFastSerialNumberCSVHelper.hasCSVFormat(file)) {
				try {
					this.serialLFService.saveSerialNumber(file);
					mav.addObject("msg", "Uploaded Serial Number successfully: " + file.getOriginalFilename());
				} catch (Exception e) {
					mav.addObject("msg", "Could not upload the file: " + file.getOriginalFilename() + "!");
				}
			} else {
				mav.addObject("msg", "Please upload a csv file!");
			}
			return mav;
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			if (SerialNumberCSVHelper.hasCSVFormat(file)) {
				try {
					this.serialService.saveSerialNumber(file);
					mav.addObject("msg", "Uploaded Serial Number successfully: " + file.getOriginalFilename());
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

	
	@RequestMapping(value = "/editSerialNumber", method = RequestMethod.POST)
	public String editSerialNumber(@ModelAttribute("serial") SerialNumber serial,HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			LivfastSerialNumber LFsno = new LivfastSerialNumber();;
			LFsno.setId(serial.getId());
			LFsno.setSerialNumber(serial.getSerialNumber());
			LFsno.setStatus(serial.getStatus());
			LFsno.setEntryDate(serial.getEntryDate());
			this.serialLFService.editSecondaryScheme(LFsno);
			return "redirect:/serialnumber";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			this.serialService.editSecondaryScheme(serial);
			return "redirect:/serialnumber";			
		}
		return "error";
	}

	@RequestMapping("/deactivateSerialNumber/{id}")
	public String deactivateSerialNumber(@PathVariable(name = "id") int id,HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{	
			this.serialLFService.deactivateSerialNumber(id);
			return "redirect:/serialnumber";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			this.serialService.deactivateSerialNumber(id);
			return "redirect:/serialnumber";			
		}
		return "error";
	}
	
	@RequestMapping(value="/searchSerialNumber",method = RequestMethod.POST)
	public String searchSerialNumber(@RequestParam(value = "sno")String sno, Model model,HttpSession session)
	{
		if(session.getAttribute("database").equals("Livfast"))
		{		
			List<LivfastSerialNumber> serialList=this.serialLFService.getSerialNumber(sno);
			if(serialList != null )
			{
				model.addAttribute("serialList", serialList);
				model.addAttribute("serial", new SerialNumber());
				return "serial_number";
			}else
			{
				System.out.println("Else Section controller"+sno);
				model.addAttribute("couponList","The value against "+sno+" not found");
				return "redirect:/serial_number";
			}
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			List<SerialNumber> serialList=this.serialService.getSerialNumber(sno);
			if(serialList != null )
			{
				model.addAttribute("serialList", serialList);
				model.addAttribute("serial", new SerialNumber());
				return "serial_number";
			}else
			{
				System.out.println("Else Section controller"+sno);
				model.addAttribute("couponList","The value against "+sno+" not found");
				return "redirect:/serial_number";
			}
			
		}
		return "error";
	}
}
