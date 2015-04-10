package dant.linkedin.dao;

import dant.linkedin.core.Offer;
import dant.tools.hibernate.CRUDDao;
import dant.tools.hibernate.HibernateHelper;

public class OfferDao extends CRUDDao<Offer> {

	public OfferDao(HibernateHelper helper) {
		super("Offer", helper);
	}

}
