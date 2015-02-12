package linkedIn.core;

import java.util.ArrayList;
import java.util.List;

public class Company {
	
	private String name;
	private String mail;
	private String phoneNumber;
	private Adress adress;
	private String password;
	private String photo;
	private List<User> followers;
	private String description;
	private String siren_siret;
	private List<Offer> offers;
	private MailBox mailBox;
	private List<Notification> notifications;
	
	public Company(String name, String mail, String phoneNumber, Adress adress, String password, String photo, String description, String siren_siret) {
		this.name = name;
		this.mail = mail;
		this.phoneNumber = phoneNumber;
		this.adress = adress;
		this.password = password;
		this.photo = photo;
		this.description = description;
		this.siren_siret = siren_siret;
		this.mailBox = new MailBox();
	}

	public String getName() {
		return name;
	}
	
	public String getMail() {
		return mail;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Adress getAdress() {
		return adress;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public List<User> getFollower() {
		return followers;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getSiren_siret() {
		return siren_siret;
	}
	
	public List<Offer> getOffers() {
		return offers;
	}
	
	public MailBox getMailBox() {
		return mailBox;
	}
	
	public List<Notification> getNotifications() {
		return notifications;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setSiren_siret(String siren_siret) {
		this.siren_siret = siren_siret;
	}
	
	public void addFollower(User user){
		if(followers.isEmpty()){
			followers = new ArrayList<User>();
		}
		followers.add(user);
	}
	
	public void addOffer(Offer offer){
		if(offers.isEmpty()){
			offers = new ArrayList<Offer>();
		}
		offers.add(offer);
	}
	
	public void addNotification(Notification notification){
		if(notifications.isEmpty()){
			notifications = new ArrayList<Notification>();
		}
		notifications.add(notification);
	}
}
