package dant.linkedin.dao;

import dant.linkedin.core.Document;
import play.db.jpa.JPA;

public class DocumentDao {


	public Document findById(Integer id) {
		return JPA.em().find(Document.class, id);
	}
}
