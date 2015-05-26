package dant.linkedin.dao;

import java.util.List;

import play.db.jpa.JPA;
import dant.linkedin.core.Establishment;
import dant.linkedin.core.Experience;
import dant.linkedin.core.Training;
import dant.linkedin.core.User;

public class UserDao
{

	public UserDao(){

	}

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
	public List<User> findByCompany(Establishment establishment)
	{

		String req = "select user from User user inner join user.experiences as exp where exp.establishment.id = :valeur";
		return JPA.em().createQuery(req).setParameter("valeur", establishment.getId()).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<User> findByTraining(Training training)
	{
		String req = "select user from User user inner join user.trainings as exp where exp.establishment.id = :valeur";
		return JPA.em().createQuery(req).setParameter("valeur", training.getId()).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<User> findByExperience(Experience experience){

		String req = "select user from User user inner join user.exeperiences as exp where exp.establishment.id = :valeur";
		return JPA.em().createQuery(req).setParameter("valeur", experience.getId()).getResultList();

	}
}
