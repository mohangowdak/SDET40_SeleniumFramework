package org.sdet40.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists all Java reusable actions
 * @author MOHAN GOWDA
 *
 */
public class JavaUtiltiy {
	
	/**
	 * This method is used to generate the random number
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit) {
		return new Random().nextInt(limit);
	}
	
	/**
	 * This method is used to convert String to any datatype based on Strategy
	 * @param data
	 * @return
	 */
	public Object convertStringIntoAnyDatatype(String data, DataType strategy) {
		Object obj=null;
		if(strategy.toString().equalsIgnoreCase("long")) {
		obj =Long.parseLong(data);
		}
		else if(strategy.toString().equalsIgnoreCase("int")) {
			obj= Integer.parseInt(data);
		}
		else if(strategy.toString().equalsIgnoreCase("double")) {
			obj= Double.parseDouble(data);
		}
		return obj;
	}
	
	/**
	 * This method is used to convert the current date and time into "dd_MM_yyyy_hh_mm_sss" format
	 * @return
	 */
	public String currentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
		String actualDate = sdf.format(date);
		return actualDate;
	}
	
}
