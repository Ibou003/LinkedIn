package dant.linkedin.dao;

import dant.linkedin.core.Post;
import dant.tools.hibernate.CRUDDao;
import dant.tools.hibernate.HibernateHelper;

public class PostDao extends CRUDDao<Post> {

	public PostDao(HibernateHelper helper) {
		super("Post", helper);
	}

}
