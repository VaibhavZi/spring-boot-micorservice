package com.vz.programs;

import java.util.Scanner;

/*
Print below pattern
    *
   * *
  * * *
 * * * *
* * * * *

*/
public class PatternTwo {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of lines");
		int lines = sc.nextInt();
		int spaces = lines;

		for (int i = 0; i <= lines; i++) {
			int spacesToDraw = spaces;
			while (spacesToDraw >= 0) {
				System.out.print(" ");
				spacesToDraw--;
			}
			spaces--;
			int k =i;
			while (k >= 0) {
				System.out.print("* ");
				k--;
			}
			System.out.println();

		}

		/*
		 * int j =((lines/2)-i), k=i; while(j>=0) { System.out.print("\t"); j--; }
		 * while(k>0) { System.out.print("*\t"); k--; } System.out.println();
		 */

	}
}
