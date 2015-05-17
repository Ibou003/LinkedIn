package dant.linkedin.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import dant.linkedin.core.Competence;
import dant.linkedin.core.User;
import dant.linkedin.utils.LinkedInCsts;

public class Recommandation {

	private User currUser;
	private Set<User> users;
	private HashMap<User, Integer> userCommonsPoints = new HashMap<User, Integer>();

	public Recommandation(User currUser, Set<User> users) {
		super();
		this.currUser = currUser;
		this.users = users;
	}

	public List<User> initRecommandUser(){
		fillMapUsers();
		List<User> recommandUser = new ArrayList<User>();

		addUsersOnRecommandedList(recommandUser, userWithLessThan3CPs(), LinkedInCsts.NB_USER_WITH_LESS_THAN_3_CPS);
		addUsersOnRecommandedList(recommandUser, userBetween3and5CPs(), LinkedInCsts.NB_USER_BETWEEN_3_AND_5_CPTS);
		addUsersOnRecommandedList(recommandUser, userWithMoreThan5CPS(), LinkedInCsts.NB_USER_WITH_MORE_THAN_5_CPS);

		return recommandUser;
	}

	private void fillMapUsers(){
		for(User user :  users){
			int nbCommonPoint = countCommonPoint(currUser, user);
			userCommonsPoints.put(user, nbCommonPoint);
		}
	}

	private int countCommonPoint(User currUser, User user){

		Set<Competence> currUserSkills = currUser.getCompetences();
		Set<Competence> userSkills = user.getCompetences();

		int count = 0;

		for (Competence currUserSkill : currUserSkills) {
			for(Competence userSkill : userSkills){
				if(currUserSkill.equals(userSkill)){
					count ++;
				}
			}
		}
		return count;
	}

	private List<User> userWithLessThan3CPs(){
		List<User> userWithLessThan3CPs = new ArrayList<User>();

		for(Entry<User, Integer> entry : userCommonsPoints.entrySet()) {
			Integer nbCommonPoint = entry.getValue();
			if(nbCommonPoint<=3){
				User user = entry.getKey();
				userWithLessThan3CPs.add(user);
			}
		}

		return userWithLessThan3CPs;
	}

	private List<User> userBetween3and5CPs(){
		List<User> userBetween3and6CPs = new ArrayList<User>();

		for(Entry<User, Integer> entry : userCommonsPoints.entrySet()) {
			Integer nbCommonPoint = entry.getValue();
			if(nbCommonPoint>3 && nbCommonPoint<6){
				User user = entry.getKey();
				userBetween3and6CPs.add(user);
			}
		}

		return userBetween3and6CPs;
	}

	private List<User> userWithMoreThan5CPS(){
		List<User> userWithMoreThan6CPs = new ArrayList<User>();

		for(Entry<User, Integer> entry : userCommonsPoints.entrySet()) {
			Integer nbCommonPoint = entry.getValue();
			if(nbCommonPoint>5){
				User user = entry.getKey();
				userWithMoreThan6CPs.add(user);
			}
		}

		return userWithMoreThan6CPs;
	}

	private void addUsersOnRecommandedList(List<User> recommandedUsers, List<User> users, int nbDesiredUser){
		int usersSize = users.size();
		if(users.size()>0){
			for(int i = 0; i<nbDesiredUser; i++){
				int rdm = (int) (Math.random()*usersSize+1);

				User user = users.get(rdm);
				if(!recommandedUsers.contains(users)){
					recommandedUsers.add(user);
				}

			}
		}
	}
}
