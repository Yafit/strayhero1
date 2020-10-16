package org.yafit.strayhero.models;

public enum HelpType {
	DONATE(1),
	FOSTER(2),
	DRIVE(3),
	ADVISE(4),
	ADOPTIONDAY(5),
	FEED(6),
	DRUGS(7);
	
	private int value;
	
	//constructor that passes the int value parameters to the enum constants
	HelpType(int value) {
	this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
