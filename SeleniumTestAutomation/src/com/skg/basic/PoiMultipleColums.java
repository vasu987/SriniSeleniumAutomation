package com.skg.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;

public class PoiMultipleColums {
	
	protected static int j;
	protected static int rowCount;
	protected static int noOfColumns;
	protected static String[] Headers;
	protected static XSSFSheet sheet;
	protected static XSSFWorkbook workbook; 
	
	
	public static void excelData(String filePath,String fileName,String sheetName) throws Exception {


        FileInputStream file = new FileInputStream(filePath+"\\"+fileName); 
            
          //  File file = new File(filePath+"\\"+fileName);
          workbook = new XSSFWorkbook(file);
     
           sheet = workbook.getSheet(sheetName);
            noOfColumns = sheet.getRow(0).getLastCellNum();
            
                    
          //Read sheet inside the workbook by its name
           
            //Find number of rows in excel file
           rowCount = sheet.getLastRowNum()- sheet.getFirstRowNum();
                     

            String[] Headers = new String[noOfColumns];
            for (j=0;j<noOfColumns;j++){
                Headers[j] = sheet.getRow(0).getCell(j).getStringCellValue();
                
                 
        

            if(Headers[j].equals("FuelLocations"))
            {
            	for (int k=1;k<=rowCount;k++) {
             String b=sheet.getRow(k).getCell(j).getStringCellValue();
             ArrayList<String> alist=new ArrayList<String>();
			  alist.add(b);
			// Displaying elements
		      for(String str:alist)
		      {
		        System.out.println(str);
				 
		             
             
         }
            }
            }
      
        

  workbook.close();
  file.close();
	}
	}
}

  




