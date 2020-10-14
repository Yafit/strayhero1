package org.springboot.strayhero.repositories;

import java.util.List;
import java.util.Optional;
import org.springboot.strayhero.models.Event;
import org.springboot.strayhero.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class eventRepositoryImpl implements EventRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Event event) {
		System.out.println(event.getLocation());
		
		return jdbcTemplate.update(
				"insert into event (eventId, userId, lastModifiedDate, picure, issueDescription, address, location, contactPhoneNumber, animalType, helpType) "
				+ "values (?,?,?,?,?,?,?,?,?,?)", event.getEventId(), event.getUserId(), event.getLastModifiedDate(), 
				event.getPicure(), event.getIssueDescription(), event.getAddress(), event.getLocation(),
				event.getContactPhoneNumber(), event.getAnimalType(), event.getHelpType());
	}

	@Override
	public int update(Event event) {
	
		return jdbcTemplate.update(
				"update user set eventId = ?, userId = ?, lastModifiedDate = ?, picure = ?, issueDescription = ?, address = ?, location = ?, contactPhoneNumber = ?, animalType = ?, helpType = ?", 
				event.getEventId(), event.getUserId(), event.getLastModifiedDate(), 
				event.getPicure(), event.getIssueDescription(), event.getAddress(), event.getLocation(),
				event.getContactPhoneNumber(), event.getAnimalType(), event.getHelpType());
		
	}

	@Override
	public int delete(Event event) {
		
		return jdbcTemplate.update( "delete from event where eventId = ?",
                event.getEventId());
		
	}

	@Override
    public List findAll() {
        return jdbcTemplate.query(
                "select * from event",
                (rs, rowNum) ->
                        new Event(
                                rs.getString("eventId")
                   )
        );
    }
	
	
	@Override
	public Optional findById(String id) {
		
		return jdbcTemplate.queryForObject(
                "select * from event where eventId = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new User(
                                rs.getString("eventId"))));
	}

}
