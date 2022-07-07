package com.powertuff.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.livguard.model.DTOModel.DealerRequest;
import com.livguard.model.DTOModel.StatusResponse;
import com.livguard.utility.ApiCaller;

@Service
public class DealerService 
{
	@Autowired
	ApiCaller apiCall;
	
	private static final Logger log = LoggerFactory.getLogger(DealerService.class);
	
	ObjectMapper mapper = new ObjectMapper();
	StatusResponse status = null;
	
	public StatusResponse saveDealer(DealerRequest request)
	{
		try
		{
			status = new StatusResponse();
			status = this.apiCall.saveDealerAPI(new Gson().toJson(request));	   
			log.info("\n\nThe Report data is :{}",mapper.writeValueAsString(status));
			return status;
		} catch (Exception e) {
			log.info("Exception occured in saveDealer at DealerService={}",e);
			status.setStatus("500");
			status.setMsg("Internal Server Error");
			return status;
		}
	}
}
