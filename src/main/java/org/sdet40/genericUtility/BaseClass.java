package org.sdet40.genericUtility;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sdet40.objectRepository.CommonPage;
import org.sdet40.objectRepository.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
/**
 * 
 * @author MOHAN GOWDA
 *
 */
public class BaseClass {

	private LoginPage loginPage;
	private	String userName;
	private	String password;
	protected CommonPage commonPage;
	protected WebDriver driver;
	protected WebDriverUtiltiy webDriverUtiltiy;
	protected ExcelUtiltiy excelUtility;
	protected int randomNumber;
	protected long longTimeout;
	public static WebDriver sdriver;
	public static JavaUtiltiy sjavaUtiltiy;

	
	//baseclass updated
	
	//engg- 1 


	/**
	 * intialize the all utility class 
	 * open the excel , propertyfile
	 *  read the common data
	 *  create the instance for browser(launch browser)
	 *  maximize, implicit wait
	 *  open the application
	 *  intiallize jsexecutor, actions, webdriverwait
	 *  create the instance for common object repo
	 * @throws IOException 
	 *  
	 */
	@Parameters(value="browser")
	@BeforeClass(groups = "baseclass")
	public void classSetUp(String browser) throws IOException {
		//create instance for the Generic Utility
		excelUtility=new ExcelUtiltiy();
		FileUtility fileUtility=new FileUtility();
		JavaUtiltiy javaUtiltiy=new JavaUtiltiy();
		sjavaUtiltiy=javaUtiltiy;
		ThreadSafe.setJavaUtiltiy(javaUtiltiy);
		webDriverUtiltiy=new WebDriverUtiltiy();
		ThreadSafe.setWebDriverUtiltiy(webDriverUtiltiy);

		//intaillize the property file and excelfile
		fileUtility.intiallizePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);

		//Fetch the data from property file
		userName=fileUtility.getDataFromPropertyFile("username");
		password=fileUtility.getDataFromPropertyFile("password");
		String url=fileUtility.getDataFromPropertyFile("url");
		String timeouts=fileUtility.getDataFromPropertyFile("timeout");
		longTimeout =(long) javaUtiltiy.convertStringIntoAnyDatatype(timeouts, DataType.LONG);
		randomNumber = javaUtiltiy.getRandomNumber(1000);
		//launching the browser and doing some browser setting
		driver = webDriverUtiltiy.openBrowserWithApplication(browser, longTimeout, url);
		sdriver=driver;
		ThreadSafe.setDriver(driver);
		webDriverUtiltiy.jsIntiallization(driver);
		webDriverUtiltiy.intiallizeAction(driver);

		webDriverUtiltiy.verifyWebpage(driver.findElement(By.xpath("//input[@name='user_name']/preceding::div[@class='label']")), driver, 10, "User Name");
		
		//create object for common pom repo
		loginPage=new LoginPage(driver);
		commonPage=new CommonPage(driver);

	}
	//login to the application
	/**
	 * when ever we create the testscript class for module and test annotaion method for testcase
	 * create the instance for browser(launch browser)
	 *  maximize, implicit wait
	 *  intiallize jsexecutor, actions, webdriverwait
	 *  create the instance for common object repo (driver)
	 *  login to the app
	 */
	@BeforeMethod(groups = "baseclass")
	public void methodSetUp1() {
		loginPage.loginAction(userName, password);
	}
/**
 * 
 * @throws FileNotFoundException
 * @throws IOException
 */
	@AfterMethod(groups = "baseclass")
	public void methodTearDown() throws FileNotFoundException, IOException {
		//logout from the application
		commonPage.signoutAction(webDriverUtiltiy);

		//save the excel data
		excelUtility.saveDataIntoExcel(IConstantPath.EXCEL_PATH);
	}

/**
 * 
 * @throws IOException
 */
	@AfterClass(groups = "baseclass")
	public void classTearDown() throws IOException {
		webDriverUtiltiy.closeBrowser(driver);
		excelUtility.closeExcelWorkBook();
	}
}
