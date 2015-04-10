package dant.linkedin.dao;

import dant.linkedin.core.Establishment;
import dant.tools.hibernate.CRUDDao;
import dant.tools.hibernate.HibernateHelper;

public class EstablishmentDao extends CRUDDao<Establishment> {

	public EstablishmentDao(HibernateHelper helper) {
		super("Establishment", helper);
	}

}
