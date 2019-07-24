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
    * * * * * * * *
*/
public class PatternThree {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of lines");
		int lines = sc.nextInt();
		int spaces= lines;
		// Lets consider 10
		// do this for 10 lines
		for(int i=0; i<lines; i++) {
			
			int k = spaces;
			// print those spaces
			while(k>=0) {
				System.out.print("  ");
				k--;
			}
			//after printing spaces print number of *
			int j =i;
			while(j>=0) {
				System.out.print("* ");
				j--;
			}
			spaces--;
			System.out.println();
		}
	}
}
