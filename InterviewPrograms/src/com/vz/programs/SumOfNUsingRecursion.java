package com.vz.programs;

public class SumOfNUsingRecursion {

	public static void main(String[] args) {
		int n = 10;
		int sum= sumOf(n);
		System.out.println(sum);
	}

	private static int sumOf(int n) {
		while(n<=1) {
			return 1;
		}
		return n+sumOf(n-1);
	}

}
