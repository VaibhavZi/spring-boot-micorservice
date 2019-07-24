package com.vz.programs;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of elements \n");
		try {
			int num = scanner.nextInt();
			int arr[] = new int[num];
			System.out.println("Enter elements in sorted order\n");
			for (int i = 0; i < num; i++) {
				arr[i] = scanner.nextInt();
			}
			System.out.println("You entered \n");
			for (int i : arr)
				System.out.println(i + "\t");
			// In case you already have the array arr[] then your program starts from below
			// line
			System.out.println("Enter element to search \n");
			int search = scanner.nextInt();
			// In case of binary search tree, you need an sorted array
			// You divide array from middle, and check if element is present in first half
			// or second half.
			@SuppressWarnings("unused")
			int start = arr[0], middle = arr[arr.length / 2], last = arr[arr.length - 1], n = arr.length / 2;

			while (n > 0) {
				if (search == middle) {
					System.out.println("element found");
					break;
				}
				if (search < middle) {
					last = middle;
				} else {
					start = middle;
				}
				n--;
				if (n == 0)
					System.out.println("element not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
