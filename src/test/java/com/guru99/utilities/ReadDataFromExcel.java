package com.guru99.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static String[][] getData(String path, String sheetName) throws IOException {
		File file=new File(path);
		FileInputStream fi=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet= workbook.getSheet(sheetName);
		int numberofrows=sheet.getPhysicalNumberOfRows();
		int numberofcolumns=sheet.getRow(0).getLastCellNum();
		//System.out.println(numberofrows); //3
		//System.out.println(numberofcolumns);
		
		String[][] data=new String[numberofrows-1][numberofcolumns];
		
		for(int i=0;i<numberofrows-1;i++) //2=>0,1,2
		{
			for(int j=0;j<numberofcolumns;j++) //2=> 0,1,2
			{
			 DataFormatter dt=new DataFormatter()	;
			 data[i][j]= dt.formatCellValue(sheet.getRow(i+1).getCell(j));  //sheet[1][0]//sheet[1][1]
			 System.out.println( data[i][j]);
			}
		}
		return data;
		
		
	}
}
