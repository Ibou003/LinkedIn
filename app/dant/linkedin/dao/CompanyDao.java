package dant.linkedin.dao;

import dant.linkedin.core.Company;
import dant.tools.hibernate.CRUDDao;
import dant.tools.hibernate.HibernateHelper;

public class CompanyDao extends CRUDDao<Company> {

	public CompanyDao(HibernateHelper helper) {
		super("Company", helper);
	}

}
