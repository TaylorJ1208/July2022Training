package com.assignment4;

import java.sql.Array;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetToArray {
	
	public static String[]  HashSetToArray(HashSet<String> hashSet) {
		
		String[] arr = new String[hashSet.size()];
		Iterator itr = hashSet.iterator();
		int i = 0;
		while(itr.hasNext()) {
			arr[i] = (String) itr.next();
			i++;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("Ava");
		hashSet.add("Michael");
		hashSet.add("George");
		hashSet.add("Wendy");
		hashSet.add("Abigail");
		hashSet.add("Susan");
		hashSet.add("Emilee");
		hashSet.add("Vanessa");
		
		// Method to return an Array from a HashSet
		System.out.println("Is the HashSet now an Array? " + (HashSetToArray(hashSet) instanceof String[]));
		
	}

}
