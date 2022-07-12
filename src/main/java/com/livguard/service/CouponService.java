package com.livguard.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.livguard.model.Coupon;
import com.livguard.model.Status;
import com.livguard.repository.CouponRepository;
import com.livguard.utility.CouponCSVHelper;


@Service
@Transactional("primaryTransactionManager")
public class CouponService
{
	private static final Logger log = LoggerFactory.getLogger(CouponService.class); 
	
	@Autowired
	CouponRepository couponRepository;
	
	public String saveCoupon(MultipartFile file)
	{
		try 
		{	
			List<Coupon> couponList = CouponCSVHelper.csvToTutorials(file.getInputStream());
			this.couponRepository.saveAll(couponList);
			return "Success";
		}
		catch (Exception e) 
		{
			log.error("Exception in Save Coupon ServiceImpl = {}", e);
		}
		return "Failed";
	}
	
	public List<Coupon> couponList() 
	{
		try 
		{
			List<Coupon> listCoupon = this.couponRepository.getCouponList();
			return listCoupon;
		}
		catch (Exception e) 
		{
			log.error("Exception in Get List Coupon ServiceImpl = {}", e);
		}
		return null;
	}
	
	public String editCoupon(Coupon coupon)
	{
		try
		{
			Coupon cc = this.couponRepository.findById(coupon.getId());
			if(cc != null)
			{		
				cc.setCouponText(coupon.getCouponText());
				cc.setRedeemStatus(coupon.getRedeemStatus());
				cc.setStatus(Status.active);
				cc.setUserId(coupon.getUserId());
				cc.setUserName(coupon.getUserName());
				this.couponRepository.save(cc);
				return "Success";
			}
		}
		catch (Exception e) 
		{
			log.error("Exception in Edit Coupon ServiceImpl ={}", e);
		}
		return "Failed";
	}
	
	public Coupon getCoupon(int id)
	{
		try
		{
			return this.couponRepository.findById(id);
		}
		catch (Exception e) 
		{
			log.error("Exception in Get Coupon ServiceImpl ={}", e);
		}
		return null;
	}
	
	public String deactivateCoupon(int id)
	{
		try
		{
			Coupon coupon = this.couponRepository.findById(id);
			if(coupon != null)
			{
				String status = coupon.getStatus().toString();
				if(status.equals("active"))
				{
					coupon.setStatus(Status.inactive);
					this.couponRepository.save(coupon);

				}else if(status.equals("inactive"))
				{
					coupon.setStatus(Status.active);
					this.couponRepository.save(coupon);
				}
			}
		}
		catch (Exception e) 
		{
			log.error("Exception in Delete Coupon ServiceImpl ={}", e);
		}
		return "Failed";
	}
	
	public List<Coupon> getSearchCoupon(String uname)
	{		
		try
		{
			return this.couponRepository.findByCouponText(uname);
		}
		catch(Exception e)
		{
			log.error("Exception in Search Coupon serviceimpl={}",e);
		}
		return null;
	}
}
