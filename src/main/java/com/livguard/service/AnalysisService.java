package com.livguard.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.livguard.model.MonthlySlabs;
import com.livguard.model.DTOModel.ActiveInActiveUser;
import com.livguard.model.DTOModel.ScanningAnalysis;
import com.livguard.model.DTOModel.SchemeAnalysis;
import com.livguard.model.DTOModel.SchemeAvailable;
import com.livguard.model.DTOModel.SchemeSelector;
import com.livguard.model.DTOModel.SerialNumberScanningAnalysis;
import com.livguard.model.DTOModel.Top10Scheme;
import com.livguard.model.DTOModel.UserAnalysis;
import com.livguard.repository.DealerProductRepository;
import com.livguard.repository.MonthlySlabRepository;
import com.livguard.repository.ScanningAnalysisRepository;
import com.livguard.repository.ScanningSerialNumber;
import com.livguard.repository.SchemeRepository;
import com.livguard.repository.UserRepository;

@Service
@Transactional("primaryTransactionManager")
public class AnalysisService 
{
	private static final Logger log = LoggerFactory.getLogger(AnalysisService.class); 
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	SchemeRepository schemeRepo;
	
	@Autowired
	ScanningAnalysisRepository scanRepo;
	
	@Autowired
	ScanningSerialNumber scanSRepo;
	
	@Autowired
	MonthlySlabRepository msRepo;
	
	@Autowired
	DealerProductRepository sSchemeRepo;
	
	ObjectMapper mapper = new ObjectMapper();
	
	//Return the month in words
	//method to convert numeric months into string
	private String monthName(int month) 
	{
		try {
		//declaring hashmap to store value
	      HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	      //putting value in hash map
	      hmap.put(1, "Jan");
	      hmap.put(2, "Feb");
	      hmap.put(3, "Mar");
	      hmap.put(4, "Apr");
	      hmap.put(5, "May");
	      hmap.put(6, "Jun");
	      hmap.put(7, "Jul");
	      hmap.put(8, "Aug");
	      hmap.put(9, "Sep");
	      hmap.put(10, "Oct");
	      hmap.put(11, "Nov");
	      hmap.put(12, "Dec");
	      //returning  string value
	      return hmap.get(month);
		}catch (Exception e) {
			log.error("Exception in  userAnalysedRegisteredPerDate=>",e);
		}
		return null;
	}
	
