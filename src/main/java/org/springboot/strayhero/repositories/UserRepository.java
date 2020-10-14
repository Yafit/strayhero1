package org.springboot.strayhero.repositories;

import java.util.List;
import java.util.Optional;
import org.springboot.strayhero.models.User;

public interface UserRepository {
	
		int save(User user);
		int update(User user);
		int delete(User user);	
		List findAll();
	    Optional findById(String id);
}
