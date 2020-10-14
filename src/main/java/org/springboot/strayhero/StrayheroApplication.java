package org.springboot.strayhero;

import java.util.Date;
import java.util.Scanner;

import org.springboot.strayhero.models.AnimalType;
import org.springboot.strayhero.models.Event;
import org.springboot.strayhero.models.HelpType;
import org.springboot.strayhero.models.Location;
import org.springboot.strayhero.models.User;
import org.springboot.strayhero.repositories.eventRepositoryImpl;
import org.springboot.strayhero.services.EventService;
import org.springboot.strayhero.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.LastModifiedDate;

@SpringBootApplication

public class StrayheroApplication implements CommandLineRunner {

	@Autowired
	UserService userService;
	
	@Autowired
	EventService eventService;

	public static void main(String[] args) {
		SpringApplication.run(StrayheroApplication.class, args);
		}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting application");
		createUser();
		System.out.println("Finish create user");
		createEvent();
		
		try {
			userData();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createUser() {
		
		User user1 = new User("423", "Didi", "Rori", "didir@gmail.com", "0545778123", "Arthur 15, Tel Aviv",
				"poprock");

		userService.save(user1);
		System.out.println("Finished saving user");
		
		}
	
	public void createEvent() {
		System.out.println("In create event");
		Event event1 = new Event("093812", "84434", new Date(1602007002000L) ,null, "An injured cat", "Rehov Rehovot 44, Tel Aviv", 
				Location.CENTER, "0548193054", AnimalType.CAT, HelpType.FOSTER);
		
		eventService.save(event1);
		
		System.out.println("Finish create event");
		
	}

	public void deleteUser() {
		System.out.println("delete");
	}
	
	
	void userData() throws Throwable
	{

		
		// find all
		System.out.println("get updated list of Users: " + userService.findAll());
		
		// find by id
		System.out.println("Find Student with id 111999");
		User user = (User)userService.findById("111999").orElseThrow(IllegalArgumentException::new);
		System.out.println("User with id 111999: " + user.getId() + " user object " + user);

		
		// update
		System.out.println("Update email of Martin to martin@gmail.com");
		user.setEmail("martin@gmail.com");
		userService.update(user);

	}

}