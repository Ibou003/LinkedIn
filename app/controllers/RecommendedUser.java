package controllers;

import static play.libs.Json.toJson;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import dant.linkedin.core.User;
import dant.linkedin.dao.UserDao;
import dant.linkedin.services.RecommendationUser;

public class RecommendedUser extends Controller{

	@Transactional
	public static Result get(){

		UserDao userDao = new UserDao();
		User user = userDao.findById(10);
		
		RecommendationUser recommendedUser = new RecommendationUser(user);
		Set<User> users = recommendedUser.generateRecommandedUser();
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("status", Boolean.TRUE);
		data.put("Users", users);
		return ok(toJson(data));

	}

}
