package org.sdet40.practice;

import java.util.Scanner;

public class DynamicXpathPractice {
	
	public static void main(String[] args) {
		
		String s="My name is %s age is %s";
		String finalData=String.format(s, "mohan", 26);
		System.out.println(finalData);
		
	}

}
