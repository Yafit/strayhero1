package org.yafit.strayhero.services;

import java.util.List;
import java.util.Optional;

import org.yafit.strayhero.models.Helper;

public interface HelperService {

	int save(Helper helper);
	int update(Helper helper);
	int delete(Helper helper);
	List findAll();
	Optional findById(String id);
	
}
