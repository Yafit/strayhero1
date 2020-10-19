package org.yafit.strayhero;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.LastModifiedDate;
import org.yafit.strayhero.models.AnimalType;
import org.yafit.strayhero.models.Event;
import org.yafit.strayhero.models.HelpType;
import org.yafit.strayhero.models.Helper;
import org.yafit.strayhero.models.Location;
import org.yafit.strayhero.models.User;
import org.yafit.strayhero.repositories.EventRepositoryImpl;
import org.yafit.strayhero.services.EventService;
import org.yafit.strayhero.services.HelperService;
import org.yafit.strayhero.services.UserService;

@SpringBootApplication

public class StrayheroApplication implements CommandLineRunner {

	@Autowired
	UserService userService;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	HelperService helperService;

	public static void main(String[] args) {
		SpringApplication.run(StrayheroApplication.class, args);
		}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting application");
		createUser();
		deleteUser(new User("545555448"));
		createHelper();
		updateUser (new User("789789", "Shlomi", "Hayon-Sade", "ShlomiHayon@gmail.com", "057800444", "Iben Gabirol 33 Tel Aviv","Shlomi111"));
		userService.updateField("33149", "email", "doronSimanTov@gmail.com");
		updateUserField("097213", "email", "didiHarari111@walla.com");
		try {		//find by id
			findById("1422499");
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findAllUsers();
		createEvent();
		deleteEvent(new Event("18800270"));
		updateEvent(new Event("15800270", new User("07120443"), new Date(1602007002000L), null, "This dog is sick", "Shomronia 43, Haifa", Location.GALIL, "0542104354", AnimalType.CAT, HelpType.FEED));
		updateEventField("15800270", "issueDescription", "The dog is now injured");
		findAllEvents();
		updateOffersHelp(new Helper(new User("07120443"), true, HelpType.ADOPTIONDAY, AnimalType.CAT, Location.JERUSALEM));
		System.out.println(HelpType.ADOPTIONDAY);
		updateHelperField(new User("07120443"), "helpType", HelpType.DRIVE.toString());
		
	}
		


	public void createUser() {
		
		User user1 = new User("789789", "Shlomi", "Hayon", "ShlomiHayon@gmail.com", "057800444", "Iben Gabirol 33 Tel Aviv",
				"Shlomi111");

		userService.save(user1);
		System.out.println("Finished saving user");
		}
	
	public void deleteUser(User userId) {
		userService.delete(userId);
		System.out.println("deleted user id " + userId);
	}
	
	public void updateUser(User user) {
		user.setEmail("RaniaUpdatedEmail@gmail.com");
		userService.update(user);
	}
	
	public void updateUserField(String userId, String fieldName, String fieldValue) {
				userService.updateField(userId, fieldName, fieldValue);
	}
	
	public void findById(String userId) throws Throwable {
		System.out.println("Find user with id " + userId);
		User user = (User)userService.findById(userId).orElseThrow(IllegalArgumentException::new);
		System.out.println("User with id: " + userId + " user object " + user.toString());
	}
	
	public void findAllUsers() {
		//System.out.println("printing list: "+ userService.findAll());
		//userService.findAll().stream().forEach(user -> System.out.println(user));
		userService.findAll().stream().forEach(System.out::println);
	}
	
	public void createEvent() {
		System.out.println("In create event");
		Event event1 = new Event("623331", new User("0984134"), new Date(1602007002000L) ,null, "This dog is too cute", 
				"Shomronia 43, Haifa", Location.GALIL, "0542104354", AnimalType.CAT, HelpType.FEED);
		
		eventService.save(event1);
		
		System.out.println("Finish create event");
		
	}

	public void deleteEvent(Event eventId) {
		eventService.delete(eventId);
		System.out.println("Deleted event " + eventId.getEventId());
	}
	
	public void updateEvent(Event event) {
		event.setAddress("Updated address: Shomronia 48 Haifa");
		eventService.update(event);
	}
	
	public void updateEventField(String eventId, String fieldName, String fieldValue) {
		eventService.updateField(eventId, fieldName, fieldValue);
	}
	
	public void findAllEvents() {
			eventService.findAll().stream().forEach(System.out::println);
	}

	public void createHelper() {
		System.out.println("Before creating helper");
		Helper helper1 = new Helper(new User("091892"), true, HelpType.ADOPTIONDAY, AnimalType.CAT, Location.JERUSALEM);
		
		helperService.save(helper1);
		System.out.println("After creating helper");
	}
	
	public void updateOffersHelp(Helper helper) {
		helper.setOffersHelp(false);;
		helperService.updateOffersHelp(helper);
	}
	
	
	public void updateHelperField(User userId, String fieldName, String fieldValue) {
		
		helperService.updateField(userId, fieldName, fieldValue);
	}

}
