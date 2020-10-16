package org.yafit.strayhero.repositories;

import java.util.List;
import java.util.Optional;

import org.yafit.strayhero.models.User;

public interface UserRepository {
	
		int save(User user);
		int update(User user);
		int updateField(String userId, String fieldName, String fieldValue);
		int delete(User user);	
		List<User> findAll();
	    Optional findById(String id);
}
