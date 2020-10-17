package org.yafit.strayhero.services;

import java.util.List;
import java.util.Optional;

import org.yafit.strayhero.models.Event;

public interface EventService {
	int save(Event event);
	int update(Event event);
	int updateField(String eventId, String fieldName, String fieldValue);
	int delete(Event event);
	List findAll();
	Optional findById(String id);
	
}
