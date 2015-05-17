package dant.linkedin.dao;

import java.util.List;

import play.db.jpa.JPA;
import dant.linkedin.core.Country;

public class CountryDao {

	public Country findById(Short id) {
		return JPA.em().find(Country.class, id);
	}

	
	public void save(Country c) {
		JPA.em().persist(c);
	}

	public List<Country> findAll(){
		List<Country> l = JPA.em().createQuery("FROM Country").getResultList();
		return l;
	}
}
