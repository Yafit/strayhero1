package org.springboot.strayhero.repositories;

import java.util.List;
import java.util.Optional;
import org.springboot.strayhero.models.Event;
import org.springboot.strayhero.models.User;

public interface EventRepository {
	int save(Event event);
	int update(Event event);
	int delete(Event event);	
	List findAll();
    Optional findById(String eventId);
}
