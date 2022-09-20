package org.sdet40.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sdet40.genericUtility.WebDriverUtiltiy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSPractice {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver();
		WebDriverUtiltiy webDriverUtiltiy=new WebDriverUtiltiy();
		driver.manage().window().maximize();
		webDriverUtiltiy.jsIntiallization(driver);
		webDriverUtiltiy.openApplicationUsingJS("http://localhost:8888");
		webDriverUtiltiy.sendKeysUsingJS(driver.findElement(By.name("user_name")), "admin");
		webDriverUtiltiy.sendKeysUsingJS(driver.findElement(By.name("user_password")), "admin");
		webDriverUtiltiy.clickUsingJS(driver.findElement(By.id("submitButton")));
		webDriverUtiltiy.scrollTillElementUsingJS(driver.findElement(By.xpath("//b[contains(text(), 'Top Sales Orders')]")));

	}

}
