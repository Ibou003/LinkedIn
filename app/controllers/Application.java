package controllers;

import dant.linkedin.core.Company;
import dant.linkedin.dao.CommentDao;
import dant.linkedin.dao.CompanyDao;
import play.*;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;
import play.api.Logger;

/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Application extends Controller {

	@Transactional
	public static Result index() {

		CompanyDao companyDao = new CompanyDao();

		Company company = companyDao.findById(1);

		return ok(index.render("Your new application is ready." + company));
	}

}
