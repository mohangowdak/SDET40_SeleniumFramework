package org.sdet40.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicConfigAnnotationPracticeTest {

	
	@BeforeTest
	public void testSetUp() {
		System.out.println("Before Test");
	}
	
	@BeforeClass
	public void classSetUp() {
		System.out.println("Before Class");
	}

	@BeforeMethod
	public void methodSetUp1() {
		System.out.println("Before Method1");
	}
	
	@Test
	public void test1() {
		System.out.println("Test1");
	}
	

	@AfterSuite
	public void suiteTearDown() {
		System.out.println("After Suite");
	}
	@AfterTest
	public void testTearDown() {
		System.out.println("After Test");
	}
	
	@AfterClass
	public void classTearDown() {
		System.out.println("After Class");
	}

	@AfterMethod
	public void methodTearDown() {
		System.out.println("After Method");
	}
	@BeforeSuite
	public void suiteSetUp() {
		System.out.println("Before Suite1");
	}
	
	
	
	
}

