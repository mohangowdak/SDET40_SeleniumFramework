package org.sdet40.practice;

import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.ListenerImplementation;
import org.sdet40.genericUtility.ThreadSafe;
import org.testng.annotations.Test;
public class ScreenshotPractice extends BaseClass{
	
	@Test
	public void screenShot1() throws Throwable {
		ThreadSafe.getTest().assignAuthor("Sanjay");
		ThreadSafe.getTest().assignCategory("Regression");
	}

}
