package dant.linkedin.dao;

import dant.linkedin.core.Experience;
import dant.tools.hibernate.CRUDDao;
import dant.tools.hibernate.HibernateHelper;

public class ExperienceDao extends CRUDDao<Experience> {

	public ExperienceDao(HibernateHelper helper) {
		super("Experience", helper);
	}

}
