package org.sdet40.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice4Test {
	@Test(groups = "regression")
	public void step1Test() {
		System.out.println("class 2 --> script1");
		System.out.println("current thread id -----> "+Thread.currentThread().getId());
		
	}
	
	@Test(groups = "regression")
	public void sTep2Test() {
		System.out.println("class 2 --> script2");	
		System.out.println("current thread id -----> "+Thread.currentThread().getId());
		
	}


}
