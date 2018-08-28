package com.libraryms.maintanance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.libraryms.maintanance.domain.Floors;
import com.libraryms.maintanance.domain.Library;
import com.libraryms.maintanance.services.FloorsService;


@RestController
public class FloorsController 
{
	@Autowired
	private FloorsService floorsService;
	
	
	@RequestMapping("/library/{lid}/floors")
    public List<Floors> getAllFloors(@PathVariable int lid)
    {
    	return floorsService.getAllFloors(lid);
    }
	@RequestMapping("/library/{lid}/floors/{fid}")
    public Floors getFloors(@PathVariable int fid) 
    {
    	return floorsService.getFloors(fid);
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/library/{lid}/floors")
	public void addFloors(@RequestBody Floors floors, @PathVariable("lid") int lid)
	{
		Library library = new Library();
		library.setLid(lid);
		floors.setLibrary(library);
	     floorsService.updateFloors(floors);	
	}

	
	@RequestMapping(method=RequestMethod.PUT, value="/library/{lid}/floors/{fid}")
	public void updateFloors(@RequestBody Floors floors, @PathVariable("lid") int lid, @PathVariable("fid") int fid)
	{
		Library library = new Library();
		library.setLid(lid);
		floors.setLibrary(library);
	     floorsService.addFloors(floors);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value ="/library/{lid}/floors/{fid}")
    public void deleteFloors(@PathVariable int fid) 
    {
    	floorsService.deleteFloors(fid);
    }
}
