package com.assignment4;

import java.util.Iterator;
import java.util.LinkedList;

public class RemoveLinkedList {
	
	public static LinkedList<String> removeListElement(LinkedList<String> list, int index) {
		
		list.remove(index);
		
		return list;
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
		
		// Method to remove an element at a given index
		// New List: { "Ava", "Michael", "Geogre", "Abigail", "Susan", "Emilee", "Vaness" }
		removeListElement(list, 3).forEach(t -> System.out.println(t));
	}
}
