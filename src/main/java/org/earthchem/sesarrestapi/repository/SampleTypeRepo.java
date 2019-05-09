package org.earthchem.sesarrestapi.repository;

import java.util.Optional;

import org.earthchem.sesarrestapi.model.SampleType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleTypeRepo extends CrudRepository<SampleType, Integer> {
	
	  @Query("SELECT e from SampleType e where lower(e.name) = lower( ?1 )")
	  public  Optional<SampleType> getByName(@Param("name") String name);
	  

	  
	}
