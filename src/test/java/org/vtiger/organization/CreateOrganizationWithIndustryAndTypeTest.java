package org.vtiger.organization;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sdet40.genericUtility.BaseClass;
import org.testng.annotations.Test;

public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass{

	@Test
	public  void createOrganizationWithIndustryAndTypeTest() throws IOException {
		System.out.println("current thread id -----> "+Thread.currentThread().getId());
		
		//Fetch the data from Excel File
		String expectedOrganizionName = excelUtility.getDataFromExcel("Organizations", 4, 1)+randomNumber;
		String expectedIndustry = excelUtility.getDataFromExcel("Organizations", 4,2);
		String expectedType = excelUtility.getDataFromExcel("Organizations", 4, 3);

		String expectedAssignedTo = excelUtility.getDataFromExcel("Organizations", 4, 4);



		//create contat
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(expectedOrganizionName);

		WebElement industryDropDown = driver.findElement(By.xpath("//select[@name='industry']"));
		Select selectIndustry=new Select(industryDropDown);
		selectIndustry.selectByValue(expectedIndustry);

		WebElement typeDropDown = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select selectType=new Select(typeDropDown);
		selectType.selectByValue(expectedType);

		driver.findElement(By.xpath("//input[@name='assigntype' and @value='T']")).click();

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//fetch the actual contact last name
		String actualOrganizationName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		String actualIndustry = driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
		String actualType = driver.findElement(By.xpath("//span[@id='dtlview_Type']")).getText();
		String actualAssignedTo = driver.findElement(By.xpath("//span[@id='dtlview_Assigned To']/a")).getText();



		//validating contact last name
		if(actualOrganizationName.equals(expectedOrganizionName) && actualIndustry.equals(expectedIndustry) && actualType.equals(expectedType) && actualAssignedTo.equals(expectedAssignedTo))
		{
			System.out.println("Organization created With Industry and Type successfully---> TC is Pass");
		}
		else {
			System.out.println("Organization is not created---> TC is Fail");
		}


	}
}
