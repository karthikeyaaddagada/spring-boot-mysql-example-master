package com.libraryms.maintanance.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.libraryms.maintanance.domain.Shelf;
import com.libraryms.maintanance.repositories.ShelfRepository;

@Service
public class ShelfService
{
	@Autowired
	//@Qualifier("ShelfRepository")
	private ShelfRepository shelfRepository;
	public List<Shelf> getAllShelf(int fid)
	{
		List<Shelf> shelf = new ArrayList<>();
		shelfRepository.findByFloorsFid(fid)
		.forEach(shelf::add);
		return shelf;
	}
	public Shelf getShelf(int shelfId)
	{
	    return shelfRepository.findById(shelfId).orElse(null);
	}
	public void addShelf(Shelf shelf)
	{
	     shelfRepository.save(shelf);
	}
	public void updateShelf(Shelf shelf)
	{
	    shelfRepository.save(shelf);
    }
	public void deleteShelf(int shelfId)
	{
		shelfRepository.deleteById(shelfId);
		
	}

}
