package com.assignments;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String word = input.nextLine();
		
		String newWord = "";
		
		for(int i = word.length(); i > 0; i--) {
			newWord += word.substring(i-1, i);
		}
		
		System.out.println("The old word was: " + word.toUpperCase() + "\n" + "The new word is: " 
				+ newWord.toUpperCase());
	}
}
