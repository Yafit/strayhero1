package org.yafit.strayhero;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.catalina.startup.UserDatabase;
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

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

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

		 createEvent();
		 //deleteEvent(new Event("11789780"));
		 //updateEvent(new Event("0112233", new User("1234567"), new Date(1603038012000L), null, "This dog's leg is injured", "Jabotinsky 90, Tel Aviv", Location.CENTER, "057800444", AnimalType.DOG, HelpType.DRIVE));
		// updateEventField("0112233", "issueDescription", "Needs MORE people to take him to adoption days");
		 //findAllEvents();

	}

	/*void userData() {

		createUser();
		deleteUser(new User("530321534"));
		updateUser(new User("530321534", "Frank", "Lubey", "Lubeys@hotmail.com", "0508712352", "Green 12, Eilat",
				"horoscopes"));
		userService.updateField("530321534", "email", "LubeysFrank@hotmail.com");
		updateUserField("530321534", "email", "LubeysFrank@hotmail.com");
		try { // find by id
			findById("530321534");
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		findAllUsers();
		
	public void createUser() {

		User user1 = new User("530321534", "Frank", "Lubey", "Lubeys@hotmail.com", "0508712352", "Green 12, Eilat",
				"horoscopes");

		userService.save(user1);
		System.out.println("Finished saving user");
	}

	public void deleteUser(User userId) {
		userService.delete(userId);
		System.out.println("deleted user id " + userId);
	}

	public void updateUser(User user) {
		user.setEmail("LubeysFrank@gmail.com");
		userService.update(user);
	}

	public void updateUserField(String userId, String fieldName, String fieldValue) {
		userService.updateField(userId, fieldName, fieldValue);
	}

	public void findById(String userId) throws Throwable {
		System.out.println("Find user with id " + userId);
		User user = (User) userService.findById(userId).orElseThrow(IllegalArgumentException::new);
		System.out.println("User with id: " + userId + " user object " + user.toString());
	}

	public void findAllUsers() {
		userService.findAll().stream().forEach(System.out::println);

	}
	} */
	
	/*
	void helperData() {
		 //createHelper();
		 //updateOffersHelp(new Helper(new User("222444555"), true, HelpType.ADOPTIONDAY, AnimalType.DOG, Location.GALIL));
		 //updateHelperField(new User("222444555"), "helpType", HelpType.ADOPTIONDAY.toString());
		
		public void createHelper() {
			System.out.println("Before creating helper");
			Helper helper1 = new Helper(new User("450788941"), true, HelpType.FOSTER, AnimalType.DOG, Location.HAIFA);

			helperService.save(helper1);
			System.out.println("After creating helper");
		}

		public void updateOffersHelp(Helper helper) {
			helper.setOffersHelp(false);
			;
			helperService.updateOffersHelp(helper);
		}

		public void updateHelperField(User userId, String fieldName, String fieldValue) {

			helperService.updateField(userId, fieldName, fieldValue);
		}

	} */
	
	
	public void createEvent() {
		System.out.println("In create event");
		Event event1 = new Event("29834834", new User("3345874"), new Date(1603346533842L), null, "Broken leg",
				"Em Hamoshavot 2 Petach Tikva", Location.CENTER, "0548193054", AnimalType.DOG, HelpType.ADVISE);

		eventService.save(event1);

		System.out.println("Finish create event");

	}

	public void deleteEvent(Event eventId) {
		eventService.delete(eventId);
		System.out.println("Deleted event " + eventId.getEventId());
	}

	public void updateEvent(Event event) {
		event.setIssueDescription("His leg is fine now, needs food");
		eventService.update(event);
	}

	public void updateEventField(String eventId, String fieldName, String fieldValue) {
		eventService.updateField(eventId, fieldName, fieldValue);
	}

	public void findAllEvents() {
		eventService.findAll().stream().forEach(System.out::println);
	}


}
