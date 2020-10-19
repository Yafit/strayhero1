package org.yafit.strayhero.repositories;

import java.util.List;
import java.util.Optional;

import org.yafit.strayhero.models.HelpType;
import org.yafit.strayhero.models.Helper;
import org.yafit.strayhero.models.User;

public interface HelperRepository {
	int save(Helper helper);
	int updateField(User userId, String fieldName, String fieldValue);
	int updateOffersHelp(Helper helper);
	int delete(Helper helper);	
	List findAll();
    Optional findById(String userId);
}
