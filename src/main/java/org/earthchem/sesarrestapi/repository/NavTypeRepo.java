package org.earthchem.sesarrestapi.repository;

import java.util.Optional;

import org.earthchem.sesarrestapi.model.NavType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NavTypeRepo extends CrudRepository<NavType, Integer> {
	
	  @Query("SELECT e from NavType e where lower(e.name) = lower( ?1 )")
	  public  Optional<NavType> getByName(@Param("name") String name);
	  

	}
