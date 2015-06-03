package controllers;

import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import dant.linkedin.core.User;
import dant.linkedin.dao.UserDao;



/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Application extends Controller
{

//  @Security.Authenticated(Secured.class)
  @Transactional
  public static Result index()
  {

    Logger.info("test log");

		UserDao countryDao = new UserDao();
		User users = countryDao.authenticate("dantlinkedin@gmail.com", "password");

    return ok(index.render(users.toString()));

  }

}
