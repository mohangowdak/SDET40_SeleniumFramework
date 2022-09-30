package org.sdet40.practice;

import java.util.Map;

import org.sdet40.genericUtility.ExcelUtiltiy;
import org.sdet40.genericUtility.IConstantPath;

public class FetchDataFromExcelThroughMap {

	
	public static void main(String[] args) throws Throwable {
		ExcelUtiltiy excelUtiltiy=new ExcelUtiltiy();
		excelUtiltiy.openExcel(IConstantPath.EXCEL_PATH);
		Map<String, String> map = excelUtiltiy.getDataFromExcelInMap("form");
		System.out.println(map.get("City"));
		//
		
		
	}
}
