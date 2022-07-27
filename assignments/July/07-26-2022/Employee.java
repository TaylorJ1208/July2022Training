package com.assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	String empId;
	String empName;
	int empAge;
	Gender empGender;
	String empDept;
	String empYearOfJoining;
	int empSalary;
	
	public enum Gender {
		MALE, FEMALE;
	}

	public static void main(String[] args) {

		List<Employee> list = new  ArrayList<>();
	
		list.add(new Employee("111", "Andrew", 26, Gender.MALE, "IT", "2018", 70000));
		list.add(new Employee("222", "Sarah", 29, Gender.FEMALE, "Sales", "2020", 80000));
		list.add(new Employee("333", "William", 45, Gender.MALE, "Marketing", "1999", 82000));
		list.add(new Employee("444", "George", 43, Gender.MALE, "Sales", "2000", 90000));
		list.add(new Employee("555", "Jackson", 32, Gender.MALE, "Operations", "2015", 50000));
		list.add(new Employee("666", "Jennifer", 59, Gender.FEMALE, "IT", "1993", 100000));
		list.add(new Employee("777", "Brionna", 33, Gender.FEMALE, "Operations", "2019", 73000));
		list.add(new Employee("888", "Elvis", 21, Gender.MALE, "Marketing",  "2022", 50000));
		list.add(new Employee("999", "Victoria", 54, Gender.FEMALE, "Sales", "2003", 65000));
		list.add(new Employee("101", "Robert", 43, Gender.MALE, "Maintenance", "2004", 62000));
		list.add(new Employee("102", "Sandra", 44, Gender.FEMALE, "Maintenance", "2002", 69000));
		
		// Displays the amount of male and female employees
		System.out.println("=====AMOUNT OF MALE AND FEMALE EMPLOYEES=====\n");
		Map<Gender, Long> malesAndFemales = list.stream()
				.collect(Collectors.groupingBy(Employee::getEmpGender, Collectors.counting()));
		System.out.println(malesAndFemales + "\n");
		
		// Finds the average age of male and female employees
		System.out.println("=====AVERAGE AGE OF MALE AND FEMALE EMPLOYEES=====");
			
		Map<Gender, Double> averageAge = list.stream()
			.collect(Collectors.groupingBy(Employee::getEmpGender, Collectors.averagingInt(Employee::getEmpAge)));
		System.out.println("\n" + averageAge + "\n");
		// Finds the highest paid employee
		System.out.println("=====HIGHEST PAID EMPLOYEE=====");
		Employee highestPaid = list.stream()
				.max(Comparator.comparingInt(e -> e.getEmpSalary()))
				.get();
		System.out.println("\nThe highest paid employee is: " + highestPaid.getEmpName() + "\n");
		
		// Lists all the names of employees who joined after 2015
		System.out.println("=====EMPLOYEES JOINED AFTER 2015=====\n");
		list.stream()
			.filter(emp -> Integer.parseInt(emp.getEmpYearOfJoining()) > 2015)
			.forEach(emp -> System.out.print(emp.getEmpName() + " "));
		
		// Lists the oldest employee in the organization
		System.out.println("\n\n=====OLDEST EMPLOYEE=====\n");
		Employee senior = list.stream()
				.max(Comparator.comparing(emp -> emp.getEmpAge()))
				.get();
		System.out.println(senior.getEmpName() + "\n");
		
		// Counts the number of employees in each department
		System.out.println("=====EMPLOYEES PER DEPARTMENT=====\n");	
		Map<String, Long> empPerDepartment = list.stream().collect(Collectors.groupingBy(Employee::getEmpDept, Collectors.counting()));
		System.out.println(empPerDepartment);
		
		// Finds male and female employees that are in the maintenance department
		System.out.println("\n=====MALE AND FEMALE EMPLOYEES IN MAINTENANCE=====");
		Map<Gender, List<Employee>> empMaintenance = list
					.stream()
					.filter(emp -> emp.getEmpDept().equals("Maintenance"))
					.collect(Collectors.groupingBy(Employee::getEmpGender));
		System.out.println(empMaintenance);
		
		// Finds the average salary of female and male employees
		System.out.println("\n\n=====AVERAGE SALARY OF MALE AND FEMALE EMPLOYEES=====\n");
		Map<Gender, Double> empAverageSalary = list
					.stream()
					.collect(Collectors.groupingBy(Employee::getEmpGender, Collectors.averagingInt(Employee::getEmpSalary)));
		System.out.println(empAverageSalary + "\n");
		
		// Differentiates the employees who are <= 25 years of age or older than 25
		System.out.println("===== EMPLOYES YOUNGER THAN OR 25 AND OLDER THAN 25=====");
		System.out.println("\nEmployees younger 25 years old or are 25 years old: \n");
		list.stream()
			.filter(emp -> emp.getEmpAge() <= 25)
			.forEach(emp -> System.out.print(emp.getEmpName() + " "));
		
		System.out.println("\n\nEmployees who are older than 25 years: \n");
		list.stream()
			.filter(emp -> emp.getEmpAge() > 25)
			.forEach(emp -> System.out.print(emp.getEmpName() + " "));
		
		// Lists names of all employees in each department
		Map<String, List<Employee>> map = list.stream()
				.collect(Collectors.groupingBy(emp -> emp.getEmpDept()));
		System.out.println("\n\n=====ALL EMPLOYEES PER DEPARTMENT=====\n");
		Map<String, Long> empDepartments = list
					.stream()
					.collect(Collectors.groupingBy(Employee::getEmpDept, Collectors.counting()));
		System.out.println(empDepartments);
	}

}
