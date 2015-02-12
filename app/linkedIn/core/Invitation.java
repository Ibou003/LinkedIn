package linkedIn.core;

import java.util.List;
import java.sql.Date;

public class Invitation {
	private List<User> user;
	private String message;
	private Date date;
	/**
	 * @return the user
	 */
	public List<User> getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(List<User> user) {
		this.user = user;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
}
