package com.vz.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortArray {

	public static void main(String[] args) {
		int arr[] = {10,23,45,65,34,12,34,99,99};
		sortInReverseUsingJava8(arr);
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					int temp= arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("\nOrdered");
		for(int i : arr)
			System.out.print(i +"\t");
	}

	private static void sortInReverseUsingJava8(int[] arr) {
		List<Integer> intList =new ArrayList<>();
		for(int i:arr) {
			intList.add(i);
		}
		List<Integer> intl= intList.stream().sorted((e1, e2) -> {	if(e1<e2) {return 1;}else {return -1;}}).collect(Collectors.toList());
		System.out.println("Reverse order");
		for(Integer i: intl) {
			System.out.print(i+"\t");
		}
	}
}