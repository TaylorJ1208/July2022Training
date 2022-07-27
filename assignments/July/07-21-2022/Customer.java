package com.assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
	
	String custID = "";
	String custName = "";
	String custPassword = "";
	boolean loginStatus = false;
	double total = 0;
	List<Bookstore> products;
	
	public Customer(String custID, String custName, String custPassword, boolean loginStatus, double total, List<Bookstore> products) {
		this.custID = custID;
		this.custName = custName;
		this.custPassword = custPassword;
		this.loginStatus = loginStatus;
		this.total = total;
		this.products = products;
	}
	
	public boolean custLogin() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your password: ");
		String login = input.nextLine();
		
		if(login.equals(this.custPassword)) {
			System.out.println("Login successful");
			loginStatus = true;
			return true;
		} else {
			System.out.println("Login was unsuccessful.");
			return false;
		}
	}
	
	public void custLogoff() {
		System.out.println("Logged Out.");
		loginStatus = false;
	}
	
	public void addItem(Bookstore b) {
		this.products.add(b);
		this.total += b.getPrice();
	}
	
	public void checkout() {
		Scanner input = new Scanner(System.in);
		System.out.println("Confirm Order. (y/n)");
		String confirm = input.nextLine().toLowerCase();
		
		if(!confirm.equals("y")) {
			System.out.println("Goodbye.");
			return;
		}
		
		System.out.println("Enter shipping address: ");
		String shipAddress = input.nextLine();
		System.out.println("Enter billing address: ");
		String billAddress = input.nextLine();
		
		System.out.println("=====PURCHASE RECEIPT=====");
		System.out.println(toString());
		System.out.println("Billing Address: " + billAddress + "\nShipping Address: "
				+ shipAddress);
		super.toString();
	}
	
	@Override
	public String toString() {
		return "ID: " + this.custID + "\nName: " + this.custName
				+ "\nTotal: $" + this.total;
	}
	
	public static void main(String[] args) {
		List<Bookstore> c1Products = new ArrayList<Bookstore>();
		Customer c1 = new Customer("123", "Christi", "1234", false, 0, c1Products);
		
		if (c1.custLogin()) {;
			c1.addItem(new Bookstore("111", "The Martian", 19.99));
			c1.addItem(new Bookstore("222", "Lenovo Laptop", 1200.99));
			c1.addItem(new Bookstore("333", "Wireless Logitec Mouse", 24.99));
		
			c1.checkout();
		}
		
		
		
		
	}
	
}
