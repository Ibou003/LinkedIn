package linkedIn.core;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import linkedIn.utils.LinkedInUtils;

public class Comment {

	private String userName;
	private Date date;
	private String description;
	private List<User> listLikes;
	private List<Comment> comments;
	
	public Comment(String userName, String description) {
		this.userName = userName;
		this.date = LinkedInUtils.createCurrentDate();
		this.description = description;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public List<User> getLikes() {
		return listLikes;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addLike(User user) {
		if(listLikes.isEmpty()){
			listLikes = new ArrayList<User>();
		}
		listLikes.add(user);
	}
	
	public void addComment(Comment comment) {
		if(comments.isEmpty()){
			comments = new ArrayList<Comment>();
		}
		comments.add(comment);
	}
}
