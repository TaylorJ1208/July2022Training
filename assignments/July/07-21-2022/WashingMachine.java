package com.assignment3;

public class WashingMachine {
	
	boolean powerStatus = false;
	int noClothes = 0;
	int noDetergent = 0;
	
	public WashingMachine(boolean powerStatus, int noClothes, int noDetergent) {
		this.powerStatus = powerStatus;
		this.noClothes = noClothes;
		this.noDetergent = noDetergent;
		
	}
	
	public int setNoClothes(int noClothes) {
		this.noClothes = noClothes;
		return this.noClothes;
	}
	
	public int setNoDetergent(int noDetergent) {
		this.noDetergent = noDetergent;
		return this.noDetergent;
	}
	
	public void switchOn() {
		powerStatus = true;
	}
	
	public void switchOff() {
		powerStatus = false;
	}

}
