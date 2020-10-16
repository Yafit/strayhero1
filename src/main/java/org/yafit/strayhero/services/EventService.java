package org.yafit.strayhero.services;

import java.util.List;
import java.util.Optional;

import org.yafit.strayhero.models.Event;

public interface EventService {
	int save(Event event);
	int update(Event event);
	int delete(Event event);
	List findAll();
	Optional findById(String id);
	
}
