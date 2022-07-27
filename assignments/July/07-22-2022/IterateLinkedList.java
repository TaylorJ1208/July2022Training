package com.assignment4;

import java.util.Iterator;
import java.util.LinkedList;

public class IterateLinkedList {
	
	public static void iterator(LinkedList<String> list, int index) {
		
		Iterator itr = list.iterator();
		int i = 0;
		while(itr.hasNext()) {
			if(i >= index) {
				System.out.println(itr.next());
			} else {
				itr.next();
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<>();
		list.add("Ava");
		list.add("Michael");
		list.add("George");
		list.add("Wendy");
		list.add("Abigail");
		list.add("Susan");
		list.add("Emilee");
		list.add("Vanessa");
		
		// Method to print out elements at a given index
		// Prints : 'Abigail' , 'Susan' , 'Emilee' , 'Vanessa'
		iterator(list, 4);
		
	}

}
