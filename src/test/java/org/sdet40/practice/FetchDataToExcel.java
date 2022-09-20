package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step1 --> convert the physical file into java readable object
		FileInputStream fisExcel=new FileInputStream("./src/test/resources/TestData.xlsx");
		//step 2--> open the excel workbook		
		Workbook wb = WorkbookFactory.create(fisExcel);
		//Step 3--> get the control on sheet
		Sheet sheet = wb.getSheet("Organization");
//		//Step 4--> get the control on row for new row
//		Row row = sheet.createRow(18);
		//Step 4--> get the control on row for existing row
				Row row = sheet.getRow(18);
		//Step 5--> create the cell
		Cell cell = row.createCell(3);
		//Step 6--> update the status/set the data
		cell.setCellValue("Skip");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		//Step 7--> write the data into excel
		wb.write(fos);
		System.out.println("Data updated successfully");
		//Step 8--> close the workbook
		wb.close();

	}

}
