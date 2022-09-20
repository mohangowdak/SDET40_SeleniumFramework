package org.vtiger.organization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.DataType;
import org.sdet40.genericUtility.ExcelUtiltiy;
import org.sdet40.genericUtility.FileUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.sdet40.genericUtility.JavaUtiltiy;
import org.sdet40.genericUtility.WebDriverUtiltiy;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest extends BaseClass{

@Test
	public  void createOrganizationTest() throws IOException {
	System.out.println("current thread id -----> "+Thread.currentThread().getId());
	
		//Fetch the data from Excel File
		String expectedOrganizionName = excelUtility.getDataFromExcel("Organizations", 2, 1)+randomNumber;

		//create contat
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(expectedOrganizionName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//fetch the actual contact last name
		String actualLastName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

		//validating contact last name
		if(actualLastName.equals(expectedOrganizionName))
		{
			System.out.println("Organization created successfully---> TC is Pass");
			excelUtility.setDataIntoExcel("Organizations", 2, 5, "Pass");
		}
		else {
			System.out.println("Organization is not created---> TC is Fail");
			excelUtility.setDataIntoExcel("Organizations", 2, 5, "Fail");
		}
	}
}
