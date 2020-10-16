package org.springboot.strayhero.repositories;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springboot.strayhero.models.Helper;
import org.springboot.strayhero.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelperRepositoryImpl implements HelperRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Helper helper) {
		System.out.println(helper.getUserId().getId());
		
		return jdbcTemplate.update(
				"insert into helper (userId, offersHelp, helpType, animalType, location) "
				+ "values (?,?,?,?,?)", helper.getUserId().getId(), helper.getOffersHelp(),helper.getHelpType().getValue(),
				helper.getAnimalType().getValue(),helper.getLocation().getValue());
	}

	@Override
	public int update(Helper helper) {
	
		return jdbcTemplate.update(
				"update helper set userId = ?, offersHelp = ?, helpType = ?, animalType = ?, location = ?", 
				helper.getUserId().getId(), helper.getOffersHelp(),helper.getHelpType().getValue(),
				helper.getAnimalType().getValue(),helper.getLocation().getValue());		
	}

	@Override
	public int delete(Helper helper) {
		
		return jdbcTemplate.update( "delete from helper where usertId = ?",
                helper.getUserId().getId());
		
	}

	@Override
    public List findAll() {
        return jdbcTemplate.query(
                "select * from helper",
                (rs, rowNum) ->
                        new Helper(
                                (User) rs.getObject(1))
                   );
    }
	
	
//	@Override
	public Optional findById(String id) {
		
		return jdbcTemplate.queryForObject(
                "select * from Helper where userId = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Helper(
                               (User) rs.getObject(1)))
                        );
	}
}
