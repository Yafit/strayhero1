package org.springboot.strayhero.models;

public class Helper {
	String userId; //PK
	Boolean offersHelp;
	HelpType helpType;
	//int helpType;
	AnimalType animalType; //PK
	//int animalType;
	Location location;
	//int location;


public Helper(String userId) {
	super();
	this.userId = userId;
}


public String getUserId() {
	return userId;
}


public void setUserId(String userId) {
	this.userId = userId;
}


public Boolean getOffersHelp() {
	return offersHelp;
}


public void setOffersHelp(Boolean offersHelp) {
	this.offersHelp = offersHelp;
}


public HelpType getHelpType() {
	return helpType;
}


public void setHelpType(HelpType helpType) {
	this.helpType = helpType;
}


public AnimalType getAnimalType() {
	return animalType;
}


public void setAnimalType(AnimalType animalType) {
	this.animalType = animalType;
}


public Location getLocation() {
	return location;
}


public void setLocation(Location location) {
	this.location = location;
}
}