package dant.linkedin.dao;

import dant.linkedin.core.Establishment;
import play.db.jpa.JPA;

public class EstablishmentDao{


	public Establishment findById(Integer id) {
		return JPA.em().find(Establishment.class, id);
	}

}
