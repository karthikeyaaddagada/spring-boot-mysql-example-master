package com.libraryms.maintanance.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.libraryms.maintanance.domain.Library;
import com.libraryms.maintanance.model.LibraryModel;
import com.libraryms.maintanance.services.LibraryService;

@RestController
public class LibraryController 
{

    @Autowired
	private LibraryService libraryService;
	
	@RequestMapping("/library")
    public List<LibraryModel> getAllLibrary()
    {
    	return libraryService.getAllLibrary();
    }
   
	@RequestMapping("/library/{lid}")
    public LibraryModel getLibrary(@PathVariable int lid) 
    {
    	return libraryService.getLibrary(lid);
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/library")
	public void addLibrary(@RequestBody Library library)
	{
	     libraryService.addLibrary(library);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/library/{lid}")
	public void updateLibrary(@RequestBody Library library,@PathVariable int lid)
	{
	     libraryService.updateLibrary(lid, library);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value ="/library/{lid}")
    public void deleteLibrary(@PathVariable int lid) 
    {
    	libraryService.deleteLibrary(lid);
    }
}
