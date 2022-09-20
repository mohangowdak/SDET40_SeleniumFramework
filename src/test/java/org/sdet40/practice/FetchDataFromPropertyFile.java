package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {
public static void main(String[] args) throws IOException {
	//Step1--> convert the physical file into Java readable object
	FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
	
	//Step2 --> create the object for properties
	Properties property = new Properties();
	
	//Step 3 ---> Load all the keys
	property.load(fis);
	
	//Step 4--> fetch the data 
	String url = property.getProperty("url").trim();
	String browser = property.getProperty("browser").trim();
		
	System.out.println(url);
	System.out.println(browser);
//	property.setProperty("url1", "http://rmgtestingserver/HMS");
//	
//	FileOutputStream fos = new FileOutputStream("./src/test/resources/commonData1.properties", true);
//	property.store(fos, "url updated");
}
}
