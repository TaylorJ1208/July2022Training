package com.assignments;

import java.util.Scanner;

public class Swap {
	
	static String swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
		
		return ("The first number is now: " + a
				+ "\nThe second number is now: " + b);
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the first integer: ");
		int firstNum = input.nextInt();
		System.out.println("Enter the second integer: ");
		int secondNum = input.nextInt();
		
		System.out.println("\n" + swap(firstNum, secondNum));
		input.close();
	}
}
