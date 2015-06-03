package dant.linkedin.dao;

import java.util.List;
import play.Logger;
import play.db.jpa.JPA;
import dant.linkedin.core.Establishment;
import dant.linkedin.core.Experience;
import dant.linkedin.core.Training;
import dant.linkedin.core.User;
import dant.linkedin.utils.Utility;

public class UserDao
{

  public User findById(Integer id)
  {
    return JPA.em().find(User.class, id);
  }

  @SuppressWarnings("unchecked")
  public List<User> findAll()
  {
    List<User> l = JPA.em().createQuery("FROM User").getResultList();
    return l;
  }

  @SuppressWarnings("unchecked")
  public List<User> findByCompany(Establishment company)
  {
    if (company == null)
    {
      return null;
    }
    String req = "select user from User user inner join user.experiences as exp where exp.establishment.id = :valeur";
    return JPA.em().createQuery(req).setParameter("valeur", company.getId()).getResultList();
  }

  @SuppressWarnings("unchecked")
  public List<User> findByTraining(Training training)
  {
    if (training == null)
    {
      return null;
    }
    String req = "select user from User user inner join user.trainings as exp where exp.establishment.id = :valeur";
    return JPA.em().createQuery(req).setParameter("valeur", training.getId()).getResultList();
  }

  public UserDao()
  {

  }

  @SuppressWarnings("unchecked")
  public List<User> findByExperience(Experience experience)
  {
    if (experience == null)
    {
      return null;
    }
    String req = "select user from User user inner join user.exeperiences as exp where exp.establishment.id = :valeur";
    return JPA.em().createQuery(req).setParameter("valeur", experience.getId()).getResultList();

  }
  
 
  public User authenticate(String email, String pwd)
  {
    if (Utility.isNotNull(email) && Utility.isNotNull(pwd))
    {
      String req = "select user from User user where user.email = :valeur1 and user.password = :valeur2";
      List<User> usr =  JPA.em().createQuery(req).setParameter("valeur1", email).setParameter("valeur2", pwd).getResultList();
      Logger.info("connexion avec " + email);
      Logger.info(usr.toString());
      if(usr != null && usr.size()>0){
        Logger.info("*********************************User authenticate " + email);
        return usr.get(0);
      }
      Logger.info("*********************************User noon authenticate " + email);
      return null;
    }
    Logger.info("*********************************User noon authenticate " + email);
    return null;

  }

}
