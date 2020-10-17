package org.yafit.strayhero.repositories;

import java.awt.image.Raster;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yafit.strayhero.models.AnimalType;
import org.yafit.strayhero.models.Event;
import org.yafit.strayhero.models.HelpType;
import org.yafit.strayhero.models.Location;
import org.yafit.strayhero.models.User;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

@Repository
public class EventRepositoryImpl implements EventRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Event event) {
		System.out.println(event.getLocation());
		
		return jdbcTemplate.update(
				"insert into event (eventId, userId, lastModifiedDate, picure, issueDescription, address, location, contactPhoneNumber, animalType, helpType) "
				+ "values (?,?,?,?,?,?,?,?,?,?)", event.getEventId(), event.getUserId().getId(), event.getLastModifiedDate(), 
				event.getPicure(), event.getIssueDescription(), event.getAddress(), event.getLocation().getValue(),
				event.getContactPhoneNumber(), event.getAnimalType().getValue(), event.getHelpType().getValue());
	}

	@Override
	public int update(Event event) {
	
		return jdbcTemplate.update(
				"update event set eventId = ?, userId = ?, lastModifiedDate = ?, picure = ?, issueDescription = ?, address = ?, location = ?, contactPhoneNumber = ?, animalType = ?, helpType = ? where eventId = ?" , 
				event.getEventId(), event.getUserId().getId(), event.getLastModifiedDate(), 
				event.getPicure(), event.getIssueDescription(), event.getAddress(), event.getLocation().getValue(),
				event.getContactPhoneNumber(), event.getAnimalType().getValue(), event.getHelpType().getValue(), event.getEventId());
	}
	
	@Override
	public int updateField(String eventId, String fieldName, String fieldValue) {
		String sqlStr = "update event set " + fieldName + " = ? where eventId = ?";
		return jdbcTemplate.update(
				sqlStr,
				fieldValue, eventId);		
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
                                rs.getString("eventId"),
                                rs.getString("issueDescription"),
                                rs.getString("address")
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
