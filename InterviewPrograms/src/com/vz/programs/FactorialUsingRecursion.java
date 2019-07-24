package com.vz.programs;

import java.util.Scanner;

public class FactorialUsingRecursion {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner= new Scanner(System.in);
		int num= scanner.nextInt();
		int fact = findFactUsingRecursion(num);
		System.out.println("fact of num "+num+" is "+fact);
		fun1(5);
	}

	private static int findFactUsingRecursion(int num) {
		while(num <= 1)
			return 1;
		return num*findFactUsingRecursion(num-1);
	}
	
	static void fun1(int n) 
	{ 
	int i = 0; 
	if (n > 1) 
		fun1(n-1); 
	for (i = 0; i < n; i++) 
		System.out.print(" * "); 
	} 

}
