package com.libraryms.maintanance.model;

import java.util.HashSet;
import java.util.Set;




public class LibraryModel
{

	
	private int lid;

	private String name;
	
	private String address;
	
	private String streetName;
	
	private String city;
	
	private String state;
	
	private int zip;
	
	
	public Set<FloorsModel> floors = new HashSet<>();
	
	public Set<FloorsModel> getFloors() {
		return floors;
	}
	public void setFloors(Set<FloorsModel> floors) {
		this.floors = floors;
	}
	
	public LibraryModel()
	{
		
	}
	public LibraryModel(int lid,String name,String address,String streetname,String city,String state,int zip)
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
