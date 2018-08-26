package com.libraryms.maintanance.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.libraryms.maintanance.domain.Books;


@Repository
public interface BooksRepository extends CrudRepository<Books,Integer>
{ 
	public List<Books> findByShelfShelfId(int shelfId);
	public List<Books> findByAuthor(String author);
}
