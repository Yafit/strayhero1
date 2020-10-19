package org.yafit.strayhero.models;

import java.awt.Image;
import java.util.Date;

public class Event {
	String eventId;
	User userId;
	Date lastModifiedDate;
	Image picure;	
	String issueDescription;
	String address;
	Location location;
	String contactPhoneNumber;
	AnimalType animalType;
	HelpType helpType;

	//constructor

	public Event(String eventId, User userId, Date lastModifiedDate, Image picture, String issueDescription, 
			String address, Location location, String contactPhoneNumber, AnimalType animalType, HelpType helpType) {
		super();
		this.eventId = eventId;
		this.userId = userId;
		this.lastModifiedDate = lastModifiedDate;
		this.picure = picture;
		this.issueDescription = issueDescription;
		this.address = address;
		this.location = location;
		this.contactPhoneNumber = contactPhoneNumber;
		this.animalType = animalType;
		this.helpType = helpType;
	}
	
	public Event(String eventId, String issueDescription, 
			String address) {
		super();
		this.eventId = eventId;
		this.issueDescription = issueDescription;
		this.address = address;
	}
	
	public Event (String eventId) {
		this.eventId = eventId;
	}
	
	// Getters and Setters
	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Image getPicure() {
		return picure;
	}

	public void setPicure(Image picure) {
		this.picure = picure;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}
	
	public AnimalType getAnimalType() {
		return animalType;
	}

	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}

	public HelpType getHelpType() {
		return helpType;
	}

	public void setHelpType(HelpType helpType) {
		this.helpType = helpType;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", issueDescription=" + issueDescription + ", address=" + address + "]";
	}

}
