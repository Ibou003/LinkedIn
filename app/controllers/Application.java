package controllers;


import java.util.List;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import dant.linkedin.core.Company;
import dant.linkedin.core.User;
import dant.linkedin.dao.CompanyDao;
import dant.linkedin.dao.UserDao;


/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Application extends Controller {

	@Transactional
	public static Result index() {

		Logger.info("test log");
		UserDao countryDao = new UserDao();
		CompanyDao dao = new CompanyDao();
		Company c = dao.findById(1);
		List<User> countrys = countryDao.findByCompany(c);

		return ok(index.render("Your new application is ready." + countrys));

	}

}
