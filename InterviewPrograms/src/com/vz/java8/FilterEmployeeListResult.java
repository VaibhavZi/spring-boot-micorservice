package com.vz.java8;

import java.util.List;
import java.util.stream.Collectors;

import com.vz.domain.Employee;

public class FilterEmployeeListResult {

	public static void main(String[] args) {
		List<Employee> employees = Employee.getEmployeeList();
		System.out.println("Find employees having salary greater than 19000 \n");
		int salaryGreaterThan = 19000;
		employeeEarningMorethan(employees, salaryGreaterThan);

		System.out.println("Find employees Working in punr city \n");
		String employeeCity = "Pune";
		employeeLivingInCity(employees, employeeCity);

	}

	private static void employeeLivingInCity(List<Employee> employees, String employeeCity) {
		List<Employee> empListForCity = employees.stream().filter(e -> e.getEmpCity().equalsIgnoreCase(employeeCity))
				.collect(Collectors.toList());
		empListForCity.forEach(System.out::println);
	}

	private static void employeeEarningMorethan(List<Employee> employees, int salaryGreaterThan) {
		List<Employee> employeesEarningMore = employees.stream().filter(e -> e.getSalary() >= salaryGreaterThan)
				.collect(Collectors.toList());
		employeesEarningMore.forEach(System.out::println);
	}

}
