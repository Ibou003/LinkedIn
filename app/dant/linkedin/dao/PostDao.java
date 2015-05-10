package dant.linkedin.dao;

import dant.linkedin.core.Post;
import play.db.jpa.JPA;

public class PostDao{


	public Post findById(Integer id) {
		return JPA.em().find(Post.class, id);
	}

}
