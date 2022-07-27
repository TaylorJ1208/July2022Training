package com.assignment3;

public class Student {
	
	String stuName = "";
	
	public Student(String stuName) {
		this.stuName = stuName;
	}
	
	public void stuAverage(int score1, int score2, int score3) {
		
		if((double)(score1 + score2 + score3) / 3 > 50) {
			
			System.out.println("This student passed!");
			
		} else {
			
			System.out.println("This student failed. Better luck next time!");
		}
		
	}
	
	public String setStuName(String stuName) {
		
		this.stuName = stuName;
		
		return this.stuName;
	}

}
