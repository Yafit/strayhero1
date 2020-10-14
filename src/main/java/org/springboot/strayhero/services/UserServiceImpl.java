package org.springboot.strayhero.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springboot.strayhero.models.User;
import org.springboot.strayhero.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public int save(User user) {

		return userRepository.save(user);
	}

	@Override
	public int update(User user) {

		return userRepository.update(user);
	}

	@Override
	public int delete(User user) {

		return userRepository.delete(user);
	}
	
	@Override
	public List findAll() {
		return userRepository.findAll();
	}
 
	@Override
	public Optional findById(String id) {
		return userRepository.findById(id);
	}
}
