package com.livfast.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.livfast.model.LivFastCoupon;
import com.livguard.model.Status;
import com.livfast.repository.LivFastCouponRepository;
import com.livfast.utility.LivFastCouponCSVHelper;


@Service
@Transactional("secondaryTransactionManager")
public class LivFastCouponService
{
	private static final Logger log = LoggerFactory.getLogger(LivFastCouponService.class); 
	
	@Autowired
	LivFastCouponRepository couponRepository;
	
	public String saveCoupon(MultipartFile file)
	{
		try 
		{	
			List<LivFastCoupon> couponList = LivFastCouponCSVHelper.csvToTutorials(file.getInputStream());
			this.couponRepository.saveAll(couponList);
			return "Success";
		}
		catch (Exception e) 
		{
			log.error("Exception in Save Coupon ServiceImpl = {}", e);
		}
		return "Failed";
	}
	
	public List<LivFastCoupon> couponList() 
	{
		try 
		{
			List<LivFastCoupon> listCoupon = this.couponRepository.getCouponList();
			return listCoupon;
		}
		catch (Exception e) 
		{
			log.error("Exception in Get List Coupon ServiceImpl = {}", e);
		}
		return null;
	}
	
	public String editCoupon(LivFastCoupon coupon)
	{
		try
		{
			LivFastCoupon cc = this.couponRepository.findById(coupon.getId());
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
	
	public LivFastCoupon getCoupon(int id)
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
			LivFastCoupon coupon = this.couponRepository.findById(id);
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
	
	public List<LivFastCoupon> getSearchCoupon(String uname)
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
