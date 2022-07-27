package com.assignments;

import java.util.Scanner;

public class CalculateSum {
	
	static boolean calcSum(int num1, int num2, int num3) {
		
		if(num1 + num2 == num3) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the first number: ");
		int num1 = input.nextInt();
		System.out.println("Enter the second number: ");
		int num2 = input.nextInt();
		System.out.println("Enter the third number: ");
		int num3 = input.nextInt();
		
		System.out.println(num1 + " + " + num2 + " = " + num3 + " is: " + calcSum(num1, num2, num3));
		input.close();
		
	}

}
