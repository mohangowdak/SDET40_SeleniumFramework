package org.sdet40.practice;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGPractice3Test {
	@Test(groups = "sanity")
	public void step1Test() {
		System.out.println("TestNGPractice3Test --> script1");
		System.out.println("current thread id -----> "+Thread.currentThread().getId());
		System.out.println();
	}
	@BeforeTest
	public void testsetup() {
		System.out.println("current thread id -----> "+Thread.currentThread().getId());
	System.out.println("Before test");
	}
	

}
