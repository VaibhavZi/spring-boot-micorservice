package com.vz.java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.vz.domain.Employee;

public class ConvertListToSomethingElse {
	public static void main(String[] args) {
		List<Employee> employees = Employee.getEmployeeList();
		groupEmployeeByCityAndGiveCount(employees);
	}

	private static void groupEmployeeByCityAndGiveCount(List<Employee> employees) {
		Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getEmpCity));
		
	}
}
