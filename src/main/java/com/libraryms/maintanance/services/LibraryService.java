package com.libraryms.maintanance.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryms.maintanance.domain.Library;
import com.libraryms.maintanance.repositories.LibraryRepository;

@Service
public class LibraryService 
{
	@Autowired
	//@Qualifier("LibraryRepository")
	private LibraryRepository libraryRepository;
	
	public List<Library> getAllLibrary()
	{
		List<Library> library = new ArrayList();
		libraryRepository.findAll()
		.forEach(library::add);
		return library;
	}
	public Library getLibrary(int lid)
	{
	    return libraryRepository.findById(lid).orElse(null);
		
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
