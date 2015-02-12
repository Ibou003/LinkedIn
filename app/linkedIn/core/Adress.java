package linkedIn.core;

public class Adress {
	
	private int streetNum;
	private String streetName;
	private int zipCode;
	private String city;
	
	public Adress(int streetNum, String streetName, int zipCode, String city) {
		this.streetNum = streetNum;
		this.streetName = streetName;
		this.zipCode = zipCode;
		this.city = city;
	}
	
	public int getStreetNum() {
		return streetNum;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public String getCity() {
		return city;
	}

	public String toString(){
		return streetNum + " "+ streetName + " "+zipCode+" "+city;
	}
}
