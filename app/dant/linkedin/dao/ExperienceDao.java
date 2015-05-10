package dant.linkedin.dao;

import dant.linkedin.core.Experience;
import play.db.jpa.JPA;

public class ExperienceDao{


	public Experience findById(Integer id) {
		return JPA.em().find(Experience.class, id);
	}
}
