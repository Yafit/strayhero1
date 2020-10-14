package org.springboot.strayhero.services;

import java.util.List;
import java.util.Optional;
import org.springboot.strayhero.models.User;

public interface UserService {
		
	
		int save(User user);
		int update(User user);
		int delete(User user);
		List findAll();
		Optional findById(String id);
}
