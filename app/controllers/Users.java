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
import dant.linkedin.core.Experience;
import dant.linkedin.core.User;
import dant.linkedin.dao.CountryDao;
import dant.linkedin.dao.UserDao;
import play.mvc.Security;
import controllers.Secured;
/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Users extends Controller
{

  @Transactional
  public static Result add()
  {
    final Form<User> categoryForm = play.data.Form.form(User.class).bindFromRequest();
    Map<String, Object> data = new HashMap<String, Object>();
    final User category = categoryForm.get();
    UserDao dao = new UserDao();
    
    data.put("status", dao.save(category));
    return ok(toJson(data));
   
  }

  @Transactional
  public static Result experienceAdd(){
    final Form<Experience> categoryForm = play.data.Form.form(Experience.class).bindFromRequest();
    Map<String, Object> data = new HashMap<String, Object>();
    final Experience category = categoryForm.get();
    UserDao dao = new UserDao();
    /*
    data.put("status", dao.save(category));
    */
    return ok(toJson(data));
  }


}
