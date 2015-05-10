package dant.linkedin.dao;

import dant.linkedin.core.Comment;
import play.db.jpa.JPA;



public class CommentDao {

	public Comment findById(Integer id) {
		return JPA.em().find(Comment.class, id);
	}

}
