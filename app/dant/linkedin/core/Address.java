package dant.linkedin.core;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "number", nullable = true)
	private int number;

	@Column(name = "street_name", nullable = true, length = 256)
	private String streetName;

	@Column(name = "city", nullable = true, length = 256)
	private String city;

	@Column(name = "zip_code", nullable = true, length = 128)
	private String zipCode;

	public Address() {
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [number=" + number + ", streetName=" + streetName
				+ ", city=" + city + ", zipCode=" + zipCode + "]";
	}

}
