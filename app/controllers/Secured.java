package controllers;


import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;
import controllers.routes;

public class Secured extends Security.Authenticator
{
  @Override
  public String getUsername(Context ctx)
  {
    return ctx.session().get("email");
  }

  @Override
  public Result onUnauthorized(Context ctx)
  {
    //return redirect(routes.Authentication.login());
    return ok("must connexion");
  }
}
