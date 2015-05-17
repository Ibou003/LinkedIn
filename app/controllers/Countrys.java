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

/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Countrys extends Controller
{

  @Transactional
  public static Result add()
  {
    final Form<Country> categoryForm = play.data.Form.form(Country.class).bindFromRequest();

    final Country category = categoryForm.get();
    CountryDao dao = new CountryDao();
    dao.save(category);
    return redirect(routes.Application.index());
  }

  @play.db.jpa.Transactional
  public static Result get()
  {
    CountryDao countryDao = new CountryDao();

    List<Country> countrys = countryDao.findAll();
    Map<String, List<Country>> data = new HashMap<String, List<Country>>();
    data.put("pays", countrys);
    return ok(toJson(data));
  }

}
