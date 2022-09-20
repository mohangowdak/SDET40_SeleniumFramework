package org.sdet40.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.sdet40.genericUtility.DataType;
import org.sdet40.genericUtility.ExcelUtiltiy;
import org.sdet40.genericUtility.FileUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.sdet40.genericUtility.JavaUtiltiy;

public class TestingGenericUtiltiy {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtiltiy excelUtility=new ExcelUtiltiy();
		FileUtility fileUtility=new FileUtility();
		JavaUtiltiy javaUtiltiy=new JavaUtiltiy();

		long longTimeout =(long) javaUtiltiy.convertStringIntoAnyDatatype("10", DataType.LONG);
		System.out.println(longTimeout);

	}
}
