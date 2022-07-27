package com.assignment3;

public class Truck extends Vehicle {
	
	public int loadCapacity = 100;

	public Truck(String vehicleNo, String modelManufacturer, String color, int loadCapacity) {
		super(vehicleNo, modelManufacturer, color);
		this.loadCapacity = loadCapacity;
	}
	
	public void changeColor(String color) {
		this.color = color;
	}
	
	public void changeLoadCapacity(int loadCapacity) {
		this.loadCapacity = loadCapacity;
	}
	
	@Override
	public String toString() {
		return "VIN: " + this.vehicleNo + "\nModel Manufacturer: " 
				+ this.modelManufacturer + "\nColor: " + this.color
				+ "\nLoad Capacity: " + this.loadCapacity;
	}
	
	public static void main(String[] args) {
		
		Truck t1 = new Truck("123456", "Ford F-150", "Gray", 100);
		
		System.out.println("=====TRUCK BEFORE CHANGE=====");
		System.out.println(t1);
		
		System.out.println("=====TRUCK AFTER CHANGE=====");
		t1.changeLoadCapacity(150);
		t1.changeColor("Blue");
		System.out.println(t1);
		
	}

}
