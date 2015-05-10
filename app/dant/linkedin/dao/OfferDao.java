package dant.linkedin.dao;

import dant.linkedin.core.Offer;
import play.db.jpa.JPA;

public class OfferDao {


	public Offer findById(Integer id) {
		return JPA.em().find(Offer.class, id);
	}

}
