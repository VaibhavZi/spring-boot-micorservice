package com.vz.programs;

import java.util.Scanner;

public class StringPalindrom {

	public static void main(String[] args) {
		
		@SuppressWarnings({"resource" })
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Stringv to check if it's palindrom");
		String str = sc.next();
		checkPalindrom(str);
		recursion(str);
	}

	private static void recursion(String str) {
		
	}

	private static void checkPalindrom(String str) {
		char[] arr = str.toCharArray();
		int l = arr.length-1;
		String s ="";
		while(l>=0) {
			s+=arr[l];
			l--;
		}
		if(s.equals(str)) {
			System.out.println("Palindrom");
		}else
			System.out.println("Not palindrom");
	}
}
