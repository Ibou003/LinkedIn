package dant.linkedin.dao;



import play.db.jpa.JPA;
import dant.linkedin.core.User;

public class UserDao {

	public User findById(Integer id) {
		return JPA.em().find(User.class, id);
	}
}
