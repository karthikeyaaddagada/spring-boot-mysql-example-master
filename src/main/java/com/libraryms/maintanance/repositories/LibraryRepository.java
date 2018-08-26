package com.libraryms.maintanance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.libraryms.maintanance.domain.Library;
@Repository
public interface LibraryRepository extends CrudRepository<Library,Integer>
{

}
