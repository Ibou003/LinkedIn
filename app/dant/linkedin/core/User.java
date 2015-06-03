package dant.linkedin.core;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Analyze;
import views.html.index;


/**
 * @author Nourdine
 */

@Entity
@Indexed
@Table(name = "users")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "last_name", nullable = false, length = 128)
	private String lastName;

	@Column(name = "first_name", nullable = false, length = 128)
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

	@Column(name = "state_user", nullable = false, length = 128)
	@Enumerated(EnumType.STRING)
	private StateUser stateUser;

	private Address address;

	@OneToMany(cascade = CascadeType.ALL ,fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private List<Training> trainings;

	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Set<Language> languages;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Set<Competence> competences;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Experience> experiences;

	//	@JoinTable(name = "relation",
	//		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
	//		inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id")
	//	)
	//	private Set<User> relations;


	//	private Set<Message> messages;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Set<Company> companys;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<Post> posts;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<Document> documents;

	//	@OneToOne
	//	private BoxInternalMessage boxInternalMessage;

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

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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


	@Override
	public String toString()
	{
		return "User [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", phone=" + phone + ", mobile="
				+ mobile + ", description=" + description + ", email=" + email + ", password=" + password + ", country="
				+ country + ", stateUser=" + stateUser + ", address=" + address + ", trainings=" + trainings + ", languages="
				+ languages + ", competences=" + competences + ", experiences=" + experiences + ", companys=" + companys
				+ ", posts=" + posts + ", documents=" + documents + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((companys == null) ? 0 : companys.hashCode());
		result = prime * result
				+ ((competences == null) ? 0 : competences.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((documents == null) ? 0 : documents.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((experiences == null) ? 0 : experiences.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((stateUser == null) ? 0 : stateUser.hashCode());
		result = prime * result + ((trainings == null) ? 0 : trainings.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (companys == null) {
			if (other.companys != null)
				return false;
		} else if (!companys.equals(other.companys))
			return false;
		if (competences == null) {
			if (other.competences != null)
				return false;
		} else if (!competences.equals(other.competences))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (documents == null) {
			if (other.documents != null)
				return false;
		} else if (!documents.equals(other.documents))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (experiences == null) {
			if (other.experiences != null)
				return false;
		} else if (!experiences.equals(other.experiences))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		if (stateUser != other.stateUser)
			return false;
		if (trainings == null) {
			if (other.trainings != null)
				return false;
		} else if (!trainings.equals(other.trainings))
			return false;
		return true;
	}








}