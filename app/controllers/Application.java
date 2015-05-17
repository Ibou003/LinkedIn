package controllers;

import java.util.List;

import dant.linkedin.core.Company;
import dant.linkedin.core.Country;
import dant.linkedin.dao.CommentDao;
import dant.linkedin.dao.CompanyDao;
import dant.linkedin.dao.CountryDao;
import play.*;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;


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
