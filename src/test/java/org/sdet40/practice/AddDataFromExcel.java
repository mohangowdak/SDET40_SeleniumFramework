package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AddDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step1 --> convert the physical file into java readable object
		FileInputStream fisExcel=new FileInputStream("./src/test/resources/TestData.xlsx");
		//step 2--> open the excel workbook		
		Workbook wb = WorkbookFactory.create(fisExcel);

		//Step 3--> get the control on sheet
		Sheet sheet = wb.getSheet("CommonData");

		//Step 4--> get the control on row
		Row row = sheet.getRow(2);

		//Step 5--> get the control on cell

		Cell cell = row.getCell(1);
		//Step 6--> fetch the data
		String username = cell.getStringCellValue();

		System.out.println(username);
		//Step 7--> close the workbook
		wb.close();

	}

}
