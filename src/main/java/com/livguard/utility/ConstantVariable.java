package com.livguard.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.livguard.api.AppWebSecurityConfigurer;
import com.livguard.api.WebConfiguration;


public class ConstantVariable 
{
	private static final Logger log = LoggerFactory.getLogger(ConstantVariable.class);
	public static final String PHP_API_URL;
	public static final String USERNAME;
	public static final String PASSWORD;
	public static final String ADD_DEALER;
	public static final String ADDDEALER_USERNAME;
	public static final String ADDDEALER_PASSWORD;
	
	
	static
	{
		log.info("Initializing ConstantVariables : {}", WebConfiguration.env);
		PHP_API_URL = WebConfiguration.env.getProperty("DsCardUrl");
		USERNAME = WebConfiguration.env.getProperty("Username");
		PASSWORD = WebConfiguration.env.getProperty("Password");
		ADD_DEALER = WebConfiguration.env.getProperty("dealerSaveApi");
		ADDDEALER_USERNAME = WebConfiguration.env.getProperty("addDealerusername");
		ADDDEALER_PASSWORD = WebConfiguration.env.getProperty("addDealerPassword");

	}
}
