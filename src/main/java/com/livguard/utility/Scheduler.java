package com.livguard.utility;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mongodsc.model.Data;
import com.mongodsc.service.DistributerScoreCardService;
import com.opencsv.CSVWriter;

@Component
public class Scheduler {
	
	private static final Logger log = LoggerFactory.getLogger(Scheduler.class);
	
	
	@Autowired
	DistributerScoreCardService dscService;
	
	//@Scheduled(cron = "0 0 12 * * ?")
	public void CSVCreator()
	{
		String filePath = "/ReportCSV";
		try 
		{
			List<Data> report = this.dscService.getScoreCard();
			File file = new File(filePath);
			try 
			{
				 FileWriter outputfile = new FileWriter(file);
				 CSVWriter writer = new CSVWriter(outputfile);
				 String[] header = {"DB CODE","DB NAME","Category based on AOP TGT(IB/4w/Erick/2w/inv/Solar)",
						 "Primary Volume Weightage","Primary Value Weightage","WOD Weightage","SED Appointment Weightage","Fin. Control Weightage",
						 "Focus Product Weightage","IB TGT Weightage","4W TGT Weightage",
						 "Eric TGT Weightage","Inv TGT Weightage","2W TGT Weightage","Solar  TGT Weightage","IB TGT",
						 "4W TGT","Eric TGT","Inv TGT","2W TGT","Solar TGT","IB ACH","IB ACH %","IB Score","4W ACH","4W ACH %","4W Score",
						 "Eric ACH","Eric ACH %","Eric Score","Inv ACH","Inv ACH %","Inv Score","2W ACH","2W ACH%",
						 "2W Score","Solar ACH","Solar ACH %","Solar Score","WOD  TGT","WOD ACH","SED Appointment TGT","SED Appointment ACH",
						 "FC Outstanding without Solar","FC Outstanding with Solar","Total Gross OS > 45 Days",
						 "Total Gross OS >30 Days as on QTR End","Focus Product IB TGT","Focus Product 4W TGT","Focus Product Solar Value","IB > 36M Volume",
						 "4W - 35 ah 80/90/100ah Volume","RT above 3.5KVA Value","Total Score"};
				 writer.writeNext(header);
//				 for(Object[] ob : report)
//				 {
//					 
//				 }
				 
				 
			}catch (Exception e) {
				log.info("Exception occured while creating CSV file={}",e);
			}
		} catch (Exception e) 
		{
			log.error("Exception occured at the Scheduler = {}",e);
		}	
		 
		 
	}

}
