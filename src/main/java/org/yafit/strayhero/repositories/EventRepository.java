package org.yafit.strayhero.repositories;

import java.util.List;
import java.util.Optional;

import org.yafit.strayhero.models.Event;
import org.yafit.strayhero.models.User;

public interface EventRepository {
	int save(Event event);
	int update(Event event);
	int updateField(String eventId, String fieldName, String fieldValue);
	int delete(Event event);	
	List findAll();
    Optional findById(String eventId);
}
