package org.yafit.strayhero.models;

public class Helper {
	User userId; //PK
	Boolean offersHelp;
	HelpType helpType;
	AnimalType animalType; //PK
	Location location;


public Helper(User userId, Boolean offersHelp, HelpType helpType, AnimalType animalType, Location location) {
	super();
	this.userId = userId;
	this.offersHelp = offersHelp;
	this.helpType = helpType;
	this.animalType = animalType;
	this.location = location;
}

public Helper(User userId) {
	super();
	this.userId = userId;
}

public Helper(User userId, HelpType helpType, AnimalType animalType, Location location) {
	super();
	this.userId = userId;
	this.helpType = helpType;
	this.animalType = animalType;
	this.location = location;
}

public User getUserId() {
	return userId;
}


public void setUserId(User userId) {
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