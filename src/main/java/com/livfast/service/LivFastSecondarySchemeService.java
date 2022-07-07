package com.livfast.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.livfast.model.LivFastSecondaryScheme;
import com.livfast.repository.LivFastSecondarySchemeRepository;
import com.livfast.utility.LivFastSecondaryCSVHelper;

@Service
@Transactional("secondaryTransactionManager")
public class LivFastSecondarySchemeService
{
	private static final Logger log = LoggerFactory.getLogger(LivFastSecondarySchemeService.class); 
	
	@Autowired
	LivFastSecondarySchemeRepository secondarySchemeRepository;
	
	public String saveSecondaryScheme(MultipartFile file, int id)
	{
		try 
		{	
			List<LivFastSecondaryScheme> secondaryList = LivFastSecondaryCSVHelper.csvToTutorials(file.getInputStream(), id);
			this.secondarySchemeRepository.saveAll(secondaryList);
			return "Success";
		}
		catch (Exception e) 
		{
			log.error("Exception in Save Secondary Scheme Service = {}", e);
		}
		return "Failed";
	}
	
	public List<LivFastSecondaryScheme> secondarySchemeList()
	{
		try 
		{			
			System.out.println("In LiovFastSecondaryScheme"+this.secondarySchemeRepository.getSecondaryList());
			return this.secondarySchemeRepository.findAll(); 
		}
		catch (Exception e) 
		{
			log.error("Exception in Get List Secondary Scheme Service = {}", e);
		}
		return null;
	}
	
	public String editSecondaryScheme(LivFastSecondaryScheme secondaryScheme)
	{
		try
		{
			Optional<LivFastSecondaryScheme> ss = this.secondarySchemeRepository.findById(secondaryScheme.getId());
			if(ss.get() != null)
			{
				ss.get().setBatterySchemeId(secondaryScheme.getBatterySchemeId());
				ss.get().setBrandName(secondaryScheme.getBrandName());
				ss.get().setLoyaltyPoints(secondaryScheme.getLoyaltyPoints());
				ss.get().setProductDesc(secondaryScheme.getProductDesc());
				ss.get().setProductName(secondaryScheme.getProductName());
				ss.get().setRange(secondaryScheme.getRange());
				this.secondarySchemeRepository.save(ss.get());
				return "Success";
			}
		}
		catch (Exception e) 
		{
			log.error("Exception in Edit Secondary Scheme Service ={}", e);
		}
		return "Failed";
	}
	
	public List<LivFastSecondaryScheme> getSecondarySchemeList()
	{
		try
		{
			return this.secondarySchemeRepository.getSecondaryList();
		}
		catch (Exception e) 
		{
			log.error("Exception in Get Secondary Scheme ServiceImpl ={}", e);
		}
		return null;
	}//9711034541
	
	public String deleteSecondaryScheme(int id)
	{
		try
		{
			this.secondarySchemeRepository.deleteById(id);
			return "Success";
		}
		catch (Exception e) 
		{
			log.error("Exception in Delete Secondary Scheme Service ={}", e);
		}
		return "Failed";
	}
	
	public List<LivFastSecondaryScheme> getSecondaryModel(String model)
	{
		try
		{
			return this.secondarySchemeRepository.findByProductName(model);
		}
		catch (Exception e) 
		{
			log.error("Exception in Search Secondary Scheme ServiceImpl ={}", e);
		}
		return null;
	}
}
