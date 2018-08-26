package com.libraryms.maintanance.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.libraryms.maintanance.domain.Floors;


@Repository
public interface FloorsRepository extends CrudRepository<Floors, Integer>
{
  public List<Floors> findByLibraryLid(int lid);
}