	public List<UserAnalysis> userAnalysedRegisteredPerDate() throws ParseException
	{
		try {
		//USE ANALYSIS
		List<Object[]> user = this.userRepo.getUserAnalysis();
		List<UserAnalysis> out = new ArrayList<>();
		if(user != null)
		{
			String date;
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			UserAnalysis ua;
			for(Object[] ob:user)
			{
				ua = new UserAnalysis();
				date = ob[0].toString();
				ua.setEntry_date(df.parse(date));
				ua.setUserNumber(Integer.parseInt(ob[1].toString()));
				out.add(ua);
			}
			return out;
		}
		return out;
	}catch (Exception e) {
		log.error("Exception in  userAnalysedRegisteredPerDate=>",e);
	}
	return null;
	}
	
	
	public List<SchemeAnalysis> schemeActiveAvailable()
	{
		try {
		List<Object[]> scheme = this.schemeRepo.findActiveTer_SecScheme();
		List<SchemeAnalysis> result = new ArrayList<>();
		SchemeAnalysis sa;
		if(scheme != null)
		{
			for(Object[] ob:scheme)
			{
				sa = new SchemeAnalysis();
				sa.setSchemeType(ob[0].toString());
				sa.setNumberOfScheme(Integer.parseInt(ob[1].toString()));
				result.add(sa);
			}
			return result;
		}
		return result;
	}catch (Exception e) {
		log.error("Exception in  schemeActiveAvailable=>",e);
	}
	return null;
	}
	
	
	public List<ScanningAnalysis> userMaximumScanned()
	{
		try {
		List<Object[]> scheme = this.scanRepo.findAllData();
		List<ScanningAnalysis> result = new ArrayList<>();
		ScanningAnalysis sa;
		int i=0;
		String imageLink;
		if(scheme != null) 
		{
			for(Object[] ob:scheme)
			{
				sa = new ScanningAnalysis();
				sa.setName(ob[0].toString()+" "+ob[1].toString());
				sa.setEmail(ob[2].toString());
				if(ob[3].toString() == null)
				{
					imageLink = "No Link";
				}else
				{
					imageLink = ob[3].toString();
				}
				sa.setImageLink(imageLink);
				sa.setPhone(ob[4].toString());
				sa.setUsername(ob[5].toString());
				sa.setTotalTerLoyalty(Integer.parseInt(ob[6].toString()));
				sa.setTotalSecLoyalty(Integer.parseInt(ob[7].toString())+Integer.parseInt(ob[8].toString()));
				result.add(sa);	
			}
			return result;
		}
		return result;
		}catch (Exception e) {
			log.error("Exception in  userMaximumScanned=>",e);
		}
		return null;
	}
	
	
	public List<SerialNumberScanningAnalysis> serialNumberScanning() throws ParseException, JsonProcessingException
	{
		try {
		List<Object[]> scheme = this.scanSRepo.findThisMonthScannedSerialNumber();
		log.info("Serial Scanning = {}",mapper.writeValueAsString(scheme));
		List<SerialNumberScanningAnalysis> result = new ArrayList<>();
		if(scheme != null)
		{
			SerialNumberScanningAnalysis ssa;
			for(Object[] ob:scheme)
			{
				ssa = new SerialNumberScanningAnalysis();
				ssa.setWeek(Integer.parseInt(ob[0].toString()));	
				try {
					ssa.setMonth(Integer.parseInt(ob[2].toString()));
				}catch(NumberFormatException e)
				{
					log.info("NUmber Format Exception occured // value of month is ={}",ob[2].toString());
					float a = Float.parseFloat(ob[2].toString());
					int b = (int)a;
					ssa.setMonth(b);
				}
				ssa.setNumberOfSerialNumber(Integer.parseInt(ob[1].toString()));
				result.add(ssa);
			}
			return result;
		}
		return result;
		}catch (Exception e) {
			log.info("Exception occured at serialNumberScanning in Livfast analysis service={}",e);
		}
		return null;
	}
	
	
//	public void procedureCall()
//	{
//		try {
//			log.info("Procedure value is ={}",this.scanSRepo.callProcedureDat());
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
		
	
	
	
	public List<ActiveInActiveUser> userActiveInActiveAcordingToMonth()
	{
		//USE ANALYSIS
				List<ActiveInActiveUser> out = new ArrayList<>();
				try {
				List<Object[]> actinactdata = this.userRepo.activeInactiveUser();
				if(actinactdata != null)
				{
					String month;
					ActiveInActiveUser au;
					for(Object[] ob:actinactdata)
					{
						au = new ActiveInActiveUser();
						try 
						{
							month = monthName(Integer.parseInt(ob[0].toString()));
							au.setMonth(month);
						}catch (NumberFormatException e) 
						{
							log.info("Number format exception occured value of month is ={}",ob[0].toString());
							float a = Float.parseFloat(ob[0].toString());
							int b = (int) a;
							au.setMonth(monthName(b));
						}
						au.setActive(Integer.parseInt(ob[1].toString()));
						au.setInActive(Integer.parseInt(ob[2].toString()));
						out.add(au);
					}
					return out;
				}
				}catch (Exception e) {
					log.error("Exception occured in userActiveInActiveAcordingToMonth at Livfast={}",e);
				}
				return out;	
	}
	
	//EXTRACT TOP 10 TERTIARY
	public List<Top10Scheme> findTop10SchemeScanner()
	{
		try {
		List<Object[]> scheme = this.scanRepo.findTop10SchemeScanned();
		List<Top10Scheme> result = new ArrayList<>();
		Top10Scheme sa;
		int i=0;
		String salePersonName;
		if(scheme != null) 
		{
			for(Object[] ob:scheme)
			{
				
				sa = new Top10Scheme();
				sa.setName(ob[0].toString()+" "+ob[1].toString());
				sa.setEmail(ob[2].toString());
				if(ob[3].toString() == null)
				{
					salePersonName = "Name Not Mentioned";
				}
				else
				{
					salePersonName = ob[3].toString();
				}
				sa.setSalesPersonName(salePersonName);
				sa.setPhone(ob[4].toString());
				sa.setUsername(ob[5].toString());
				sa.setTotalLoyalty(Integer.parseInt(ob[6].toString()));
				sa.setUserID(ob[7].toString());
				result.add(sa);	
				i++;
				if(i>10)
				{
					break;
				}
			}
			return result;
		}
		return result;
		}catch (Exception e) {
			log.error("Exception in  findTop10SchemeScanner=>",e);
		}
		return null;
	}
	
	
	//EXTRACT TOP 10 TERTIARY
		public List<Top10Scheme> findTopSchemeScanner()
		{
			try {
			List<Object[]> scheme = this.scanRepo.findTop10SchemeScanned();
			List<Top10Scheme> result = new ArrayList<>();
			Top10Scheme sa;
			String salePersonName;
			if(scheme != null) 
			{
				for(Object[] ob:scheme)
				{
					
					sa = new Top10Scheme();
					sa.setName(ob[0].toString()+" "+ob[1].toString());
			
					sa.setEmail(ob[2].toString());
					if(ob[3].toString() == null)
					{
						salePersonName = "Name Not Mentioned";
					}
					else
					{
						salePersonName = ob[3].toString();
					}
					sa.setSalesPersonName(salePersonName);
					sa.setPhone(ob[4].toString());
					sa.setUsername(ob[5].toString());
					sa.setTotalLoyalty(Integer.parseInt(ob[6].toString()));
					sa.setUserID(ob[7].toString());
					result.add(sa);	
				}
				return result;
			}
			return result;
			}catch (Exception e) {
				log.error("Exception in  findTop10SchemeScanner=>",e);
			}
			return null;
		}
	

	
	
