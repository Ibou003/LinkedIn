package dant.linkedin.dao;

import dant.linkedin.core.Country;
import dant.tools.hibernate.CRUDDao;
import dant.tools.hibernate.HibernateHelper;

public class CountryDao extends CRUDDao<Country> {

	public CountryDao(HibernateHelper helper) {
		super("Country", helper);
	}

}
