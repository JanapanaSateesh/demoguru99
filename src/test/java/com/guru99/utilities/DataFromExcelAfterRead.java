package com.guru99.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataFromExcelAfterRead {

	@DataProvider
	public String[][] TC001_TestData() throws IOException {

		String[][] data=ReadDataFromExcel.getData("./TestData/Guru99LoginData.xlsx", "TC001");
		return data;
	}

	@DataProvider
	public String[][] TC002_TestData() throws IOException {
		String[][] data=ReadDataFromExcel.getData("./TestData/Guru99LoginData.xlsx", "TC002");
		return data;

	}
	
	@DataProvider
	public String[][] TC003_TestData() throws IOException {
		String[][] data=ReadDataFromExcel.getData("./TestData/Guru99LoginData.xlsx", "TC003");
		return data;

	}
	
	@DataProvider
	public String[][] TC004_TestData() throws IOException {
		String[][] data=ReadDataFromExcel.getData("./TestData/Guru99LoginData.xlsx", "TC004");
		return data;

	}
	
	@DataProvider
	public String[][] TC006_TestData() throws IOException {
		String[][] data=ReadDataFromExcel.getData("./TestData/Guru99LoginData.xlsx", "TC006");
		return data;
	}
}
