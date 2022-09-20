package org.sdet40.genericUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ThreadSafe {

	static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
	static ThreadLocal<JavaUtiltiy> javaUtility=new ThreadLocal<>();
	static ThreadLocal<WebDriverUtiltiy> webDriverUtiltiy=new ThreadLocal<>();
	
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver sdriver) {
		driver.set(sdriver);
	}
	
	public static WebDriverUtiltiy getWebDriverUtiltiy() {
		return webDriverUtiltiy.get();
	}
	public static void setWebDriverUtiltiy(WebDriverUtiltiy swebDriverUtiltiy) {
		webDriverUtiltiy.set(swebDriverUtiltiy);
	}
	
	
	public static JavaUtiltiy getJavaUtiltiy() {
		return javaUtility.get();
	}
	public static void setJavaUtiltiy(JavaUtiltiy sjavaUtility) {
		javaUtility.set(sjavaUtility);
	}
	
	public static ExtentTest getTest() {
		return test.get();
	}
	public static void setTest(ExtentTest stest) {
		test.set(stest);
	}



}
