package com.vz.programs;

import java.util.Scanner;

/*
Print below pattern
*
* *
* * *
* * * *
* * * * *
* * * * * *
* * * * * * *
* * * * *  * * *

*/

public class PatternOne {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter number of lines");
		int lines = sc.nextInt();
		for(int i=0; i<lines; i++) {
			int j=i;
			while(j>=0) {
				System.out.print("* ");
				j--;
			}
			System.out.println();
		}
	}

}
