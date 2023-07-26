package com.ems.pojo;

public class Address {
	private int addressid;
	private String city;
	private String country;
	private int empid;
	
	public Address() {
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}
	
	@Override
	public String toString() {
		return addressid+" : "+city+" : "+country;
	}	
}