	//find all the offers with these battery scheme
	public List<MonthlySlabs> findAllDataWithBatterySchemeId()
	{
		try 
		{	
			List<MonthlySlabs> msResult = this.msRepo.findAllDataWithCommonBatteryScheme();
			return msResult;
			
		}catch (Exception e) {
			log.error("Exception While fetching the common data in between monthly slab and battery scheme");
		}
		return null;
	}
	
	//find all the offers with these battery scheme
	public List<MonthlySlabs> fetchDataWithId(int id)
		{
			try 
			{	
				List<MonthlySlabs> msResult = this.msRepo.findAllDataWithCommonBatterySchemeId(id);
				return msResult;		
			}catch (Exception e) {
				log.error("Exception While fetching the common data in between monthly slab and battery scheme");
			}
			return null;
		}
	
	
	
	//fetch the battery scheme id
	public List<SchemeSelector> fetchingBatterySchemeId()
	{
		try 
		{
			List<Object[]> scID = this.msRepo.batterySchemeIdWithMonthlySlabs();
			List<SchemeSelector> selector = new ArrayList<>();
			if(scID != null)
			{
				SchemeSelector sid = new SchemeSelector();
				for(Object[] ob:scID)
				{
					sid = new SchemeSelector();
					sid.setId(ob[0].toString());
					sid.setScheme_name(ob[1].toString());
					selector.add(sid);
				}
				return selector;
			}
		}catch (Exception e) 
		{
			log.error("Exception in fetchingBatterySchemeId=>{}",e);
		}
		return null;
	}
	
	
	public List<SchemeAvailable> secondarySchemeAvailable()
	{
		try 
		{
			List<Object[]> sSA = this.sSchemeRepo.checkDataAvailaibilitySecondary();
			List<SchemeAvailable> result = new ArrayList<>();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			SchemeAvailable ssA;
			String date;
			if(sSA != null)
			{
				for(Object[] ob:sSA)
				{
					ssA = new SchemeAvailable();
					date = ob[0].toString();
					ssA.setCreatedTime(df.parse(date));
					ssA.setCount(Integer.parseInt(ob[1].toString()));
					result.add(ssA);
				}
				return result; 
			}
		}catch (Exception e) 
		{
			log.error("Exception in secondarySchemeAvailable={}",e);
		}
		return null;
	}
	
	
//	public List<SchemeAvailable> tertiarySchemeAvailable()
//	{
//		try 
//		{
//			List<Object[]> sSA = this.scanSRepo.checkDataAvailaibilityTert();
//			List<SchemeAvailable> result = new ArrayList<>();
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//			SchemeAvailable ssA;
//			String date;
//			if(sSA != null)
//			{
//				for(Object[] ob:sSA)
//				{
//					ssA = new SchemeAvailable();
//					date = ob[0].toString();
//					ssA.setCreatedTime(df.parse(date));
//					ssA.setCount(Integer.parseInt(ob[1].toString()));
//					result.add(ssA);
//				}
//				return result; 
//			}
//		}catch (Exception e) 
//		{
//			log.error("Exception in tertiarySchemeAvailable={}",e);
//		}
//		return null;
//	}
//	
	

	public List<Object[]> recordCountFetch() 
	{
		try {
			List<Object[]> ob = this.scanSRepo.recordData();
			log.info("Report is={}",mapper.writeValueAsString(ob));
			return ob;
		}catch(Exception e) 
		{			
			log.error("Exception occured at recordCountFetch = {}",e);
		}
		return null;
	}

	
	
	
//	public int totalRecord()
//	{
//		try 
//		{
//			int record = this.scanSRepo.totalRecord();
//			return record;
//		}catch (Exception e) {
//			log.error("Exception in totalRecord={}",e);
//		}
//		return 0;
//	}
//	
//	public int totalIBRecord()
//	{
//		try 
//		{
//			int record = this.scanSRepo.totalIB();
//			return record;
//		}catch (Exception e) {
//			log.error("Exception in totalRecord={}",e);
//		}
//		return 0;
//	}
//	
//	public int totalERICKRecord()
//	{
//		try 
//		{
//			int record = this.scanSRepo.totalErick();
//			return record;
//		}catch (Exception e) {
//			log.error("Exception in totalRecord={}",e);
//		}
//		return 0;
//	}
//	
//	public int totalUPSRecord()
//	{
//		try 
//		{
//			int record = this.scanSRepo.totalUPS();
//			return record;
//		}catch (Exception e) {
//			log.error("Exception in totalRecord={}",e);
//		}
//		return 0;
//	}
//	
	
	
	
	
	
	
}
