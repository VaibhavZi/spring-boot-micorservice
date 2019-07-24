package com.vz.programs;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter Number of elements");
			int num = scanner.nextInt();
			int arr[] = new int[num];
			System.out.println("Enter elements");
			for (int i = 0; i < num; i++) {
				arr[i] = scanner.nextInt();
			}
			System.out.println("You entered \n");
			for (int i : arr)
				System.out.println(i + "\t");

			System.out.println("Enter element to search");
			int search = scanner.nextInt();
			// In linear search you search elements from first to last. if element is found
			// then you print the index
			boolean found = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == search) {
					System.out.println("element found at index" + i);
				found=true;
				}
			}
			if(!found)
				System.out.println("Element not found!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
