package com.srv.restmultipart.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.srv.restmultipart.beans.Student;
import com.srv.restmultipart.service.ICsvService;

@Component
public class CsvService implements ICsvService {
	
	@Override
	public void csvParser (MultipartFile file) {
		 try {
			 List<Student> students = processCsv(file.getInputStream());
			 
			 students.stream().forEach(student -> System.out.println(student));
			 
		} catch (IOException e) {
			
		}
		
	}
	
	private List<Student> processCsv(InputStream fileStream) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileStream, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Student> students = new ArrayList<Student>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				Student student = new Student(csvRecord.get("ID"));

				students.add(student);
			}

			return students;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}
	
}
