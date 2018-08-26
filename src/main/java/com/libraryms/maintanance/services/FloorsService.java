package com.libraryms.maintanance.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.libraryms.maintanance.domain.Floors;
import com.libraryms.maintanance.repositories.FloorsRepository;



@Service
public class FloorsService 
{
	@Autowired
	//@Qualifier("FloorsRepository")
	private FloorsRepository floorsRepository;
	public List<Floors> getAllFloors(int lid)
	{
		List<Floors> floors = new ArrayList<>();
		floorsRepository.findByLibraryLid(lid)
		.forEach(floors::add);
		return floors;
	}
	public Floors getFloors(int fid)
	{
	    return floorsRepository.findById(fid).orElse(null);
	}
	public void addFloors(Floors floors)
	{
	     floorsRepository.save(floors);
	}
	public void updateFloors(Floors floor)
	{
	    floorsRepository.save(floor);
    }
	public void deleteFloors(int fid)
	{
		floorsRepository.deleteById(fid);
		
	}
}
