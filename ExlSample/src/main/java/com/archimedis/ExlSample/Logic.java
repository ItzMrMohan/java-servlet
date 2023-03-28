package com.archimedis.ExlSample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
import org.json.simple.JSONObject;

import com.google.common.io.Files;

public class Logic {

	public static JSONObject excelJson(String path, String sheets,int value1,int value2)throws ArrayIndexOutOfBoundsException {
		
		String extenstion = Files.getFileExtension(path);
		JSONObject object= new JSONObject();
		try {
			InputStream input = new FileInputStream(path);
			
			
			
			if(extenstion.equalsIgnoreCase("xlsx")) {
				
				try {
					XSSFWorkbook wb= new XSSFWorkbook(input);
					Sheet sheet = wb.getSheet(sheets);
					
					List<String> keylist=new ArrayList<String>(); 
					List<String> valuelist=new ArrayList<String>();
					
					
					
					Row firstRow = sheet.getRow(value1);
					Row secondRow = sheet.getRow(value2);
					
					
					
					int firstNum = firstRow.getLastCellNum();
					int secondNum = secondRow.getLastCellNum();
					
					
					
					for(int i=0;i<firstNum;i++) {
						String emp=firstRow.getCell(i).toString();
						keylist.add(emp);
					}

					for(int i=0;i<secondNum;i++) {
						String emp=secondRow.getCell(i).toString();
						valuelist.add(emp);
					}

					for(int i=0;i<firstNum;i++) {
						
						object.put(keylist.get(i), valuelist.get(i));
					}
					
					} catch (Exception e) {
						
						System.out.println("ExcelFile is Corrupted");
					}
				
			}else {
				System.out.println("Unformatted File");
			}
			
		} catch (FileNotFoundException e) {
			
			System.out.println("File is not Found");;
		}
		
		
		
		return object;
		
	}
}
