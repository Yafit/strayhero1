package org.yafit.strayhero.repositories;

import java.util.List;
import java.util.Optional;

import org.yafit.strayhero.models.Helper;

public interface HelperRepository {
	int save(Helper helper);
	int update(Helper helper);
	int delete(Helper helper);	
	List findAll();
    Optional findById(String userId);
}
