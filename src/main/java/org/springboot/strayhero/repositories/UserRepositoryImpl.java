package org.springboot.strayhero.repositories;

import java.util.List;
import java.util.Optional;
import org.springboot.strayhero.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(User user) {

		return jdbcTemplate.update(
				"insert into user (id, firstName, lastName, email, phoneNumber, password, address) "
				+ "values (?,?,?,?,?,?,?)", user.getId(), user.getFirstName(), user.getLastName(), 
				user.getEmail(), user.getPhoneNumber(), user.getPassword(), user.getAddress());
	}

	@Override
	public int update(User user) {
	
		return jdbcTemplate.update(
				"update user set firstName = ?, lastName = ?, email = ?, phoneNumber = ?, password = ?, address = ? where id = ?",
				user.getFirstName(), user.getLastName(), 
				user.getEmail(), user.getPhoneNumber(), user.getPassword(), user.getAddress(), user.getId());
		
	}

	@Override
	public int delete(User user) {
		
		return jdbcTemplate.update( "delete from user where id = ?",
                user.getId());
		
	}

	@Override
    public List findAll() {
        return jdbcTemplate.query(
                "select * from user",
                (rs, rowNum) ->
                        new User(
                                rs.getString("id"),
                                rs.getString("firstName")
                   )
        );
    }
	
	
	@Override
	public Optional findById(String id) {
		
		return jdbcTemplate.queryForObject(
                "select * from user where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new User(
                                rs.getString("id"),
                                rs.getString("firstName"))));
	}
}
