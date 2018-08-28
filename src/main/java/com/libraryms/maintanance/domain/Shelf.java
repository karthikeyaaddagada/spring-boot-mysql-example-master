package com.libraryms.maintanance.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Shelf
{ 
	@Id
	@Column(name="shelfid")
	private int shelfId;
	@Column(name="shelfname")
	private String shelfName;
	@Column(name="shelfdescription")
	private String shelfDescription;
	@ManyToOne
	@JoinColumn(name="fid")
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Floors floors;
    public Floors getFloors()
    {
		return floors;
	}
	public void setFloors(Floors floors) {
		this.floors = floors;
	}
	@OneToMany(mappedBy="shelf")
	@JsonIgnore
	private Set<Books> books=new HashSet<>();

	
	public Set<Books> getBooks() {
		return books;
	}
	public void setBooks(Set<Books> books) {
		this.books = books;
	}
	public Shelf()
	{
		
	}
	public Shelf(int shelfId,String shelfName,String shelfDescription, int fid)
	{
		super();
		this.shelfId=shelfId;
		this.shelfName=shelfName;
		this.shelfDescription=shelfDescription;
		this.floors = new Floors();
				floors.setFid(fid);
	}
	
	
	public Shelf(int shelfId)
	{
		
	}
	
	public int getShelfId() {
		return shelfId;
	}
	public void setShelfId(int shelfId) {
		this.shelfId = shelfId;
	}
	public String getShelfName() {
		return shelfName;
	}
	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}
	public String getShelfDescription() {
		return shelfDescription;
	}
	public void setShelfDescription(String shelfDescription) {
		this.shelfDescription = shelfDescription;
	}
	
	

}
