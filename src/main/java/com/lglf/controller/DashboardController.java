package com.lglf.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.livfast.model.LivFastMonthlySlabs;

import com.livfast.service.LivFastAnalysisService;
import com.livguard.model.MonthlySlabs;
import com.livguard.model.DTOModel.ActiveInActiveUser;
import com.livguard.model.DTOModel.ScanningAnalysis;
import com.livguard.model.DTOModel.SchemeAnalysis;
import com.livguard.model.DTOModel.SchemeAvailable;
import com.livguard.model.DTOModel.SchemeSelector;
import com.livguard.model.DTOModel.SerialNumberScanningAnalysis;
import com.livguard.model.DTOModel.Top10Scheme;
import com.livguard.model.DTOModel.UserAnalysis;
import com.livguard.service.AnalysisService;
import com.mongodsc.model.Data;
import com.mongodsc.model.DistributerScoreCard;
import com.mongodsc.service.DistributerScoreCardService;

import java.text.ParseException;
import java.util.List;

import org.springframework.ui.Model;

@Controller
public class DashboardController 
{
	private static final Logger log = LoggerFactory.getLogger(DashboardController.class);

	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	AnalysisService analysis;
	
	@Autowired
	LivFastAnalysisService analysisLF;
	
	@Autowired
	DistributerScoreCardService dscService;
	
