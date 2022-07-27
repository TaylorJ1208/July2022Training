package com.assignment3;

public class Bookstore {
	
	String vin = "";
	String prodName = "";
	double price = 0.0;
	
	public Bookstore(String vin, String prodName, double price) {
		this.vin = vin;
		this.prodName = prodName;
		this.price = price;
	}
	
	public String getVIN() {
		return this.vin;
	}
	
	public String getProdName() {
		return this.prodName;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	@Override
	public String toString() {
		return "VIN: " + this.vin +"\nNAME: " + this.prodName 
				+ "\nPrice: " + this.price;
	}

}
