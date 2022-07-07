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
import com.livfast.model.LivFastCoupon;
import com.livfast.service.LivFastCouponService;
import com.livfast.utility.LivFastCouponCSVHelper;
import com.livguard.model.Coupon;
import com.livguard.service.CouponService;
import com.livguard.utility.CouponCSVHelper;

@Controller
public class CouponController 
{
private static final Logger log = LoggerFactory.getLogger(CouponController.class);
	
	@Autowired
	CouponService couponService;
	
	@Autowired
	LivFastCouponService couponLFService;

	
	@RequestMapping("/coupon")
	public String showCoupon(Model model,HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			log.info("Tertiary Controller....");
			List<LivFastCoupon> couponList = this.couponLFService.couponList();
			model.addAttribute("couponList", couponList);
			model.addAttribute("coupon", new Coupon());
			return "coupon";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			log.info("Tertiary Controller....");
			List<Coupon> couponList = this.couponService.couponList();
			model.addAttribute("couponList", couponList);
			model.addAttribute("coupon", new Coupon());
			return "coupon";			
		}
		return "error";
	}
	
	@PostMapping("/uploadcoupon")
	public ModelAndView uploadCouponFile(@RequestParam("file") MultipartFile file, HttpSession session) 
	{
		ModelAndView mav = new ModelAndView("redirect:/coupon");
		if(session.getAttribute("database").equals("Livfast"))
		{
			if (LivFastCouponCSVHelper.hasCSVFormat(file)) {
				try {
					this.couponLFService.saveCoupon(file);
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
			//ModelAndView mav = new ModelAndView("redirect:/coupon");
			if (CouponCSVHelper.hasCSVFormat(file)) {
				try {
					this.couponService.saveCoupon(file);
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

	@RequestMapping(value = "/editcoupon", method = RequestMethod.POST)
	public String editCoupon(@ModelAttribute("coupon") Coupon coupon, HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			LivFastCoupon coup = new LivFastCoupon();
			coup.setId(coupon.getId());
			coup.setUserId(coupon.getUserId());
			coup.setUserName(coupon.getUserName());
			coup.setStatus(coupon.getStatus());
			coup.setCouponScratchDate(coupon.getCouponScratchDate());
			coup.setCouponText(coupon.getCouponText());
			coup.setCreatedTimestamp(coupon.getCreatedTimestamp());
			coup.setRedeemStatus(coupon.getRedeemStatus());
			this.couponLFService.editCoupon(coup);
			return "redirect:/coupon";
		}
		else if(session.getAttribute("database").equals("Livguard"))
		{
			this.couponService.editCoupon(coupon);
			return "redirect:/coupon";
		}
		return "error";
	}

	@RequestMapping("/deletecoupon/{id}")
	public String deleteCoupon(@PathVariable(name = "id") int id, HttpSession session) 
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			this.couponLFService.deleteCoupon(id);
			return "redirect:/coupon";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			this.couponService.deleteCoupon(id);
			return "redirect:/coupon";	
		}
		return "error";
	}
	
	
	
	
	@RequestMapping(value="/searchCoupon",method = RequestMethod.POST)
	public String searchCoupon(@RequestParam(value = "uname")String uname, Model model, HttpSession session)
	{
		if(session.getAttribute("database").equals("Livfast"))
		{
			List<LivFastCoupon> couponList=this.couponLFService.getSearchCoupon(uname);
			if(couponList != null )
			{
				model.addAttribute("couponList", couponList);
				model.addAttribute("coupon", new Coupon());
				return "coupon";
			}else
			{
				System.out.println("Else Section controller"+uname);
				model.addAttribute("couponList","The value against "+uname+" not found");
				return "redirect:/coupon";
			}
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			List<Coupon> couponList=this.couponService.getSearchCoupon(uname);
			if(couponList != null )
			{
				model.addAttribute("couponList", couponList);
				model.addAttribute("coupon", new Coupon());
				return "coupon";
			}else
			{
				System.out.println("Else Section controller"+uname);
				model.addAttribute("couponList","The value against "+uname+" not found");
				return "redirect:/coupon";
			}
		}
		return "error";
	}
}
