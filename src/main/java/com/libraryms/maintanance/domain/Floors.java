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
public class Floors {
	@Id
	@Column(name = "fid")
	private int fid;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "library_lid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Library library;

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	@OneToMany(mappedBy = "floors")
	@JsonIgnore
	private Set<Shelf> shelf = new HashSet<>();

	public Set<Shelf> getShelf() {
		return shelf;
	}

	public void setShelf(Set<Shelf> shelf) {
		this.shelf = shelf;
	}

	
	public Floors()
	{

	}
	public Floors(int fid,int lid) 
	{
	super();
	this.fid=fid;
	this.library=new Library();
	library.setLid(lid);
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

}
