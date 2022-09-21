package org.sdet40.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists reusable method to handle property file
 * @author MOHAN GOWDA
 *
 */
public final class FileUtility {
	private Properties properties;
	/**
	 * This method is used to fetch the data from Property file
	 * @param propertyFilePath
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	public String getDataFromPropertyFile(String key){
		String value = properties.getProperty(key).trim();
		return value;
	}
	//changes done by engg-2
	//changes done by engg-1
	/**
	 * This method is used to intiallize the property file
	 * @param propertyFilePath
	 * @throws IOException
	 */
	public void intiallizePropertyFile(String propertyFilePath) throws IOException  {
		FileInputStream fis = new FileInputStream(propertyFilePath);
		 properties=new Properties();
		properties.load(fis);
	}
}
