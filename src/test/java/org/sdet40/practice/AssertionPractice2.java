package org.sdet40.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice2 {
	
	@Test
	public void test1() {
		Reporter.log("test 1", true);
	}
	
	@Test
	public void test2() {
		Reporter.log("test 2", true);
	}
	
	@Test
	public void test3() {
		Reporter.log("test 3", true);
	}
	

}
