package com.vz.domain;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private int empId;
	private String empName;
	private String empCity;
	private int salary;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpCity() {
		return empCity;
	}
	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(int empId, String empName, String empCity, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empCity = empCity;
		this.salary = salary;
	}
	
	public static List<Employee> getEmployeeList(){
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(100, "King", "Pune", 20000));
		empList.add(new Employee(104, "Don", "Pune", 19000));
		empList.add(new Employee(105, "Bruc", "Mumbai", 19500));
		empList.add(new Employee(108, "John", "Pune", 18000));
		empList.add(new Employee(103, "Mark", "Mumbai", 17000));
		empList.add(new Employee(102, "Rock", "Delhi", 19900));
		return empList;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empCity=" + empCity + ", salary=" + salary
				+ "]";
	}
	
}
