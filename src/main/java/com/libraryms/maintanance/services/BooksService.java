package com.libraryms.maintanance.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.libraryms.maintanance.domain.Books;
import com.libraryms.maintanance.repositories.BooksRepository;


@Service
public class BooksService 
{
	@Autowired
	//@Qualifier("BooksRepository")
	private BooksRepository booksRepository;
	
	public List<Books> getAllBooks(int shelfId)
	{
		List<Books> books = new ArrayList<>();
		booksRepository.findByShelfShelfId(shelfId)
		.forEach(books::add);
		return books;
	}
	public List<Books> getAllBooks(String author)
	{
		List<Books> books = new ArrayList<>();
		booksRepository.findByAuthor(author)
		.forEach(books::add);
		return books;
	}
	public Books getBooks(int bookId)
	{
	    return booksRepository.findById(bookId).orElse(null);
	}
	public void addBooks(Books books)
	{
	     booksRepository.save(books);
	}
	public void updateBooks(Books books)
	{
	    booksRepository.save(books);
    }
	public void deleteBooks(int bookId)
	{
		booksRepository.deleteById(bookId);
		
	}
}
