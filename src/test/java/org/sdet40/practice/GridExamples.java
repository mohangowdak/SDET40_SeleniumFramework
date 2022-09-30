package org.sdet40.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class GridExamples {
	
	@Test
	public void test1() throws MalformedURLException, InterruptedException {
		//URL --> java.net
		//DesiredCapabalities ---> selenium.remote
		//RemoteWebdriver
		
		URL url=new URL("http://18.223.180.2:4445/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setPlatform(Platform.WINDOWS);
		cap.setBrowserName("chrome");
		
		WebDriver driver = new RemoteWebDriver(url, cap);
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		Thread.sleep(5000);
		driver.quit();
		
	}

}
