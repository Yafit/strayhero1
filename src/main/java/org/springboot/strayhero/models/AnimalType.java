package org.springboot.strayhero.models;

import ch.qos.logback.core.net.SyslogOutputStream;

public enum AnimalType {
	DOG(1), 
	CAT(2), 
	BIRD(3);

	private int value;
	
	//constructor that passes the int value parameters to the enum constants
	AnimalType(int value) {
	this.value = value;
	}
	
	//getter that returns the int value of the enum constant
	public int getAnimalType() {
		return this.value;
	}

}
