package org.sdet40.practice;

import java.util.List;
import java.util.Map;

import org.sdet40.genericUtility.ExcelUtiltiy;
import org.sdet40.genericUtility.IConstantPath;

public class FetchDataFromExcelThroughListMap {


	public static void main(String[] args) throws Throwable {
		ExcelUtiltiy excelUtility = new ExcelUtiltiy();
 
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		List<Map<String, String>> list = excelUtility.getDataFromExcelInList("form");
		System.out.println(list.get(3).get("FirstName"));

	}
}
