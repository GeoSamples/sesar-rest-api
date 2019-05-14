package org.earthchem.sesarrestapi.repository;

import java.util.List;
import java.util.Optional;

import org.earthchem.sesarrestapi.model.Sample;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepo extends CrudRepository<Sample, Integer> {
	
	 @Query("SELECT distinct e.collectionMethod from Sample e  where (e.archiveDate is null or e.archiveDate > now()) and e.collectionMethod is not null order by e.collectionMethod")
	 public  List<String> getCollectionMethods();
	  
	  @Query("SELECT distinct e.platformType from Sample e where (e.archiveDate is null or e.archiveDate > now()) and e.platformType is not null order by e.platformType")
	  public  List<String> getPlatformTypes();

	  @Query("SELECT distinct e.primaryLocationType from Sample e where (e.archiveDate is null or e.archiveDate > now()) and e.primaryLocationType is not null order by e.primaryLocationType")
	  public  List<String> getPrimaryLocationTypes();

	  @Query("SELECT distinct e.platformName from Sample e where (e.archiveDate is null or e.archiveDate > now()) and e.platformName is not null order by e.platformName")
	  public  List<String> getPlatformNames();

	  @Query("SELECT distinct e.cruiseFieldPrgrm from Sample e where (e.archiveDate is null or e.archiveDate > now()) and e.cruiseFieldPrgrm is not null order by e.cruiseFieldPrgrm")
	  public  List<String> getCruiseFieldPrgrm();

	  @Query("SELECT distinct e.collector from Sample e where (e.archiveDate is null or e.archiveDate > now()) and e.collector is not null order by e.collector")
	  public  List<String> getCollectors();

	  @Query("SELECT e from Sample e where lower(e.igsn) = lower( ?1 )")
	  public  Optional<Sample> getByIGSN(@Param("igsn") String igsn);

	}
