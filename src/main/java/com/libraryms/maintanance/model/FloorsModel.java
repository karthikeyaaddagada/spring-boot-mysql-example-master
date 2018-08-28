package com.libraryms.maintanance.model;

import java.util.HashSet;
import java.util.Set;


public class FloorsModel {
	
	private int fid;
	
	private LibraryModel library;

	public LibraryModel getLibrary() {
		return library;
	}

	public void setLibrary(LibraryModel library) {
		this.library = library;
	}


	
	private Set<ShelfModel> shelf = new HashSet<>();

	public Set<ShelfModel> getShelf() {
		return shelf;
	}

	public void setShelf(Set<ShelfModel> shelf) {
		this.shelf = shelf;
	}

	
	public FloorsModel()
	{

	}
	public FloorsModel(int fid,int lid) 
	{
	super();
	this.fid=fid;
	this.library=new LibraryModel();
	library.setLid(lid);
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

}
