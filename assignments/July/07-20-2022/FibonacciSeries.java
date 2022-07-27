package com.assignments;

import java.util.Scanner;
import java.util.ArrayList;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> fiboSeries = new ArrayList<>();
		fiboSeries.add(0);
		
		
		System.out.println("Enter a term: ");
		int term = input.nextInt();
		
		if(term >= 1) {
			fiboSeries.add(1);
			for(int i = 1; i < term; i++) {
			int num = fiboSeries.get(i) + fiboSeries.get(i-1);
			fiboSeries.add(num);
		}
			
		}
		
		for(Integer i: fiboSeries) {
			System.out.print(i + " ");
		}
		
		input.close();
	}

}
