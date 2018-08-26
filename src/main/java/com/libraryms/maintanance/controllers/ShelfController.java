package com.libraryms.maintanance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.libraryms.maintanance.domain.Floors;
import com.libraryms.maintanance.domain.Shelf;
import com.libraryms.maintanance.services.ShelfService;



@RestController
public class ShelfController 
{

    @Autowired
	private ShelfService shelfService;
	
	
	@RequestMapping("/floors/{fid}/shelf")
    public List<Shelf> getAllShelf(@PathVariable int fid)
    {
    	return shelfService.getAllShelf(fid);
    }
	@RequestMapping("/floors/{fid}/shelf/{shelfId}")
    public Shelf getShelf(@PathVariable int shelfId) 
    {
    	return shelfService.getShelf(shelfId);
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/floors/{fid}/shelf")
	public void addShelf(@RequestBody Shelf shelf,@PathVariable int fid)
	{
		Floors floors = new Floors();
		floors.setFid(fid);
	    shelf.setFloors(floors);
	     shelfService.addShelf(shelf);
	}
	/*@RequestMapping(method=RequestMethod.PUT, value="/employee/{eid}/location/{locationLid}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable("locationLid") int Lid, @PathVariable("eid") int eid)
	{
		Location location = new Location();
		location.setLid(Lid);
 		employee.setLocation(location);
	     employeeService.updateEmployee(employee);	
	}*/
	
	@RequestMapping(method=RequestMethod.PUT, value="/floors/{fid}/shelf/{shelfId}")
	public void updateShelf(@RequestBody Shelf shelf,@PathVariable int fid,@PathVariable int shelfId)
	{
		Floors floors = new Floors();
		floors.setFid(fid);
	    shelf.setFloors(floors);
	     shelfService.updateShelf(shelf);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value ="/floors/{fid}/shelf/{shelfId}")
    public void deleteShelf(@PathVariable int shelfId) 
    {
    	shelfService.deleteShelf(shelfId);
    }
}
