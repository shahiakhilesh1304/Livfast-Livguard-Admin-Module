package com.livguard.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.livguard.model.TertiaryScheme;

public class TertiaryCSVHelper 
{
	public static String TYPE = "text/csv";
	//public static String TYPE ="application/vnd.ms-excel";
	static String[] HEADERs = {"segment", "vehicle_model", "fuel", "capacity", "battery_model","warranty_month","range","points","without_otp_point"};

	public static boolean hasCSVFormat(MultipartFile file) 
	{
		System.out.println("CSV Type :: "+file.getContentType().equals(TYPE));
		if (!TYPE.equals(file.getContentType())) 
		{
			return false;
		}
		return true;
	}

	public static List<TertiaryScheme> csvToTutorials(InputStream is, int schemeID) 
	{
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) 
		{
			List<TertiaryScheme> listTertiary = new ArrayList<TertiaryScheme>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) 
			{
				TertiaryScheme tertiaryScheme = new TertiaryScheme("LIVGUARD", new Date(), new Date(), csvRecord.get("segment"), 
					csvRecord.get("vehicle_model").toUpperCase(), csvRecord.get("fuel"), Integer.parseInt(csvRecord.get("capacity")), "LIVGUARD", 
					csvRecord.get("battery_model").toUpperCase(), csvRecord.get("warranty_month"), csvRecord.get("range"), Integer.parseInt(csvRecord.get("points")), 
					"state", schemeID, Integer.parseInt(csvRecord.get("without_otp_point")));
				listTertiary.add(tertiaryScheme);
			}
			return listTertiary;
		} 
		catch (IOException e) 
		{
			throw new RuntimeException("fail to parse Tertiary CSV file: " + e.getMessage());
		}
	}
}