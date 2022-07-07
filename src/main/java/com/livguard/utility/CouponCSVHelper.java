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

import com.livguard.model.Coupon;
import com.livguard.model.Status;

public class CouponCSVHelper 
{
	public static String TYPE = "text/csv";
	//public static String TYPE ="application/vnd.ms-excel";
	static String[] HEADERs = {"username","user_id","coupon_text"};

	public static boolean hasCSVFormat(MultipartFile file) 
	{
		System.out.println("CSV Type :: "+file.getContentType());
		if (!TYPE.equals(file.getContentType())) 
		{
			return false;
		}
		return true;
	}

	public static List<Coupon> csvToTutorials(InputStream is) 
	{
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) 
		{
			List<Coupon> listCoupon = new ArrayList<Coupon>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) 
			{
				Coupon coupon = new Coupon(csvRecord.get("username"), csvRecord.get("coupon_text"), "Pending", new Date(), new Date(), Integer.parseInt(csvRecord.get("user_id")), Status.active);
				listCoupon.add(coupon);
			}
			return listCoupon;
		} 
		catch (IOException e) 
		{
			throw new RuntimeException("fail to parse Coupon CSV file: " + e.getMessage());
		}
	}
}