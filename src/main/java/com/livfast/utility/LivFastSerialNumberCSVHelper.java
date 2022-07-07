package com.livfast.utility;

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
import com.livfast.model.LivfastSerialNumber;
import com.livguard.model.Status;

public class LivFastSerialNumberCSVHelper {
	public static String TYPE = "text/csv";
	//public static String TYPE ="application/vnd.ms-excel";
	static String[] HEADERs = {"SerialNumber"};

	public static boolean hasCSVFormat(MultipartFile file) {
		System.out.println("CSV Type :: "+file.getContentType());
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<LivfastSerialNumber> csvToTutorials(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			List<LivfastSerialNumber> listSerial = new ArrayList<LivfastSerialNumber>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) {
				LivfastSerialNumber serialNumber = new LivfastSerialNumber(csvRecord.get("SerialNumber"), new Date(), Status.active);
				listSerial.add(serialNumber);
			}
			return listSerial;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse SerialNumber CSV file: " + e.getMessage());
		}
	}
}