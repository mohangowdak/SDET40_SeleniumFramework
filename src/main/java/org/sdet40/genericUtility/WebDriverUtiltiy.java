package org.sdet40.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists all webdriver common actions
 * @author MOHAN GOWDA
 *
 */
public final class WebDriverUtiltiy {
	private JavascriptExecutor jsExecutor;
	private Actions act;
	/**
	 * This method is used to launch the browser
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser) {
		WebDriver driver=null;
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
		return driver;
	}

	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void verifyWebpage(WebElement element, WebDriver driver, long longTimeout, String expectedText) {
		for(;;) {
			try{
				Assert.assertEquals(element.getText(),expectedText);
				break;
			}
			catch (Exception e) {
			waitTillElementVisible(driver, longTimeout, element);
			}
		}
	}
	/**
	 * @param actualLastName
	 * @param expectedContactLastName
	 */
	public void verifyResult(String actualLastName, String expectedContactLastName) {
		Assert.assertEquals(actualLastName,expectedContactLastName);
	}
	/**
	 * 
	 * @param condition
	 */
	public void verifyResult(boolean condition, String message) {
		Assert.assertTrue(condition, message);
	}

	/**
	 * This method is used to wait the controller implicitly Till load
	 * @param driver
	 * @param longTimeout
	 */
	public void waitTillPageLoad(WebDriver driver, Long longTimeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}

	/**
	 *  This method is used to open the application
	 * @param driver
	 * @param url
	 */
	public void navigateApplication(WebDriver driver, String url) {
		driver.get(url); 
	}

	/**
	 * This method is used to Lanuch browser, Maximize Browser, Wait page implicitly and navigate application
	 * @param browser
	 * @param longTimeout
	 * @param url
	 * @return
	 */
	public WebDriver openBrowserWithApplication(String browser, Long longTimeout, String url) {
		WebDriver driver=launchBrowser(browser);
		maximizeBrowser(driver);
		waitTillPageLoad(driver, longTimeout);
		navigateApplication(driver, url);
		return driver;
	}

public void intiallizeAction(WebDriver driver) {
	 act = new Actions(driver);
}
	/**
	 *  This method is used to do mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebElement element) {
		act.moveToElement(element).perform();
	}

	/**
	 * This method is used to double click on webelement
	 * @param driver
	 * @param element
	 */
	public void doubleClick( WebElement element) {
		act.doubleClick(element).perform();
	}

	/**
	 * This method is used to convert the dynamic Xpath into webelement
	 * @param dynamicXpath
	 * @param replaceData
	 * @param driver
	 * @return
	 */
	public WebElement convertDynamicXpathIntoWebElement(String dynamicXpath, String replaceData, WebDriver driver) {
		String requiredXpath = String.format(dynamicXpath, replaceData);
		WebElement element = driver.findElement(By.xpath(requiredXpath));
		return element;	
	}
	
	/**
	 * This method is used to convert the dynamic Xpath into By locator
	 * @param dynamicXpath
	 * @param replaceData
	 * @param driver
	 * @return
	 */
	public By convertDynamicXpathIntoByClass(String dynamicXpath, String replaceData, WebDriver driver) {
		String requiredXpath = String.format(dynamicXpath, replaceData);
		By element = By.xpath(requiredXpath);
		return element;	
	}
	/**
	 * This method is used to double click on webpage
	 * @param driver
	 */
	public void doubleClick() {
		act.doubleClick().perform();
	}

	/**
	 * This method is used to close the Browser instance 
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	
	/**
	 * This method is used to wait till the element visible
	 * @param driver
	 * @param timeOuts
	 * @param element
	 */
	public void waitTillElementVisible(WebDriver driver, long timeOuts, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOuts));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to switch the window based on partitext of url
	 * @param driver
	 * @param partialText
	 */
	public void switchToWindow(WebDriver driver, String partialText) {
		Set<String> winIds = driver.getWindowHandles();
		for(String id:winIds)
		{
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains(partialText)) {
				break;
			}
		}
	}
	
	public void jsIntiallization(WebDriver driver) {
		 jsExecutor=(JavascriptExecutor) driver;
	}
	
	public void openApplicationUsingJS(String url) {
		jsExecutor.executeScript("window.location=arguments[0]", url);
	}
	public void sendKeysUsingJS(WebElement element,String data) {
		jsExecutor.executeScript("arguments[0].value=arguments[1]", element, data);
	}
	public void clickUsingJS(WebElement element) {
		jsExecutor.executeScript("arguments[0].click()", element);
	}
	public void scrollTillElementUsingJS(WebElement element) {
	jsExecutor.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public String screenShot(WebDriver driver, JavaUtiltiy javaUtiltiy, String className) throws IOException {
		String currentTime = javaUtiltiy.currentTime();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+className+"_"+currentTime+".png");
		FileUtils.copyFile(src, dst);
		
		return dst.getAbsolutePath();
	}
	
	public String screenShot(WebDriver driver)  {
		TakesScreenshot ts = (TakesScreenshot)driver;
		String tempPath = ts.getScreenshotAs(OutputType.BASE64);
		return tempPath;
	}

}
