package org.sdet40.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String expOrgName="asd";
		
		driver.findElement(By.linkText("Organizations")).click();
		List<WebElement> organizationList = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td/a[@title='Organizations']"));
		
		for(WebElement org:organizationList)
		{
			String orgName = org.getText();
			
			if(orgName.equals(expOrgName)) {
				driver.findElement(By.xpath("//a[text()='"+expOrgName+"']/parent::td/preceding-sibling::td/input")).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		driver.switchTo().alert().accept();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='status']/img"))));

		List<WebElement> latestOrganizationList = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td/a[@title='Organizations']"));
		
		for(WebElement org:latestOrganizationList)
		{
			String orgName = org.getText();
			
			if(orgName.equals(expOrgName)) {
				System.out.println("TC Fail ---> organization not deleted");
			}
		}
		
	}
}
