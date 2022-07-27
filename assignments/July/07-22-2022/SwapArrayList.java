package com.assignment4;

import java.util.ArrayList;
import java.util.Iterator;

public class SwapArrayList {
	
	// Method to swap two elements in an ArrayList
		public static ArrayList<String> swapArrList(ArrayList<String> list, 
				int firstSwap, int secondSwap) {
			
			ArrayList<String> swappedList = list;
			
			String temp = list.get(secondSwap);
			swappedList.set(secondSwap, swappedList.get(firstSwap));
			swappedList.set(firstSwap, temp);
			
			
			return swappedList;
		}
		
		public static void main(String[] args) {
			
			// Object to be swapped
			ArrayList<String> listToSwap = new ArrayList<>();
			listToSwap.add("Ava");
			listToSwap.add("Michael");
			listToSwap.add("George");
			listToSwap.add("Wendy");
			listToSwap.add("Abigail");
			listToSwap.add("Susan");
			listToSwap.add("Emilee");
			listToSwap.add("Vanessa");
			
			// Statement to output swapped ArrayList
			// Swaps 'Wendy' AND 'Susan'
			swapArrList(listToSwap, 3, 5).forEach(t -> System.out.println(t));
			
		}

}
