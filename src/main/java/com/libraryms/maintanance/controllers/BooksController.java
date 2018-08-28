package com.libraryms.maintanance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.libraryms.maintanance.domain.Books;

import com.libraryms.maintanance.domain.Shelf;
import com.libraryms.maintanance.services.BooksService;

@RestController
public class BooksController
{
	@Autowired
	private BooksService booksService;
	
	
	@RequestMapping("shelf/{shelfId}/books")
    public List<Books> getAllBooks(@PathVariable int shelfId)
    {
    	return booksService.getAllBooks(shelfId);
    }
	@RequestMapping("shelf/{shelfId}/books/{bookId}")
    public Books getShelf(@PathVariable int bookId) 
    {
    	return booksService.getBooks(bookId);
    }
	@RequestMapping("/books/{author}")
    public List<Books> getAllBooks(@PathVariable String author)
    {
    	return booksService.getAllBooks(author);
    }
	
	
	@RequestMapping(method=RequestMethod.POST, value="/shelf/{shelfId}/books")
	public void addBooks(@RequestBody Books books,@PathVariable int shelfId)
	{
		Shelf shelf = new Shelf();
		shelf.setShelfId(shelfId);
	     books.setShelf(shelf);
	     booksService.addBooks(books);
	}

	
	@RequestMapping(method=RequestMethod.PUT, value="shelf/{shelfId}/books/{bookId}")
	public void updateShelf(@RequestBody Books books,@PathVariable int shelfId,@PathVariable int bookId)
	{
		Shelf shelf = new Shelf();
		shelf.setShelfId(shelfId);
	     books.setShelf(shelf);
	     booksService.updateBooks(books);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value ="shelf/{shelfId}/books/{bookId}")
    public void deleteBooks(@PathVariable int bookId) 
    {
    	booksService.deleteBooks(bookId);
    }
}
