package dant.linkedin.core;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Nourdine
 */

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "lastName", nullable = false, length = 128)
	private String lastName;

	@Column(name = "firstName", nullable = false, length = 128)
	private String firstName;

	@Column(name = "phone", nullable = true, length = 64)
	private String phone;

	@Column(name = "mobile", nullable = true, length = 64)
	private String mobile;

	@Column(name = "description", nullable = true)
	private String description;

	@Column(name = "email", nullable = false, length = 128)
	private String email;

	@Column(name = "password", nullable = false, length = 128)
	private String password;

	/** Identifying of country. */
	@OneToOne
	@JoinColumn(name = "country_id")
	private Country country;

	@Enumerated(EnumType.STRING)
	private StateUser stateUser;

	private Address address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Training> trainings;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<Language> languages;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<Competence> competences;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Experience> experiences;

	@JoinTable(name = "relation",
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id")
	)
	private Set<User> relations;
	
	private Set<Message> messages;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<Company> companys;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<Post> posts;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<Document> documents;

	@OneToOne
	private BoxInternalMessage boxInternalMessage;

	public User() {
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	public StateUser getStateUser() {
		return stateUser;
	}


	public void setStateUser(StateUser stateUser) {
		this.stateUser = stateUser;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public List<Training> getTrainings() {
		return trainings;
	}


	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}


	public Set<Language> getLanguages() {
		return languages;
	}


	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}


	public Set<Competence> getCompetences() {
		return competences;
	}


	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}


	public List<Experience> getExperiences() {
		return experiences;
	}


	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}


	public Set<User> getRelations() {
		return relations;
	}


	public void setRelations(Set<User> relations) {
		this.relations = relations;
	}


	public Set<Company> getCompanys() {
		return companys;
	}


	public void setCompanys(Set<Company> companys) {
		this.companys = companys;
	}


	public Set<Post> getPosts() {
		return posts;
	}


	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}


	public Set<Document> getDocuments() {
		return documents;
	}


	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}


	public BoxInternalMessage getBoxInternalMessage() {
		return boxInternalMessage;
	}


	public void setBoxInternalMessage(BoxInternalMessage boxInternalMessage) {
		this.boxInternalMessage = boxInternalMessage;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", lastName=" + lastName + ", firstName="
				+ firstName + ", phone=" + phone + ", mobile=" + mobile
				+ ", description=" + description + ", email=" + email
				+ ", password=" + password + ", country=" + country
				+ ", stateUser=" + stateUser + ", address=" + address
				+ ", trainings=" + trainings + ", languages=" + languages
				+ ", competences=" + competences + ", experiences="
				+ experiences + ", relations=" + relations + ", companys="
				+ companys + ", posts=" + posts + ", documents=" + documents
				+ ", boxInternalMessage=" + boxInternalMessage + "]";
	}


	public Set<Message> getMessages() {
		return messages;
	}


	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	
}