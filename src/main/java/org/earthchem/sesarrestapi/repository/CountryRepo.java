package org.earthchem.sesarrestapi.repository;

import java.util.Optional;

import org.earthchem.sesarrestapi.model.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends CrudRepository<Country, Integer> {
	
	  @Query("SELECT e from Country e where lower(e.name) = lower( ?1 )")
	  public  Optional<Country> getByName(@Param("name") String name);
	  

}
