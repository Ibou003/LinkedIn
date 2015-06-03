package dant.linkedin.core;

import dant.linkedin.dao.UserDao;
import play.db.jpa.Transactional;

public class AuthenticatedUser
{
  public String email;
  public String password;

 
  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  @Override
  public String toString()
  {
    return "AuthenticatedUser [email=" + email + ", password=" + password + "]";
  }
  
  public AuthenticatedUser()
  {
    // TODO Auto-generated constructor stub
  }
}
