package org.sdet40.practice;

import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.ListenerImplementation;
import org.sdet40.genericUtility.ThreadSafe;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ScreenshotPractice2 extends BaseClass{
	
	@Test
	public void screenShot() throws Throwable {
		ThreadSafe.getTest().assignAuthor("Mohan");
		ThreadSafe.getTest().assignCategory("smoke");
		ThreadSafe.getTest().info("Login successfully");
		
		ThreadSafe.getTest().info("Home page displayed successfully");
	Assert.fail();
	}

}
