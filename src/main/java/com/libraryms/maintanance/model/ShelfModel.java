package com.libraryms.maintanance.model;

import java.util.HashSet;
import java.util.Set;


public class ShelfModel
{ 
	
	private int shelfId;
	private String shelfName;
	
	private String shelfDescription;
	
	private FloorsModel floors;
    public FloorsModel getFloors()
    {
		return floors;
	}
	public void setFloors(FloorsModel floors) {
		this.floors = floors;
	}
	
	private Set<BooksModel> books=new HashSet<>();

	
	public Set<BooksModel> getBooks() {
		return books;
	}
	public void setBooks(Set<BooksModel> books) {
		this.books = books;
	}
	public ShelfModel()
	{
		
	}
	public ShelfModel(int shelfId,String shelfName,String shelfDescription, int fid)
	{
		super();
		this.shelfId=shelfId;
		this.shelfName=shelfName;
		this.shelfDescription=shelfDescription;
		this.floors = new FloorsModel();
				floors.setFid(fid);
	}
	
	
	public ShelfModel(int shelfId)
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
