package com.dl.tacoLoco.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

	private long id;
	private String name;
	private String address;
	private String state;
	private String city;
	private String zip;

	public Customer() {}
	
	public Customer(int id, String name, String address, String state, String city, String zip) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.state = state;
		this.city = city;
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", name=" + name + ", address=" + address 
				+ ", state=" + state + ", city=" + city + ", zip=" + zip + "]";
	}
	
	// Getters and Setter along with annotations to connect them H2 db
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ADDRESS", nullable = false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "STATE", nullable = false)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "CITY", nullable = false)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "ZIP", nullable = false)
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
}
