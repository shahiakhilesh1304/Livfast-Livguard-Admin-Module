package com.livguard.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.livguard.model.SecondaryScheme;



public class SecondaryCSVHelper 
{
	public static String TYPE = "text/csv";
	//public static String TYPE ="application/vnd.ms-excel";
	static String[] HEADERs = {"product_name", "brand_name", "range", "loyalty_points"};

	public static boolean hasCSVFormat(MultipartFile file) 
	{
		System.out.println("CSV Type :: "+file.getContentType());
		if (!TYPE.equals(file.getContentType())) 
		{
			System.out.println("csv Validation Failed");
			return false;
		}
		return true;
	}

	public static List<SecondaryScheme> csvToTutorials(InputStream is, int schemeID) 
	{
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) 
		{
			System.out.println("Entered Try H");
			List<SecondaryScheme> listCoupon = new ArrayList<SecondaryScheme>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) 
			{
				System.out.println("In for loop h");
				SecondaryScheme secondaryScheme = new SecondaryScheme(csvRecord.get("product_name"), csvRecord.get("brand_name"), csvRecord.get("range"), "",Integer.parseInt(csvRecord.get("loyalty_points")), schemeID);
				System.out.println("passed");
				listCoupon.add(secondaryScheme);
			}
			System.out.println("Loop exit");
			return listCoupon;
		} 
		catch (IOException e) 
		{
			System.out.println("Catch h");
			throw new RuntimeException("fail to parse Secondary CSV file: " + e.getMessage());
		}
	}
}