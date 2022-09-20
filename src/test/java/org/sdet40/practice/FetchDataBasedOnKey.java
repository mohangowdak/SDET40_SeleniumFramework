package org.sdet40.practice;

import org.sdet40.genericUtility.ExcelUtiltiy;
import org.sdet40.genericUtility.IConstantPath;

public class FetchDataBasedOnKey {

	
	public static void main(String[] args) throws Throwable {
		ExcelUtiltiy excelUtility = new ExcelUtiltiy();
		
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
//		String firstname = excelUtility.getDataFromExcel("form", "firstName");
//		String lastName = excelUtility.getDataFromExcel("form", "lastname");
//		String email = excelUtility.getDataFromExcel("form", "email");
//		String address = excelUtility.getDataFromExcel("form", "address");
//		System.out.println(firstname);
	}
}
