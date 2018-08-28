package com.libraryms.maintanance.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryms.maintanance.domain.Books;
import com.libraryms.maintanance.domain.Floors;
import com.libraryms.maintanance.domain.Library;
import com.libraryms.maintanance.domain.Shelf;
import com.libraryms.maintanance.model.BooksModel;
import com.libraryms.maintanance.model.FloorsModel;
import com.libraryms.maintanance.model.LibraryModel;
import com.libraryms.maintanance.model.ShelfModel;
import com.libraryms.maintanance.repositories.LibraryRepository;

@Service
public class LibraryService 
{
	@Autowired
	//@Qualifier("LibraryRepository")
	private LibraryRepository libraryRepository;
	
	public List<LibraryModel> getAllLibrary()
	{
		List<LibraryModel> libraryModel = new ArrayList();
		List<Library> library = new ArrayList();
		 libraryRepository.findAll()
		.forEach(library::add);
		 for(Library lib : library) {
			 libraryModel.add(convertToModel(lib));
		 }
		
		
		return libraryModel;
	}
	public LibraryModel convertToModel(Library library) {
		LibraryModel libraryModel = new LibraryModel();
		libraryModel.setAddress(library.getAddress());
		libraryModel.setCity(library.getCity());
		libraryModel.setState(library.getState());
		libraryModel.setZip(library.getZip());
		libraryModel.setStreetName(library.getStreetName());
		libraryModel.setName(library.getName());
		libraryModel.setLid(library.getLid());
		
		Set<Floors> floors = library.getFloors();
		Set<FloorsModel> floorsModels = new HashSet<>();
		for(Floors flo : floors) {
			FloorsModel floorsModel = new FloorsModel();
			floorsModels.add(convertToFloor(flo));
		}
		libraryModel.setFloors(floorsModels);
		return libraryModel;
	}
	private FloorsModel convertToFloor(Floors flo) {
		//do the same
		FloorsModel floorsModel = new FloorsModel();
		floorsModel.setFid(flo.getFid());
		Set<Shelf> shelfs = flo.getShelf();
		Set<ShelfModel> shelfModels = new HashSet<>();
		for(Shelf shelf : shelfs)
		{
			 
			shelfModels.add(convertToShelf(shelf));
		}
		floorsModel.setShelf(shelfModels);
		return floorsModel;
		
	}
	private ShelfModel convertToShelf(Shelf shelf) {
		// TODO Auto-generated method stub
		
	ShelfModel shelfModel = new ShelfModel();
	shelfModel.setShelfId(shelf.getShelfId());
	shelfModel.setShelfName(shelf.getShelfName());
	shelfModel.setShelfDescription(shelf.getShelfDescription());
	Set<Books> books = shelf.getBooks();
	Set<BooksModel> booksModels = new HashSet<>();
	for(Books books1 : books)
	{
		 
		booksModels.add(covertToBooks(books1));
	}
	shelfModel.setBooks(booksModels);
		return shelfModel;
	}
	private BooksModel covertToBooks(Books books)
	{
		// TODO Auto-generated method stub
		BooksModel booksModel = new BooksModel();
		booksModel.setBookId(books.getBookId());
		booksModel.setName(books.getName());
		booksModel.setDescription(books.getDescription());
		booksModel.setAuthor(books.getAuthor());
		
		return booksModel;
	}
	public LibraryModel getLibrary(int lid)
	{
	    Library lib = libraryRepository.findById(lid).orElse(new Library());
		return convertToModel(lib);
		
	}
	
	public void addLibrary(Library library)
	{
		libraryRepository.save(library);
	}

	public void updateLibrary(int lid, Library library)
	{
		library.setLid(lid);
		System.out.println(library.getLid());
	libraryRepository.save(library);
    }
	public void deleteLibrary(int lid)
	{
		libraryRepository.deleteById(lid);
	}
	
}
