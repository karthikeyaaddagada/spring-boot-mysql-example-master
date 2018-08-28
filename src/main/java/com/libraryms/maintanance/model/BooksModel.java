package com.libraryms.maintanance.model;



public class BooksModel {
	
	private int bookId;

	private String name;
	
	private String description;

	private String author;
	
	private ShelfModel shelf;

	public ShelfModel getShelf() {
		return shelf;
	}

	public void setShelf(ShelfModel shelf) {
		this.shelf = shelf;
	}

	public BooksModel() {

	}

	public BooksModel(int bookId, String name, String description, String author,int shelfId) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.description = description;
		this.author = author;
		this.shelf = new ShelfModel();
		shelf.setShelfId(shelfId);
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
