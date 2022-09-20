package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestDataOld.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("MakeMyTrip");
		String fromCityCode=sheet.getRow(1).getCell(0).getStringCellValue();
		String toCityCode=sheet.getRow(1).getCell(1).getStringCellValue();
		String departureDate=sheet.getRow(1).getCell(2).getStringCellValue();
		String returnDate=sheet.getRow(1).getCell(3	).getStringCellValue();

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(fromCityCode);
		driver.findElement(By.xpath("//div[text()='"+fromCityCode+"']")).click();


		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(toCityCode);
		driver.findElement(By.xpath("//div[text()='"+toCityCode+"']")).click();
		selectDate(driver, "departure", departureDate);
		driver.findElement(By.xpath("//span[.='RETURN']")).click();
		selectDate(driver, "return", returnDate);
		driver.findElement(By.xpath("//a[.='Search']")).click();
	}

	public static void selectDate(WebDriver driver, String typeOfTrip , String date) {
		int i=typeOfTrip.equals("return")? 2 : 1;

		int reqMonth=LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MMMM-yyyy")).getMonthValue();
		int reqYear=Integer.parseInt(date.split("-")[2]);

		String currentMonthYear = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div["+i+"]/div[@class='DayPicker-Caption']/div")).getText();
				int currentMonth=0;
				int currentYear=0;
			try	{ currentMonth=DateTimeFormatter.ofPattern("MMMM yyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
		 currentYear=DateTimeFormatter.ofPattern("MMMM yyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);
		}
		catch (Exception e) {
			currentMonth=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
			currentYear=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);			
			}
		
	
		while(!(currentMonth==reqMonth && currentYear==reqYear))
		{
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			currentMonthYear = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[2]/div[@class='DayPicker-Caption']/div")).getText();
			try{
				currentMonth=DateTimeFormatter.ofPattern("MMMM yyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
			currentYear=DateTimeFormatter.ofPattern("MMMM yyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);
			}
			catch (Exception e) {
				currentMonth=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
				currentYear=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);			}
			}
		driver.findElement(By.xpath("//div[@class='DayPicker-Month' and contains(.,'"+date.split("-")[1]+"')]//p[.='"+date.split("-")[0]+"']")).click();
	}
}