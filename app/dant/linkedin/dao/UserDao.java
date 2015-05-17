package dant.linkedin.dao;

import java.util.List;

import play.db.jpa.JPA;
import dant.linkedin.core.Company;
import dant.linkedin.core.Establishment;
import dant.linkedin.core.User;

public class UserDao {

	public User findById(Integer id) {
		return JPA.em().find(User.class, id);
	}
}
