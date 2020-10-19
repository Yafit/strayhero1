package org.yafit.strayhero.services;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.bcel.classfile.EnumElementValue;
import org.yafit.strayhero.models.AnimalType;
import org.yafit.strayhero.models.HelpType;
import org.yafit.strayhero.models.Helper;
import org.yafit.strayhero.models.Location;
import org.yafit.strayhero.models.User;

public interface HelperService {

	int save(Helper helper);
	int updateField(User userId, String fieldName, String fieldValue);
	int updateOffersHelp(Helper helper);
	int delete(Helper helper);
	List findAll();
	Optional findById(String id);
	
}
