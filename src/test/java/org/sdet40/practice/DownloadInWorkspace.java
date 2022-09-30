package org.sdet40.practice;

import java.awt.AWTException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadInWorkspace {
	@Test
	public void download() throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		Map<String, Object> preference=new HashedMap<>();
		preference.put("download.default_directory", System.getProperty("user.dir")+"\\download");
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", preference);

		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/download");
		
		driver.findElement(By.xpath("//a[.='some-file.txt']")).click();
		Thread.sleep(5000);
		List<String> results = new ArrayList<String>();


		File[] files = new File(System.getProperty("user.dir")+"\\download").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 

		for (File file : files) {
		    if (file.isFile()) {
		        results.add(file.getName());
		    }
		}
		System.out.println(results);
	}

}
