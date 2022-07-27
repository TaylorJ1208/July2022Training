package com.assignments;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumbers {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = input.nextInt();
		
		if (num > 0) {
			
			if(num == 1) {
				System.out.println(num + " is a prime number.");
				return;
			}
			
			for(int i = 2; i < num; i++) {
				for(int j = 2; j < num; j++) {
					if(j * i == num) {
						System.out.println(num + " is not a prime number.");
						return;
					}
				}
			}
			System.out.println(num + " is a prime number.");
		}
	}
		
	

	
	

}
