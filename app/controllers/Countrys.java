package controllers;

import static play.libs.Json.toJson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import dant.linkedin.core.Country;
import dant.linkedin.dao.CountryDao;
import play.mvc.Security;
import controllers.Secured;
/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Countrys extends Controller
{

  @Security.Authenticated(Secured.class)
  @Transactional
  public static Result add()
  {
    final Form<Country> categoryForm = play.data.Form.form(Country.class).bindFromRequest();
    Map<String, Object> data = new HashMap<String, Object>();
    final Country category = categoryForm.get();
    CountryDao dao = new CountryDao();
    dao.save(category);
    
    data.put("status", Boolean.TRUE);
    //return ok(toJson(data));
    return redirect(routes.Application.index());
  }

  @play.db.jpa.Transactional
  public static Result get()
  {
    CountryDao countryDao = new CountryDao();
    Map<String, Object> data = new HashMap<String, Object>();
    List<Country> countrys = countryDao.findAll();
    data.put("status", Boolean.TRUE);
    data.put("pays", countrys);
    return ok(toJson(data));
  }

}
