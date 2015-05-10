package dant.linkedin.dao;

import dant.linkedin.core.Company;
import play.db.jpa.JPA;

public class CompanyDao {


	public Company findById(Integer id) {
		return JPA.em().find(Company.class, id);
	}

}
