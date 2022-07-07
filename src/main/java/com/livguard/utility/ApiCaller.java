package com.livguard.utility;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.livguard.model.DTOModel.StatusResponse;


@Service
public class ApiCaller
{
	
	ObjectMapper mapper = new ObjectMapper();
	private static final Logger log = LoggerFactory.getLogger(ApiCaller.class);
	
//	public String dscPHPAPI(String json)
//	{
//		try {
//			log.info("Send API Json={}",json);
//			String authString =ConstantVariable.USERNAME+":"+ConstantVariable.PASSWORD;
//			 String authEncBytes = Base64.getEncoder().encodeToString(authString.getBytes());
//	         String authStringEnc = new String(authEncBytes);
//			String strURL = ConstantVariable.PHP_API_URL;
//			URL url = new URL(strURL);
//			HttpURLConnection con = (HttpURLConnection) url.openConnection();
//			con.setRequestMethod("POST");
//            con.setRequestProperty("Content-Type","application/json");      
//            con.setRequestProperty("Accept", "application/json");
//            con.setRequestProperty("Authorization", "Basic " + authStringEnc);
//            con.setDoOutput(true);
//            con.setConnectTimeout(120000);
//            con.setReadTimeout(300000);
//            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//            wr.writeBytes(json);
//            wr.flush();
//            wr.close();
//            int responseCode = con.getResponseCode();
//            log.info("Sending 'POST' Request to URL :: " + url.getQuery()+" :: Response Code :: "+responseCode);
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String output="";
//            StringBuffer response = new StringBuffer();
//            while ((output = in.readLine()) != null) 
//                response.append(output);
//            in.close();
//			log.info("Sent data to SAP Response={}", response);
//			return response.toString();
//		} catch (Exception e) {
//			log.error("Exception ocured at dscPHPAPI at ApiCaller={}",e);
//		}
//		return "";
//	}
//	
	
	StatusResponse sta  = null;
	
	public StatusResponse saveDealerAPI(String json)
	{
		sta = new StatusResponse();
		try 
		{
			//log.info("Send API Json={}",json);
			String authString =ConstantVariable.ADDDEALER_USERNAME+":"+ConstantVariable.ADDDEALER_PASSWORD;
			String authEncBytes = Base64.getEncoder().encodeToString(authString.getBytes());
	        String authStringEnc = new String(authEncBytes);
			String strURL = ConstantVariable.ADD_DEALER;
			URL url = new URL(strURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type","application/json");      
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Authorization", "Basic " + authStringEnc);
            con.setDoOutput(true);
            con.setConnectTimeout(120000);
            con.setReadTimeout(300000);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(json);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            log.info("Sending 'POST' Request to URL :: " + url.getQuery()+" :: Response Code :: "+responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output="";
            StringBuffer response = new StringBuffer();
            while ((output = in.readLine()) != null) 
                response.append(output);
            in.close();
			log.info("Sent data to Response={}", response);
			String data = response.toString();
			log.info("Sent data to data={}", data);
			sta = new Gson().fromJson(data, StatusResponse.class);
			StatusResponse status = new StatusResponse();
			status.setMsg(sta.getMsg());
			status.setStatus(sta.getStatus());
			log.info("Sent data to status={}",mapper.writeValueAsString(status));
			return status;
		} catch (Exception e) 
		{
			log.error("Exception ocured at saveDealerAPI at ApiCaller={}",e);
			sta.setStatus("500");
			sta.setMsg("Internal Server Error");
			return sta;
		}
	}
	
}
