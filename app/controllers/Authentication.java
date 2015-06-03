package controllers;

import java.util.HashMap;
import java.util.Map;
import dant.linkedin.core.Country;
import dant.linkedin.dao.UserDao;
import play.api.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.*;
import play.mvc.*;
import play.data.*;
import play.db.jpa.Transactional;
import models.*;
import views.html.*;
import static play.libs.Json.toJson;

public class Authentication extends Controller
{

  public static class AuthenticatedUser
  {
    public String email;
    public String password;

    private UserDao userDao = new UserDao();

    public String validate()
    {
      if (userDao.authenticate(email, password) == null)
      {
        return "oups";
      }
      return null;
    }

    @Override
    public String toString()
    {
      return "AuthenticatedUser [email=" + email + ", password=" + password + "]";
    }

  }

  public static Result login()
  {
    //
    return ok(login.render(""));
    /*
     * play.data.Form<AuthenticatedUser> categoryForm = play.data.Form.form(AuthenticatedUser.class).bindFromRequest();
     * data.put("status", Boolean.TRUE); data.put("user", categoryForm); return ok(toJson(data));
     */
  }

  // On recupere les informations de login (quand le user se "signe")
  @Transactional
  public static Result authenticate()
  {
    Logger.info("*******************************authenticate***********************************");
    Map<String, Object> data = new HashMap<String, Object>();

    final play.data.Form<AuthenticatedUser> loginForm = play.data.Form.form(AuthenticatedUser.class).bindFromRequest();
    final AuthenticatedUser category = loginForm.get();

    Logger.info("*******************************loginForm : " + loginForm.toString());
    UserDao userDao = new UserDao();
    /*
     * 
     * 
     * if (userDao.authenticate(category.getEmail(), category.getPassword()) == null) {
     * Logger.info("*******************************authenticate : false ");
     * 
     * return ok("oups! râtte! Essaye encore une fois"); } else {
     * Logger.info("*******************************authenticate : true "); session("email", category.getEmail()); return
     * redirect(routes.Application.index()); }
     */
    if (loginForm.hasErrors())
    {
      return ok(toJson("badRequest"));
    }
    else
    {
      session("email", loginForm.get().email);
      //User who = userDao.findByEmail(loginForm.get().email);
      return ok(toJson("ok connexion"));
    }

    /*
     * data.put("status", Boolean.TRUE); data.put("user", categoryForm); return ok(toJson(data));
     */
  }

  // Fermer la session
  public static Result logout()
  {
    session().clear();
    return ok(toJson("bye"));
  }

}
