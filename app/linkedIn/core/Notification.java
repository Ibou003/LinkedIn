package linkedIn.core;

//import java.util.List;
import java.sql.Date;

public class Notification {
	private String msg_notif;
	private String username;
	private int id_user; // option: id du mec pour une recherche par ID
	private Date date;
	/**
	 * @return the msg_notif
	 */
	public String getMsg_notif() {
		return msg_notif;
	}
	/**
	 * @param msg_notif the msg_notif to set
	 */
	public void setMsg_notif(String msg_notif) {
		this.msg_notif = msg_notif;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the id_user
	 */
	public int getId_user() {
		return id_user;
	}
	/**
	 * @param id_user the id_user to set
	 */
	public void setId_user(int id_user) {
		this.id_user = id_user;
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
