package dant.linkedin.dao;

import java.util.List;

import play.db.jpa.JPA;
import dant.linkedin.core.Training;

public class TrainingDao {


	public TrainingDao(){

	}

	@SuppressWarnings("unchecked")
	public Training findByName(String trainingName){

		if (trainingName.isEmpty())
		{
			return null;
		}
		String req = "select training from Training training where training.name = :valeur";
		return (Training) JPA.em().createQuery(req).setParameter("valeur", trainingName).getSingleResult();

	}

}
