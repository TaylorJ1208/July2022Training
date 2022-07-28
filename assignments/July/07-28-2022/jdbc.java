package com.assignment6;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner input = new Scanner(System.in);
		printMenu();
		int selection = input.nextInt();
		
		while (true) {
			
			switch(selection) {
			case 0:
				input.close();
				System.out.println("Goodbye");
				return;
			case 1:
				showEmp();
				break;
			case 2:
				updateEmp();
				break;
			case 3:
				deleteEmp();
				break;
			case 4:
				getEmp();
				break;
			}
			printMenu();
			selection = input.nextInt();
		}	
		
	}
	
	static void printMenu() {
		System.out.println("\nSelect an option: " + "\n1) Get the list of Employees"
				+ "\n2) Update existing employee" + "\n3) Delete existing employee"
				+ "\n4) Get employee by ID" + "\n0) Exit program");
	}
	
	static void updateEmp() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", 
				"root", "WakeID12!!");
		Scanner input = new Scanner(System.in);
		System.out.println("Input employee id to update: ");
				int id = input.nextInt();
				input.nextLine();
				System.out.println("Input new name: ");
				String name = input.nextLine();
				System.out.println("Input new age: ");
				int age = input.nextInt();
		PreparedStatement pst = con.prepareStatement("UPDATE emp SET name =?, age=? " +
				"WHERE id =?;");
		pst.setString(1, name);
		pst.setInt(2, age);
		pst.setInt(3, id);
		int x = pst.executeUpdate();
		System.out.println("\n" + x + " record(s) have been updated.");
		
	}
	
	static void showEmp() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", 
				"root", "WakeID12!!");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM emp;");
		
		System.out.println("=ID===Name===Age===");
		while(rs.next()) {
			System.out.print(" " + rs.getInt("id") + " | ");
			System.out.print(rs.getString("name") + " | ");
			System.out.print(rs.getInt("age") + " | ");
			System.out.println();
		}
	}
	
	static void deleteEmp() throws SQLException {
		Scanner input = new Scanner(System.in);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", 
				"root", "WakeID12!!");
		System.out.println("Input employee id to delete: ");
		int id = input.nextInt();
		CallableStatement cst = con.prepareCall("{call delete_emp(?)}");
		cst.setInt(1, id);
		int x = cst.executeUpdate();
		System.out.println(x + " row(s) have been deleted.");
	}
	
	static void getEmp() throws SQLException {
		Scanner input = new Scanner(System.in);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", 
				"root", "WakeID12!!");
		System.out.println("Input employee id to retrieve: ");
		int id = input.nextInt();
		PreparedStatement pst = con.prepareStatement("SELECT * FROM emp WHERE id =?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			System.out.println("=ID===Name===Age===");
			System.out.print(" " + rs.getInt("id") + " | ");
			System.out.print(rs.getString("name") + " | ");
			System.out.print(rs.getInt("age") + " | ");
			System.out.println();
		}
		
	}
}
