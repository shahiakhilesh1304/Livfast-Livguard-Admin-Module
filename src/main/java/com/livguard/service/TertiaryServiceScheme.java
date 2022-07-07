package com.livguard.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.livguard.model.TertiaryScheme;
import com.livguard.repository.TertiarySchemeRepository;
import com.livguard.utility.TertiaryCSVHelper;

@Service
@Transactional("primaryTransactionManager")
public class TertiaryServiceScheme
{
private static final Logger log = LoggerFactory.getLogger(TertiaryServiceScheme.class); 
	
	@Autowired
	TertiarySchemeRepository tertiarySchemeRepository;
	
	public String saveTertiaryScheme(MultipartFile file, int id)
	{
		try 
		{	
			List<TertiaryScheme> tertiaryList = TertiaryCSVHelper.csvToTutorials(file.getInputStream(), id);
			this.tertiarySchemeRepository.saveAll(tertiaryList);
			return "Success";
		}
		catch (Exception e) 
		{
			log.error("Exception in Save Tertiary Scheme ServiceImpl = {}", e);
		}
		return "Failed";
	}
	
	public String editTertiaryScheme(TertiaryScheme tertiaryScheme)
	{
		try
		{
			//TertiaryScheme ts  = this.tertiarySchemeRepository.findByBatteryModel(tertiaryScheme.getBatteryModel());
			Optional<TertiaryScheme> ts  = this.tertiarySchemeRepository.findById(tertiaryScheme.getId());
			if(ts.get() != null)
			{
				ts.get().setVehicleManufacturer(tertiaryScheme.getVehicleManufacturer());
				ts.get().setUpdatedTimestamp(new Date());
				ts.get().setSegment(tertiaryScheme.getSegment());
				ts.get().setVehicleModel(tertiaryScheme.getVehicleModel());
				ts.get().setFuel(tertiaryScheme.getFuel());
				ts.get().setCapacity(tertiaryScheme.getCapacity());
				ts.get().setLivguardBrand(tertiaryScheme.getLivguardBrand());
				ts.get().setBatteryModel(tertiaryScheme.getBatteryModel());
				ts.get().setWarrantyMonth(tertiaryScheme.getWarrantyMonth());
				ts.get().setRange(tertiaryScheme.getRange());
				ts.get().setPoints(tertiaryScheme.getPoints());
				ts.get().setState(tertiaryScheme.getState());
				ts.get().setSchemeId(tertiaryScheme.getSchemeId());
				ts.get().setWithoutOtpPoint(tertiaryScheme.getWithoutOtpPoint());
				this.tertiarySchemeRepository.save(ts.get());
				return "Success";
			}
		}
		catch (Exception e) 
		{
			log.error("Exception in Edit Tertiary Scheme ServiceImpl ={}", e);
		}
		return "Failed";
	}
	
	public List<TertiaryScheme> getTertiarySchemeList()
	{
		try
		{
			return this.tertiarySchemeRepository.getTertiaryList();
		}
		catch (Exception e) 
		{
			log.error("Exception in Get Tertiary Scheme ServiceImpl ={}", e);
		}
		return null;
	}
	
	public String deleteTertiaryScheme(int id)
	{
		try
		{
			this.tertiarySchemeRepository.deleteById(id);
			return "Success";
		}
		catch (Exception e) 
		{
			log.error("Exception in Delete Tertiary Scheme ServiceImpl ={}", e);
		}
		return "Failed";
	}
	
	public List<TertiaryScheme> getSearchTertiary(String model)
	{
		try
		{
			return this.tertiarySchemeRepository.findByBatteryModel(model);
		}
		catch (Exception e) 
		{
			log.error("Exception in Search Tertiary Models ServiceImpl ={}", e);
		}
		return null;
	}
}
