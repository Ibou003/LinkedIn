package linkedIn.core;

import java.util.List;

import com.lezas.entity.Adress;
import com.lezas.entity.Comment;

public class User {
	
	private String lastName;
	private String firstName;
	private String mail;
	private String phoneNumber;
	private Adress adress;
	private String password;
	private String photo;
	private String description;
	private MailBox mailBox;
	private CV cv;
	private List<User> relations;
	private List<Company> companysFollowing;
	private List<Notification> notifications;
	private List<Comment> comments;
	
}
