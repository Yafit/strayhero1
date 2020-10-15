package org.springboot.strayhero.repositories;

import java.util.List;
import java.util.Optional;
import org.springboot.strayhero.models.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelperRepositoryImpl implements HelperRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Helper helper) {
		System.out.println(helper.getUserId());
		
		return jdbcTemplate.update(
				"insert into helper (userId, offersHelp, helpType, animalType, location) "
				+ "values (?,?,?,?,?)", helper.getUserId(), helper.getOffersHelp(),helper.getHelpType(),helper.getAnimalType(),helper.getLocation());
	}

	@Override
	public int update(Helper helper) {
	
		return jdbcTemplate.update(
				"update helper set userId = ?, offersHelp = ?, helpType = ?, animalType = ?, location = ?", 
				helper.getUserId(), helper.getOffersHelp(),helper.getHelpType(),helper.getAnimalType(),helper.getLocation());		
	}

	@Override
	public int delete(Helper helper) {
		
		return jdbcTemplate.update( "delete from helper where usertId = ?",
                helper.getUserId());
		
	}

	@Override
    public List findAll() {
        return jdbcTemplate.query(
                "select * from helper",
                (rs, rowNum) ->
                        new Helper(
                                rs.getString("userId")
                   )
        );
    }
	
	
//	@Override
	public Optional findById(String id) {
		
		return jdbcTemplate.queryForObject(
                "select * from Helper where userId = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Helper(
                                rs.getString("userId"))));
	}
}
