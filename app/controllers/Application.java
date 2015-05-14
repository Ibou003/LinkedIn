package controllers;

import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;


/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Application extends Controller {

	@Transactional
	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

}
