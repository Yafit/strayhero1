package org.yafit.strayhero.models;

public enum Location {
	EILAT(1),
	CENTER(2),
	GALIL(3),
	SOUTH(4),
	SHFELA(5),
	SHARON(6),
	HAIFA(7),
	JERUSALEM(8),
	SHOMRON(9);
	
	private int value;
	
	//constructor that passes the int value parameters to the enum constants
	Location(int value) {
	this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}

}
