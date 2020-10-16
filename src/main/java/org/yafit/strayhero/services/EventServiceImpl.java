package org.yafit.strayhero.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yafit.strayhero.models.Event;
import org.yafit.strayhero.repositories.EventRepository;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	EventRepository eventRepository;

	@Override
	public int save(Event event) {

		return eventRepository.save(event);
	}

	@Override
	public int update(Event event) {

		return eventRepository.update(event);
	}

	@Override
	public int delete(Event event) {

		return eventRepository.delete(event);
	}
	
	@Override
	public List findAll() {
		return eventRepository.findAll();
	}
 
	@Override
	public Optional findById(String eventId) {
		return eventRepository.findById(eventId);
	}
}
