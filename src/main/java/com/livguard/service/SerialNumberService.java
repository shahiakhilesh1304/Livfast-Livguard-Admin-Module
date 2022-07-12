package com.livguard.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.livguard.model.SerialNumber;
import com.livguard.model.Status;
import com.livguard.repository.SerialNumberRepository;
import com.livguard.utility.SerialNumberCSVHelper;

@Service
@Transactional("primaryTransactionManager")
public class SerialNumberService 
{
	private static final Logger log = LoggerFactory.getLogger(SerialNumberService.class); 
	@Autowired
	private SerialNumberRepository serialNumberRepository;
	
	public String saveSerialNumber(MultipartFile file)
	{
		try 
		{	
			List<SerialNumber> serialList = SerialNumberCSVHelper.csvToTutorials(file.getInputStream());
			this.serialNumberRepository.saveAll(serialList);
			return "Success";
		}
		catch (Exception e) 
		{
			log.error("Exception in Save Serial Number Service Method = {}", e);
		}
		return "Failed";
	}
	
	public List<SerialNumber> getSerialNumberList() 
	{
		try 
		{
			//Pageable paging = PageRequest.of(1, 10, Sort.by("id"));
			//Page<SerialNumber> pp = this.serialNumberRepository.findAll(paging);
			//return pp.getContent();
			List<SerialNumber> serialList = this.serialNumberRepository.getSerialNumberList();
			return serialList;
		}
		catch (Exception e) 
		{
			log.error("Exception in Get List Serial Number Service Method = {}", e);
		}
		return null;
	}
	
	public String editSecondaryScheme(SerialNumber serialNumber)
	{
		try
		{
			SerialNumber ss = this.serialNumberRepository.findById(serialNumber.getId());
			if(ss != null)
			{
				ss.setSerialNumber(serialNumber.getSerialNumber());
				this.serialNumberRepository.save(ss);
				return "Success";
			}
		}
		catch (Exception e) 
		{
			log.error("Exception in Edit Serial Number Service ={}", e);
		}
		return "Failed";
	}
	
	public String deactivateSerialNumber(int id)
	{
		try
		{
			SerialNumber sno = this.serialNumberRepository.findById(id);
			if(sno != null)
			{
				String status = sno.getStatus().toString();
				if(status.equals("active"))
				{
					sno.setStatus(Status.inactive);
					this.serialNumberRepository.save(sno);
				}else if(status.equals("inactive"))
				{
					sno.setStatus(Status.active);
					this.serialNumberRepository.save(sno);
				}
			}
			return "Success";
		}
		catch (Exception e) 
		{
			log.error("Exception in Delete Serial Number Service ={}", e);
		}
		return "Failed";
	}
	
	
	public List<SerialNumber> getSerialNumber(String sno)
	{		
		try
		{
			return this.serialNumberRepository.findBySerialNumber(sno);
		}
		catch(Exception e)
		{
			log.error("Exception in Search Serial Number serviceimpl={}",e);
		}
		return null;
	}
	
}
