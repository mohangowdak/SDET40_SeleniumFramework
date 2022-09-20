package org.vtiger.documents;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentTest {

	public static void main(String[] args) throws Throwable {
		//intiallize data from Property file
				FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
				Properties properties=new Properties();
				properties.load(fis);
				
				//Generate the random number
				int randomNumber = new Random().nextInt(1000);
					
				//get the control for particular sheet in excel
				FileInputStream fisExcel=new FileInputStream("./src/test/resources/testData.xlsx");
				Workbook workbook = WorkbookFactory.create(fisExcel);
				Sheet sheet = workbook.getSheet("Documents");
					
				//Fetch the data from property file
				String browser=properties.getProperty("browser").trim();
				String userName=properties.getProperty("username").trim();
				String password=properties.getProperty("password").trim();
				String url=properties.getProperty("url").trim();
				String timeouts=properties.getProperty("timeout").trim();


				//Fetch the data from Excel File
				String expectedDoucmentTitle =  sheet.getRow(2).getCell(1).getStringCellValue();
				String expectedDescription = sheet.getRow(2).getCell(2).getStringCellValue();
				String filePath = sheet.getRow(2).getCell(3).getStringCellValue();

				
				//convert string to long
				long longTimeout = Long.parseLong(timeouts);
				
				//launching the browser in run time based on browser key
				WebDriver driver=null;
				//run time polymorphism
				switch (browser) {
				case "chrome":
					WebDriverManager.chromedriver().setup(); //method chaining
					
					driver=new ChromeDriver(); //abstraction
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup(); //method chaining
					driver=new FirefoxDriver();  //abstraction
					break;
				case "ie":
					WebDriverManager.iedriver().setup(); //method chaining
					driver=new InternetExplorerDriver(); 
					break;
				default:
					System.out.println("You entered wrong Browser key in the Property file");
					break;
				}

		
				//pre-setting for the browser
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));

				//navigating the application
				driver.get(url); 

		//login to the app
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		driver.findElement(By.xpath("//a[.='Documents']")).click();
		driver.findElement(By.xpath("//img[@title='Create Document...']")).click();

		driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys(expectedDoucmentTitle);

		WebElement frame = driver.findElement(By.xpath("//iframe[@title='Rich text editor, notecontent, press ALT 0 for help.']"));
		
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//body[@class='cke_show_borders']")).sendKeys(expectedDescription, Keys.CONTROL+"a");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@id='cke_5']")).click();
		driver.findElement(By.xpath("//a[@id='cke_6']")).click();
		String expectedFilePath=System.getProperty("user.dir")+filePath;
		driver.findElement(By.xpath("//input[@name='filename']")).sendKeys(expectedFilePath);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String actualDocumentTitle= driver.findElement(By.xpath("//span[@id='dtlview_Title']")).getText();
		String actualDescription= driver.findElement(By.xpath("//td[@class='dvtCellInfo']/p")).getText().trim();
		String actualFileName= driver.findElement(By.xpath("//td[@class='dvtCellInfo']/a")).getText().replace("_", " ");
		String[] splitFilePath= expectedFilePath.split("/");
		String expectedFileName=splitFilePath[splitFilePath.length-1];

		if(actualDocumentTitle.equals(expectedDoucmentTitle) && actualDescription.equals(expectedDescription) && actualFileName.equals(expectedFileName))
		{
			System.out.println("Document created successfully---> TC is Pass");
			sheet.getRow(2).createCell(4).setCellValue("Pass");
			System.out.println("Data entered");
		}
		else {
			System.out.println("Document is not created---> TC is Fail");
			sheet.getRow(2).createCell(4).setCellValue("Fail");
			System.out.println("Data entered");
		}



		Actions act=new Actions(driver);
		WebElement adminstratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(adminstratorIcon).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		//close the workbook instance of excel
		workbook.close();

		//close the browser
		driver.quit();
	}

}
