package org.sdet40.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	private	ExtentReports reports;
	public static ExtentTest stest;
	private ExtentTest test;
	@Override //BT
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("Document Tilte - SDET 40");
		spark.config().setReportName("Report Name -SDET 40");
		spark.config().setTheme(Theme.DARK);

		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author", "Mohan");
		reports.setSystemInfo("OS", "Win 11");
		reports.setSystemInfo("Browser", "Chrome");


	}
	@Override //@BM
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		stest=test;
		ThreadSafe.setTest(test);
	}

	@Override //@AM
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+" pass");
	}

	@Override //AM
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+" fail");
		test.fail(result.getThrowable());
		String path = ThreadSafe.getWebDriverUtiltiy().screenShot(ThreadSafe.getDriver());
		test.addScreenCaptureFromBase64String(path);
	}

	@Override //Am
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+" skip");
		test.skip(result.getThrowable());
	}

	@Override //AM
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}



	@Override //AT
	public void onFinish(ITestContext context) {
		reports.flush();
	}



}
