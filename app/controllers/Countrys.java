package controllers;

import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import dant.linkedin.core.Country;
import dant.linkedin.dao.CountryDao;

/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Countrys extends Controller {

	@Transactional
	public static Result add() {
		final Form<Country> categoryForm = play.data.Form.form(Country.class).bindFromRequest();
				
		final Country category = categoryForm.get();
		CountryDao dao = new CountryDao();
		dao.save(category);
		return redirect(routes.Application.index());
	}

}
