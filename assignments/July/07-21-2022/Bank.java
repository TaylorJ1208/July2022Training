package com.assignment3;

public class Bank {
	
	public double deposit(double amount, double balance) {
		
		balance += amount;
		
		return balance;
	}
	
	public double withdraw(double amount, double balance) {
		
		if(balance >= amount) {
			balance -= amount;
			return balance;
		} 
		else
		{
			return 0;
		}
	}

}
