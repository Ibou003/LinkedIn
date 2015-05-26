package dant.linkedin.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dant.linkedin.core.Competence;
import dant.linkedin.core.Experience;
import dant.linkedin.core.Training;
import dant.linkedin.core.User;
import dant.linkedin.dao.UserDao;
import dant.linkedin.utils.LinkedInCsts;

public class RecommendationUser {

	private User currUser;
	private UserDao userDao;

	public RecommendationUser(User currUser) {
		super();
		this.currUser = currUser;
		userDao = new UserDao();
	}


	/**
	 * This method generated a recommended user list
	 * Each time we call this method, he will generate a new list of users
	 * @return Set<User> that correspond to the recommended user
	 */
	public Set<User> generateRecommandedUser(){
		Set<User> recommendedUser = new HashSet<User>();

		/*
		 * E -> Experience
		 * T -> Training
		 * C -> Competence
		 */
		List<User> userWithSameETC = new ArrayList<User>();
		List<User> userWithSameET = new ArrayList<User>();
		List<User> userWithSameE = new ArrayList<User>();
		List<User> userWithSameTC = new ArrayList<User>();
		List<User> userWithSameT = new ArrayList<User>();

		//Get the other users with the same training and experience
		List<Training> currUserTrainings = currUser.getTrainings();
		List<Experience> currUserExperiences = currUser.getExperiences();

		Set<User> userWithSameExperiences = userWithSameExperiences(currUserExperiences);
		Set<User> userWithSameTrainings = userWithSameTrainings(currUserTrainings);

		userWithSameETC_ET_E(userWithSameETC, userWithSameET, userWithSameE, userWithSameExperiences, userWithSameTrainings);
		userWithSameTC_T(userWithSameTC, userWithSameT, userWithSameTrainings);

		fillRecommendedUsersCollection(recommendedUser, userWithSameETC, LinkedInCsts.NB_USERS_ETC);
		fillRecommendedUsersCollection(recommendedUser, userWithSameET, LinkedInCsts.NB_USERS_ET);
		fillRecommendedUsersCollection(recommendedUser, userWithSameE, LinkedInCsts.NB_USERS_E);
		fillRecommendedUsersCollection(recommendedUser, userWithSameTC, LinkedInCsts.NB_USERS_TC);
		fillRecommendedUsersCollection(recommendedUser, userWithSameT, LinkedInCsts.NB_USERS_T);

		return recommendedUser;
	}

	/**
	 * This method allow us to get users with same experiences
	 * @param experiences correspond to the experiences of the current user
	 * @return Set<User> contains all user with the same experiences as the current one
	 */
	private Set<User> userWithSameExperiences(List<Experience> experiences){
		Set<User> users = new HashSet<User>();

		for(Experience experience : experiences){
			List<User> userWithSameExp = userDao.findByExperience(experience);

			for(User user : userWithSameExp){
				int indexExp = user.getExperiences().indexOf(experience);
				Experience userExp = user.getExperiences().get(indexExp);

				if(experience.equals(userExp)){
					users.add(user);
				}
			}
		}
		return users;
	}

	/**
	 * This method allow us to get users with the same training
	 * @param trainings correspond to the trainings of the current users
	 * @return Set<User> contains all user with the same experiences as the current one
	 */
	private Set<User> userWithSameTrainings(List<Training> trainings){
		Set<User> users = new HashSet<User>();

		for(Training training : trainings){
			List<User> userWithSameTraining = userDao.findByTraining(training);

			for(User user : userWithSameTraining){
				int indexTraining = user.getTrainings().indexOf(training);
				Training userTraining = user.getTrainings().get(indexTraining);

				if(training.equals(userTraining)){
					users.add(user);
				}
			}
		}
		return users;
	}

	/**
	 * This method will fill 3 lists based on the users from userWithSameExperiences and userWithSameTrainings:
	 * 
	 * @param userWithSameETC will be filled with users that possess a common experience, training and competences
	 * @param userWithSameET will be filled with users that possess a common experience and training
	 * @param userWithSameE will be filled with users that possess a common experience
	 * @param userWithSameExperiences correspond to the users with same experiences
	 * @param userWithSameTrainings correspond to the users with same training
	 */
	private void userWithSameETC_ET_E(List<User> userWithSameETC, List<User> userWithSameET, List<User> userWithSameE,
			Set<User> userWithSameExperiences, Set<User> userWithSameTrainings) {

		for(User user : userWithSameExperiences){
			if(userWithSameTrainings.contains(user)){
				if(compare2UsersCompetences(user)){
					userWithSameETC.add(user);
				} else {
					userWithSameET.add(user);
				}
			} else {
				userWithSameE.add(user);
			}
			userWithSameExperiences.remove(user);
			userWithSameTrainings.remove(user);
		}
	}

	/**
	 * This method will fill 2 lists based on the users from userWithSameTrainings
	 * @param userWithSameTC will be filled with the users that possess a common training and competence
	 * @param userWithSameT will be filled with the users that possess a common training
	 * @param userWithSameTrainings correspond to the users with the same training
	 */
	private void userWithSameTC_T(List<User> userWithSameTC, List<User> userWithSameT, Set<User> userWithSameTrainings){

		for(User user : userWithSameTrainings){
			if(compare2UsersCompetences(user)){
				userWithSameTC.add(user);
			} else {
				userWithSameT.add(user);
			}
			userWithSameTrainings.remove(user);
		}


	}

	/**
	 * Compare the current user and the user to check if they have a common competences
	 * @param user the user to compare with the currend user
	 * @return true if they have one or more common competences otherwise false
	 */
	private boolean compare2UsersCompetences(User user){
		Set<Competence> currUserCompetences = currUser.getCompetences();
		Set<Competence> userCompetences = user.getCompetences();

		for(Competence competence : currUserCompetences){
			if(userCompetences.contains(competence)){
				return true;
			}
		}
		return false;
	}

	/**
	 * This method will fill the recommended user list based on a number of users desired for each category
	 * We have 5 categories :
	 * <ul>
	 * <li> User with a common experience, training and competence </li>
	 * <li> User with a common experience and training</li>
	 * <li> User with a common experience </li>
	 * <li> User with a common training and competence </li>
	 * <li> User with a common training</li>
	 * </ul>
	 * @param recommendedUser correspond to the recommended user list
	 * @param users correspond to a list of users of one of the above categories
	 * @param nbUsersDesired the number of the user we want from the users list
	 */
	private void fillRecommendedUsersCollection(Set<User> recommendedUser, List<User> users, int nbUsersDesired){
		int usersSize = users.size();
		
		if(usersSize>nbUsersDesired){
			for(int i = 0; i<nbUsersDesired; i++){
				int rdm = (int) (Math.random()*usersSize+1);
				User user = users.get(rdm);
				if(recommendedUser.contains(user)){
					i--;
				} else {
					recommendedUser.add(user);
					users.remove(user);
					usersSize = users.size();
				}
			}
		} else {
			recommendedUser.addAll(users);
			users.clear();
		}
	}
}
