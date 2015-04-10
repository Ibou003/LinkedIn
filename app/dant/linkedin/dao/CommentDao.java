package dant.linkedin.dao;

import dant.linkedin.core.Comment;
import dant.tools.hibernate.CRUDDao;
import dant.tools.hibernate.HibernateHelper;

public class CommentDao extends CRUDDao<Comment> {

	public CommentDao(HibernateHelper helper) {
		super("Comment", helper);
	}

}
