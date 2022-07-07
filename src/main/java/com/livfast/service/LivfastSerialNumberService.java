package com.livfast.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.livfast.model.LivfastSerialNumber;
import com.livfast.repository.LivfastSerialNumberRepository;
import com.livfast.utility.LivFastSerialNumberCSVHelper;
import com.livguard.model.Status;


@Service
@Transactional("secondaryTransactionManager")
public class LivfastSerialNumberService 
{
	private static final Logger log = LoggerFactory.getLogger(LivfastSerialNumberService.class); 
	@Autowired
	private LivfastSerialNumberRepository livfastSerialNumberRepository;
	
	public String saveSerialNumber(MultipartFile file)
	{
		try 
		{	
			List<LivfastSerialNumber> serialList = LivFastSerialNumberCSVHelper.csvToTutorials(file.getInputStream());
			this.livfastSerialNumberRepository.saveAll(serialList);
			return "Success";
		}
		catch (Exception e) 
		{
			log.error("Exception in LivFast Save Serial Number Service Method = {}", e);
		}
		return "Failed";
	}
	
	public List<LivfastSerialNumber> getSerialNumberList() 
	{
		try 
		{
			//Pageable paging = PageRequest.of(1, 10, Sort.by("id"));
			//Page<SerialNumber> pp = this.serialNumberRepository.findAll(paging);
			//return pp.getContent();
			List<LivfastSerialNumber> serialList = this.livfastSerialNumberRepository.getSerialNumberList();
			return serialList;
		}
		catch (Exception e) 
		{
			log.error("Exception in LivFast Get List Serial Number Service Method = {}", e);
		}
		return null;
	}
	
	public String editSecondaryScheme(LivfastSerialNumber serialNumber)
	{
		try
		{
			LivfastSerialNumber ss = this.livfastSerialNumberRepository.findById(serialNumber.getId());
			if(ss != null)
			{
				ss.setSerialNumber(serialNumber.getSerialNumber());
				ss.setStatus(Status.active);
				this.livfastSerialNumberRepository.save(ss);
				return "Success";
			}
		}
		catch (Exception e) 
		{
			log.error("Exception in LivFast Edit Serial Number Service ={}", e);
		}
		return "Failed";
	}
	
	public String deleteSerialNumber(int id)
	{
		try
		{
			this.livfastSerialNumberRepository.deleteById(id);
			return "Success";
		}
		catch (Exception e) 
		{
			log.error("Exception in LivFast Delete Serial Number Service ={}", e);
		}
		return "Failed";
	}
	
	
	public List<LivfastSerialNumber> getSerialNumber(String sno)
	{		
		try
		{
			return this.livfastSerialNumberRepository.findBySerialNumber(sno);
		}
		catch(Exception e)
		{
			log.error("Exception in LivFast Search Serial Number serviceimpl={}",e);
		}
		return null;
	}
	
}