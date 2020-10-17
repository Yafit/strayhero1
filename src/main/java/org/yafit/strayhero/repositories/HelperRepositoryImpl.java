package org.yafit.strayhero.repositories;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yafit.strayhero.models.Helper;
import org.yafit.strayhero.models.User;

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
				"update helper set offersHelp = ? where userId = ? AND helpType = ? AND animalType = ?",
				helper.getOffersHelp(), helper.getUserId().getId(), helper.getHelpType().getValue(),
				helper.getAnimalType().getValue());
	}
	
	@Override
	public int updateField(String userId, String fieldName, String fieldValue) {
		String sqlStr = "update helper set " + fieldName + " = ? where userId = ?";
		
		return jdbcTemplate.update(
				sqlStr,
				fieldValue, userId);		
	}

	@Override
	public int delete(Helper helper) {
		
		return jdbcTemplate.update( "delete from helper where userId = ?",
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
