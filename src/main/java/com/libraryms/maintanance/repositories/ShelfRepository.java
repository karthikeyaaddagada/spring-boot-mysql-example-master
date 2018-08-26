package com.libraryms.maintanance.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.libraryms.maintanance.domain.Shelf;

@Repository
public interface ShelfRepository extends CrudRepository<Shelf,Integer>
{
   	public List<Shelf> findByFloorsFid(int fid);
}
