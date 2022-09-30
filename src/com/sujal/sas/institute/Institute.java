package com.sujal.sas.institute;

import java.util.HashMap;

public class Institute {
	public int id;
	public HashMap<Branch,Integer> seats;
	public HashMap<Branch,Integer> totalSeats;
	
	public Institute(int id) {
		this.id = id;
		this.totalSeats = new HashMap<Branch,Integer>(180); 
		this.seats = new HashMap<Branch,Integer>(180); 
	}
	
	public String toString() {
		return ""+id;
	}
}
