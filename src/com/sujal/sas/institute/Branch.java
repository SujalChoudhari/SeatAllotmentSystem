package com.sujal.sas.institute;

public enum Branch {
	COMPUTER_ENGINEERING(180),
	INFORMATION_TECHNOLOGY(180),
	ELECTRONICS_ENGINEERING(180),
	ELECTRICAL_ENGINEERING(120),
	MECHANICAL_ENGINEERING(60),
	CIVIL_ENGINEERING(60),
	CHEMICAL_ENGINEERING(120);
	
	public final int seats;
	
	private Branch(int seats) {
		this.seats = seats;
	}
}
