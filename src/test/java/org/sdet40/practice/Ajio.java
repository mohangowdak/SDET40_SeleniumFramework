package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {
	
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Ajio");
		String productName=sheet.getRow(1).getCell(0).getStringCellValue();
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	
		driver.get("https://www.ajio.com/");
		driver.findElement(By.xpath("//a[text()='KIDS']")).click();
		driver.findElement(By.xpath("//a[@href='/s/0-to-2-years-3767-54091']")).click();
		String productPrice = driver.findElement(By.xpath("//div[text()='"+productName+"']/following-sibling::div/span[@class='price  ']")).getText();
		System.out.println(productPrice);
		sheet.getRow(1).createCell(1).setCellValue(productPrice);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		driver.findElement(By.xpath("//div[text()='"+productName+"']")).click();
	}

}
