package org.sdet40.practice;

import org.sdet40.genericUtility.ListenerImplementation;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportPractice {

	@Test
	public void report() {
		ListenerImplementation.stest.info("statement 1");
			
			
	}
	
}
