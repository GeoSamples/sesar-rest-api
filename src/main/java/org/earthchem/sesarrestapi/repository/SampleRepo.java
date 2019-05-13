package org.earthchem.sesarrestapi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.earthchem.sesarrestapi.model.Sample;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepo extends CrudRepository<Sample, Integer> {
	
//	  @Query("SELECT distinct e.collectionMethod from Sample e and ( e.archiveDate is null or e.archiveDate > now() ) order by e.collectionMethod")
//	  public  List<String> getCollectionMethods();
	  
//	  @Query("SELECT distinct e.platformType from Sample e and ( e.archiveDate is null or e.archiveDate > now() ) order by e.platformType")
//	  public  ArrayList<String> getPlatformTypes();

//	  @Query("SELECT distinct e.primaryLocationType from Sample e and ( e.archiveDate is null or e.archiveDate > now() ) order by e.primaryLocationType")
//	  public  ArrayList<String> getPrimaryLocationTypes();

	  @Query("SELECT e from Sample e where lower(e.igsn) = lower( ?1 )")
	  public  Optional<Sample> getByIGSN(@Param("igsn") String igsn);

	}
