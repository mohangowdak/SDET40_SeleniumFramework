package org.vtiger.contacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.DataType;
import org.sdet40.genericUtility.ExcelUtiltiy;
import org.sdet40.genericUtility.FileUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.sdet40.genericUtility.JavaUtiltiy;
import org.sdet40.genericUtility.WebDriverUtiltiy;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganizationTest extends BaseClass{

@Test(groups = "reg")
	public  void createContactWithOrganizationTest() throws IOException {
	 System.out.println("current thread id -----> "+Thread.currentThread().getId());
		//Fetch the data from Excel File
		String expectedOrganizionName = excelUtility.getDataFromExcel("Contacts", 4, 1)+randomNumber;
		String expectedContactName = excelUtility.getDataFromExcel("Contacts", 4, 2)+randomNumber;


		//create contat
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(expectedOrganizionName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		WebElement updateInfoTxt = driver.findElement(By.xpath("//span[@class='small']"));
		webDriverUtiltiy.waitTillElementVisible(driver, longTimeout, updateInfoTxt);


		//create contat
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(expectedContactName);

		driver.findElement(By.xpath("//td[contains(.,'Organization Name') and @class='dvtCellLabel']/following-sibling::td[@class='dvtCellInfo']/img")).click();

		webDriverUtiltiy.switchToWindow(driver, "Accounts");
		


		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(expectedOrganizionName);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[.='"+expectedOrganizionName+"']")).click();
		
		webDriverUtiltiy.switchToWindow(driver, "Contacts");
		

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//fetch the actual contact last name
		String actualLastName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		String actualOrgnizationName = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']/a")).getText();

		//validating contact last name
		if(actualLastName.equals(expectedContactName) && actualOrgnizationName.equals(expectedOrganizionName))
		{
			System.out.println("Contact created with Orginzation successfully---> TC is Pass");
		}
		else {
			System.out.println("Contact is not created---> TC is Fail");
		}

	}
}
