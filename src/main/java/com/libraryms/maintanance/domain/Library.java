package com.libraryms.maintanance.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Library
{

	@Id
	@Column(name = "lid")
	private int lid;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "streetName")
	private String streetName;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "zip")
	private int zip;
	
	@OneToMany(mappedBy="library")
	@JsonIgnore
	public Set<Floors> floors = new HashSet<>();
	
	public Set<Floors> getFloors() {
		return floors;
	}
	public void setFloors(Set<Floors> floors) {
		this.floors = floors;
	}
	
	public Library()
	{
		
	}
	public Library(int lid,String name,String address,String streetname,String city,String state,int zip)
	{
		super();
		this.lid=lid;
		this.name=name;
		this.address=address;
		this.streetName=streetname;
		this.city=city;
		this.state=state;
		this.zip=zip;
	}
	
	public int getLid() {
		return lid;
	}


	public void setLid(int lid) {
		this.lid = lid;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	
}