	@RequestMapping(value="/dashboard",method = RequestMethod.GET)
	public String analyticData(Model model,HttpSession session) throws ParseException
	{
		try {
		if(session.getAttribute("database").equals("Livfast"))
		{
			//Analysiing User
			List<UserAnalysis> userAnalysis = this .analysisLF.userAnalysedRegisteredPerDate();	
			model.addAttribute("registeredUserAnalysis",userAnalysis);
			
			//Active Secondary and Active Tertiary Analysis
			List<SchemeAnalysis> schemeAnalysis = this.analysisLF.schemeActiveAvailable();
			model.addAttribute("schemeActiveAnalysis",schemeAnalysis);
		
//			Map<String,List<?>> scheme = this.analysisLF.procedureCall();
//			model.addAttribute("serialAnalysis",scheme.get("serialnumberscan"));
			
//			List<ScanningAnalysis> scanningAnalysis = this.analysisLF.userMaximumScanned();
//			model.addAttribute("schemeScanning",scanningAnalysis);
			
			//scanning serial number analysis
			List<SerialNumberScanningAnalysis> serialAnalysis = this.analysisLF.serialNumberScanning();
			log.info("serial Analysis={}",mapper.writeValueAsString(serialAnalysis));
			model.addAttribute("serialAnalysis",serialAnalysis);
			
			//User Active Inactive
			List<ActiveInActiveUser> actInactAnalysis = this.analysisLF.userActiveInActiveAcordingToMonth();
			model.addAttribute("actInactUser",actInactAnalysis);
			
			//Top 10 Scanned Scheme
			List<Top10Scheme> topTen = this.analysisLF.findTop10SchemeScanner();
			model.addAttribute("topTen",topTen);
			
			//Monthly Slab
			List<SchemeSelector> bIS = this.analysisLF.fetchingBatterySchemeId();
			List<LivFastMonthlySlabs> msResult = this.analysisLF.findAllDataWithBatterySchemeId();
			log.info("SchemeSelector={}",mapper.writeValueAsString(msResult));
			log.info("MOnthly Slabs={}",mapper.writeValueAsString(bIS));
			model.addAttribute("monthlySlabData", msResult);
			model.addAttribute("batterySchemeID",bIS);
			
//			List<SchemeAvailable> sSA = this.analysisLF.secondarySchemeAvailable();
//			model.addAttribute("secSchemeCount", sSA);
			
//			List<SchemeAvailable> tSA = this.analysisLF.tertiarySchemeAvailable();
//			model.addAttribute("tertSchemeCount", tSA);
			
			//IB/UPS/ERICK/TOTAL
			int total = 0,ib= 0,erick = 0,ups = 0;
			List<Object[]> record = this.analysisLF.recordCountFetch();
			log.info("Record is={}",mapper.writeValueAsString(record));
			for(Object[] ob:record)
			{
				try {
					total = Integer.parseInt(ob[0].toString());
					}catch(NullPointerException e)
					{
						total = 0;
					}
					try {
						ib = Integer.parseInt(ob[1].toString());
					}catch (NullPointerException e) {
						ib = 0;
					}
					try {
						ups = Integer.parseInt(ob[3].toString());
					}catch(NullPointerException e)
					{
						ups = 0;
					}
					try {
					erick = Integer.parseInt(ob[2].toString());
					}catch(NullPointerException e)
					{
						erick = 0;
					}
			}			
			model.addAttribute("totRecordIBUPSERICK",total);
			model.addAttribute("totRecordIB",ib);
			model.addAttribute("totRecordUPS",ups);
			model.addAttribute("totRecordERICK",erick);
			
			//This Month Scanned Schemes
			List<Top10Scheme> scannedScheme = this.analysisLF.findTopSchemeScanner();
			model.addAttribute("totalSchemeScan",scannedScheme);
			
			List<Data> data = this.dscService.getScoreCard();
			model.addAttribute("report", data);
			
			//Returning controller to index
			return "index";
		}else if(session.getAttribute("database").equals("Livguard"))
		{
			//Analysiing User
			List<UserAnalysis> userAnalysis = this.analysis.userAnalysedRegisteredPerDate();
			model.addAttribute("registeredUserAnalysis",userAnalysis);
			
			//Active Secondary and Active Tertiary Analysis
			List<SchemeAnalysis> schemeAnalysis = this.analysis.schemeActiveAvailable();
			model.addAttribute("schemeActiveAnalysis",schemeAnalysis);
			
//			//Scanning Scheme
//			List<ScanningAnalysis> scanningAnalysis = this.analysis.userMaximumScanned();
//			model.addAttribute("schemeScanning",scanningAnalysis);
			
			//scanning serial number analysis
			List<SerialNumberScanningAnalysis> serialAnalysis = this.analysis.serialNumberScanning();
			model.addAttribute("serialAnalysis",serialAnalysis);
			
			//User Active Inactive
			List<ActiveInActiveUser> actInactAnalysis = this.analysis.userActiveInActiveAcordingToMonth();
			model.addAttribute("actInactUser",actInactAnalysis);
			
			//Top 10 Scanned Scheme
			List<Top10Scheme> topTen = this.analysis.findTop10SchemeScanner();
			model.addAttribute("topTen",topTen);
			
			//Monthly Slab
			List<SchemeSelector> bIS = this.analysis.fetchingBatterySchemeId();
			List<MonthlySlabs> msResult = this.analysis.findAllDataWithBatterySchemeId();
			log.info("SchemeSelector={}",mapper.writeValueAsString(msResult));
			log.info("MOnthly Slabs={}",mapper.writeValueAsString(bIS));
			model.addAttribute("monthlySlabData", msResult);
			model.addAttribute("batterySchemeID",bIS);
	
//			//Secondary scheme available
//			List<SchemeAvailable> sSA = this.analysis.secondarySchemeAvailable();
//			model.addAttribute("secSchemeCount", sSA);
//			
//			//tertiary Scheme Available
//			List<SchemeAvailable> tSA = this.analysis.tertiarySchemeAvailable();
//			model.addAttribute("tertSchemeCount", tSA);
//			
			//IB/UPS/ERICK/TOTAL
			int total = 0,ib= 0,erick = 0,ups = 0;
			List<Object[]> record=this.analysis.recordCountFetch();
			log.info("Record is={}",mapper.writeValueAsString(record));
			for(Object[] ob:record)
			{
				try {
				total = Integer.parseInt(ob[0].toString());
				}catch(NullPointerException e)
				{
					total = 0;
				}
				try {
					ib = Integer.parseInt(ob[1].toString());
				}catch (NullPointerException e) {
					ib = 0;
				}
				try {
					ups = Integer.parseInt(ob[3].toString());
				}catch(NullPointerException e)
				{
					ups = 0;
				}
				try {
				erick = Integer.parseInt(ob[2].toString());
				}catch(NullPointerException e)
				{
					erick = 0;
				}
			}			
			model.addAttribute("totRecordIBUPSERICK",total);
			model.addAttribute("totRecordIB",ib);
			model.addAttribute("totRecordUPS",ups);
			model.addAttribute("totRecordERICK",erick);
			
			
			
			//This Month Scanned Schemes
			List<Top10Scheme> scannedScheme = this.analysis.findTopSchemeScanner();
			model.addAttribute("totalSchemeScan",scannedScheme);

			List<Data> data = this.dscService.getScoreCard();
			model.addAttribute("report", data);
			
			//Returning controller to index			
			return "index";
		}
		return null;	
		}catch (Exception e) 
		{
			log.error("Exception in dash board controller{}=>",e);
		}
		return "index";
	}
}
