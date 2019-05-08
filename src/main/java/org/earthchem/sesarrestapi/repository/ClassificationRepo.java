package org.earthchem.sesarrestapi.repository;

import java.util.Optional;

import org.earthchem.sesarrestapi.model.Classification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepo extends CrudRepository<Classification, Integer> {
	
	  @Query("SELECT e from Classification e where lower(e.name) = lower( ?1 )")
	  public  Optional<Classification> getByName(@Param("name") String name);
	  

}
