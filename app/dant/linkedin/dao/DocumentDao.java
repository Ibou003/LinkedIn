package dant.linkedin.dao;

import dant.linkedin.core.Document;
import dant.tools.hibernate.CRUDDao;
import dant.tools.hibernate.HibernateHelper;

public class DocumentDao extends CRUDDao<Document> {

	public DocumentDao(HibernateHelper helper) {
		super("Document", helper);
	}

}
