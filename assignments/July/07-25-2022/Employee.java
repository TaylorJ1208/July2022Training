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
		int males = (int) list.stream()
			.filter(emp -> emp.getEmpGender().equals(Gender.MALE))
			.count();
		int females = (int) list.stream()
				.filter(emp -> emp.getEmpGender().equals(Gender.FEMALE))
				.count();
		System.out.println("There are " + males + " male employees and " 
				+ females + " female employees.\n");
		
		// Finds the average age of male and female employees
		System.out.println("=====AVERAGE AGE OF MALE AND FEMALE EMPLOYEES=====");
		int maleAge =  (int)list.stream()
				.filter(emp -> emp.getEmpGender().equals(Gender.MALE))
				.mapToInt(emp -> emp.getEmpAge())
				.average().orElse(0);
		int femaleAge =  (int)list.stream()
				.filter(emp -> emp.getEmpGender().equals(Gender.FEMALE))
				.mapToInt(emp -> emp.getEmpAge())
				.average().orElse(0);
		System.out.println("\nThe average age for male employees is " + maleAge +
				" and for female employees is " + femaleAge + ".\n");
		
		// Finds the highest paid employee
		System.out.println("=====HIGHEST PAID EMPLOYEE=====");
		Employee highestPaid = list.stream()
				.max(Comparator.comparingInt(e -> e.getEmpSalary()))
				.get();
		System.out.println("\nThe highest paid employee is " + highestPaid.getEmpName() + "\n");
		
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
		System.out.println("=====EMPLOYEES PER DEPARTMENT=====");	
		Map<String, List<Employee>> map = list.stream().collect(Collectors.groupingBy(Employee::getEmpDept));
		int empIt = (int)list.stream()
		.filter(emp -> emp.getEmpDept().equals("IT"))
		.count();
		System.out.println("\nThe number of employees in IT is: " + map.get("IT").size());
	
		System.out.println("\nThe number of employees in Sales is: " + map.get("Sales").size());
	
		System.out.println("\nThe number of employees in Marketing is: " + map.get("Marketing").size());
	
		System.out.println("\nThe number of employees in Operations is: " + map.get("Operations").size());
	
		System.out.println("\nThe number of employees in Maintenance is: " + map.get("Maintenance").size());
		
		// Finds male and female employees that are in the maintenance department
		System.out.println("\n=====MALE AND FEMALE EMPLOYEES IN MAINTENANCE=====");
		System.out.println("\nMale employees in the maintenance department: \n");
		list.stream()
			.filter(emp -> emp.getEmpGender().equals(Gender.MALE))
			.filter(emp -> emp.getEmpDept().equals("Maintenance"))
			.forEach(emp -> System.out.print(emp.getEmpName()));
		
		System.out.println("\nFemale employees in the maintenance department: \n");
		list.stream()
			.filter(emp -> emp.getEmpGender().equals(Gender.FEMALE))
			.filter(emp -> emp.getEmpDept().equals("Maintenance"))
			.forEach(emp -> System.out.print(emp.getEmpName() + ""));
		
		// Finds the average salary of female and male employees
		System.out.println("\n\n=====AVERAGE SALARY OF MALE AND FEMALE EMPLOYEES=====\n");
		int maleAvgSalary = (int)list.stream()
					.filter(emp -> emp.getEmpGender().equals(Gender.MALE))
					.mapToDouble(emp -> emp.getEmpSalary())
					.average()
					.orElse(0);
		System.out.println("Male: $" + maleAvgSalary);
		
		int femaleAvgSalary = (int)list.stream()
				.filter(emp -> emp.getEmpGender().equals(Gender.FEMALE))
				.mapToDouble(emp -> emp.getEmpSalary())
				.average()
				.orElse(0);
		System.out.println("\nFemale: $" + femaleAvgSalary + "\n");
		
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
		Map<String, List<Employee>> map2 = list.stream()
				.collect(Collectors.groupingBy(emp -> emp.getEmpDept()));
		System.out.println("\n\n=====ALL EMPLOYEES PER DEPARTMENT=====");
		System.out.println("\n\nEmployees in the IT department are: \n");
		map.get("IT").forEach(emp -> System.out.print(emp.getEmpName() + " "));
		
		System.out.println("\n\nEmployees in the Sales department are: \n");
		map.get("Sales").forEach(emp -> System.out.print(emp.getEmpName() + " "));
		
		System.out.println("\n\nEmployees in the Marketing department are: \n");
		map.get("Marketing").forEach(emp -> System.out.print(emp.getEmpName() + " "));
		
		System.out.println("\n\nEmployees in the Operations department are: \n");
		map.get("Operations").forEach(emp -> System.out.print(emp.getEmpName() + " "));
		
		System.out.println("\n\nEmployees in the Maintenance department are: \n");
		map.get("Maintenance").forEach(emp -> System.out.print(emp.getEmpName() + " "));
	}

}
