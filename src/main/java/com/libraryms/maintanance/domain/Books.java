package com.libraryms.maintanance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Books {
	@Id
	@Column(name = "bookid")
	private int bookId;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "author")
	private String author;
	@ManyToOne
	@JoinColumn(name = "shelfid")
	@JsonIgnore
	private Shelf shelf;

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	public Books() {

	}

	public Books(int bookId, String name, String description, String author,int shelfId) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.description = description;
		this.author = author;
		this.shelf = new Shelf();
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
