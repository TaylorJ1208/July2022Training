package com.assignment4;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListReverse {
	
	// Method to reverse an ArrayList
	public static ArrayList<String> reverseArrList(ArrayList<String> list) {
		
		ArrayList<String> reversedList = new ArrayList<>();
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			reversedList.add(0, itr.next());
		}
		
		return reversedList;
	}
	
	public static void main(String[] args) {
		
		// Object to be reversed
		ArrayList<String> listToReverse = new ArrayList<>();
		listToReverse.add("Ava");
		listToReverse.add("Michael");
		listToReverse.add("George");
		listToReverse.add("Wendy");
		listToReverse.add("Abigail");
		listToReverse.add("Susan");
		listToReverse.add("Emilee");
		listToReverse.add("Vanessa");
		
		// Statement to output reversed ArrayList
		reverseArrList(listToReverse).forEach(t -> System.out.println(t));
		
	}

}
