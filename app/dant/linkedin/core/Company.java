package dant.linkedin.core;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false, length = 256)
	private String name;
	
	@Column(name = "naf", nullable = false, length = 50)
	private String naf;

	@Column(name = "registeration_number", nullable = false, length = 50)
	private String registerationNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "company_creation_date", nullable = false)
	private Date companyCreateDate;
	
	@Column(name = "email", nullable = false, length = 128)
	private String email;

	@Column(name = "password", nullable = false, length = 128)
	private String password;

	@Column(name = "phone", nullable = true, length = 20)
	private String phoneNumber;

	@Column(name = "mobile", nullable = true, length = 20)
	private String mobile;

	@Column(name = "description", nullable =true )
	private String description;

	private Address address;
	
	
	@Column(name = "user_id", nullable =false )
	private Integer userId;
	
	@OneToOne
	@JoinColumn(name = "country_id")
	Country country;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private Set<Domain> domains = new HashSet<Domain>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private Set<Offer> offers; 
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private Set<Document> documents;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private List<Post> posts;
	

//	private Set<User> subscribers;

	
	public Company() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNaf() {
		return naf;
	}


	public void setNaf(String naf) {
		this.naf = naf;
	}


	public String getRegisterationNumber() {
		return registerationNumber;
	}


	public void setRegisterationNumber(String registerationNumber) {
		this.registerationNumber = registerationNumber;
	}


	public Date getCompanyCreateDate() {
		return companyCreateDate;
	}


	public void setCompanyCreateDate(Date companyCreateDate) {
		this.companyCreateDate = companyCreateDate;
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


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}



	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}

	

	public Set<Domain> getDomains() {
		return domains;
	}


	public void setDomains(Set<Domain> domains) {
		this.domains = domains;
	}


	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", naf=" + naf
				+ ", registerationNumber=" + registerationNumber
				+ ", companyCreateDate=" + companyCreateDate + ", email="
				+ email + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", mobile=" + mobile + ", description="
				+ description + ", address=" + address + ", userId=" + userId
				+ ", country=" + country + ", domains=" + domains + ", offers="
				+ offers + ", documents=" + documents + ", posts=" + posts
				+ "]";
	}




	
}
