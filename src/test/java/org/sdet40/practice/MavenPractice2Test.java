package org.sdet40.practice;

import org.sdet40.genericUtility.WebDriverUtiltiy;
import org.testng.annotations.Test;

public class MavenPractice2Test {
	@Test(groups = "sanity")
	public void step1Test() {
		String browser=System.getProperty("b");
		String url=System.getProperty("u");
		
		System.out.println("Browser name is ======>>>>>>>   "+browser);
		System.out.println("URL is ======>>>>>>>   "+url);
		
		WebDriverUtiltiy webDriverUtiltiy=new WebDriverUtiltiy();
	
		webDriverUtiltiy.openBrowserWithApplication(browser, 10l, url);
	}
}
