package org.sdet40.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.sdet40.genericUtility.ExcelUtiltiy;
import org.sdet40.genericUtility.IConstantPath;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice1Test {
	@Test(dataProvider = "getData")
	public void step2Test(String username, String password) {
		System.out.println(Thread.currentThread().getId());
		System.out.println("City ----> "+ username);
		System.out.println("Pincode ----> "+ password);
	System.out.println();
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
	ExcelUtiltiy excelUtiltity = new ExcelUtiltiy();
	excelUtiltity.openExcel(IConstantPath.EXCEL_PATH);
	String[][] obj = excelUtiltity.getMultipleData("Login Data");
		return obj;
	}

}
