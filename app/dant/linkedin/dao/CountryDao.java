package dant.linkedin.dao;

import dant.linkedin.core.Country;
import play.db.jpa.JPA;

public class CountryDao {

	public Country findById(Short id) {
		return JPA.em().find(Country.class, id);
	}
	
//	public Country save(Country c) {
//		return JPA.em().persist(c);
//	}
}
