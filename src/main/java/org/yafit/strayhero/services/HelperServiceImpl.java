package org.yafit.strayhero.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yafit.strayhero.models.Helper;
import org.yafit.strayhero.repositories.HelperRepository;

@Service
public class HelperServiceImpl implements HelperService {
	
	@Autowired
	HelperRepository helperRepository;

	@Override
	public int save(Helper helper) {

		return helperRepository.save(helper);
	}

	@Override
	public int update(Helper helper) {

		return helperRepository.update(helper);
	}
	

	@Override
	public int delete(Helper helper) {

		return helperRepository.delete(helper);
	}
	
	@Override
	public List findAll() {
		return helperRepository.findAll();
	}
 
	@Override
	public Optional findById(String userId) {
		return helperRepository.findById(userId);
	}
}
