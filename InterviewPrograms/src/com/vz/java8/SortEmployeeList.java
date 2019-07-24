package com.vz.java8;

import java.util.List;
import java.util.stream.Collectors;

import com.vz.domain.Employee;

public class SortEmployeeList {
	public static void main(String[] args) {
		List<Employee> list = Employee.getEmployeeList();
		System.out.println("Employee List contains");
		list.stream().forEach(System.out::println);

		System.out.println("Sort employees based on thire name");
		sortEmployeeByName(list);

		System.out.println("Sort employees based on their salary");
		sortEmployeeBySalary(list);

		System.out.println("Sort employees based on their ID");
		sortEmployeeById(list);
	}

	private static void sortEmployeeById(List<Employee> list) {
		List<Employee> sortedById = list.stream().sorted((e1, e2) -> {
			if (e1.getEmpId() < e2.getEmpId())
				return -1;
			else
				return 1;
		}).collect(Collectors.toList());

		sortedById.stream().forEach(System.out::println);
	}

	private static void sortEmployeeBySalary(List<Employee> list) {
		List<Employee> sortedBySalry = list.stream().sorted((e1, e2) -> {
			if (e1.getSalary() < e2.getSalary())
				return -1;
			else
				return 1;
		}).collect(Collectors.toList());

		sortedBySalry.stream().forEach(System.out::println);
	}

	private static void sortEmployeeByName(List<Employee> list) {
		List<Employee> sortedEmployeeByName = list.stream().sorted((e1, e2) ->
			e1.getEmpName().compareTo(e2.getEmpName())).collect(Collectors.toList());
		for(Employee emp: sortedEmployeeByName) {
			System.out.println(emp);
		}
	}

}
