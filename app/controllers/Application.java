package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import dant.linkedin.core.Establishment;
import dant.linkedin.core.User;
import dant.linkedin.dao.EstablishmentDao;
import dant.linkedin.dao.UserDao;


/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Application extends Controller
{

  @Transactional
  public static Result index()
  {

    Logger.info("test log");

		UserDao countryDao = new UserDao();
		EstablishmentDao dao = new EstablishmentDao();
		Establishment c = dao.findById(1);
		List<User> users = countryDao.findByCompany(c);

    return ok(index.render(users.toString()));

  }

}
