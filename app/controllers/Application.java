package controllers;


import java.util.List;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import dant.linkedin.core.Country;
import dant.linkedin.dao.CountryDao;


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
		CountryDao countryDao = new CountryDao();

		List<Country> countrys = countryDao.findAll();

		return ok(index.render("Your new application is ready." + countrys));

	}

}
