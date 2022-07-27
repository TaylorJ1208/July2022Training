package com.assignment3;

public class Vehicle {
	
	public String vehicleNo;
	public String modelManufacturer;
	public String color;
	
	public Vehicle(String vehicleNo, String modelManufacturer, String color) {
		this.vehicleNo = vehicleNo;
		this.modelManufacturer = modelManufacturer;
		this.color = color;
	}
	
	public String toString() {
		return "VIN: " + this.vehicleNo + "\nModel Manufacturer: " 
				+ this.modelManufacturer + "\nColor: " + this.color;
	}

}
