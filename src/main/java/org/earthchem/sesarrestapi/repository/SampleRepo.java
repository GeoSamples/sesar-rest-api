package org.earthchem.sesarrestapi.repository;

import java.util.List;
import java.util.Optional;

import org.earthchem.sesarrestapi.model.Sample;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepo extends CrudRepository<Sample, Integer> {
	
    @Query("SELECT distinct e.collectionMethod from Sample e  where (e.archiveDate is null or e.archiveDate > now()) and e.collectionMethod is not null order by e.collectionMethod")
	public List<String> getCollectionMethods();
	  
	@Query("SELECT distinct e.platformType from Sample e where (e.archiveDate is null or e.archiveDate > now()) and e.platformType is not null order by e.platformType")
	public List<String> getPlatformTypes();

	@Query("SELECT distinct e.primaryLocationType from Sample e where (e.archiveDate is null or e.archiveDate > now()) and e.primaryLocationType is not null order by e.primaryLocationType")
	public List<String> getPrimaryLocationTypes();

	@Query("SELECT distinct e.platformName from Sample e where (e.archiveDate is null or e.archiveDate > now()) and e.platformName is not null order by e.platformName")
	public List<String> getPlatformNames();

	@Query("SELECT distinct e.cruiseFieldPrgrm from Sample e where (e.archiveDate is null or e.archiveDate > now()) and e.cruiseFieldPrgrm is not null order by e.cruiseFieldPrgrm")
	public List<String> getCruiseFieldPrgrm();

	@Query("SELECT distinct e.collector from Sample e where (e.archiveDate is null or e.archiveDate > now()) and e.collector is not null order by e.collector")
	public List<String> getCollectors();

	@Query("SELECT e from Sample e where lower(e.igsn) = lower( ?1 )")
	public  Optional<Sample> getByIGSN(@Param("igsn") String igsn);
	  
	@Query("SELECT e.igsn from Sample e where e.sesarUser1.ssoAccountId = ?1 order by e.igsn ")
	public List<String> getIGSNsByGeoPassId(@Param("id") Integer id, Pageable pageable);
	  
	@Query("SELECT e.igsn from Sample e where lower(e.sesarUser1.geopassId) = lower(?1) and ( e.archiveDate is null or e.archiveDate >= now() ) order by e.igsn ")
	public List<String> getIGSNsByGeoPassUsername(@Param("name") String name, Pageable pageable);

	@Query("SELECT e.igsn from Sample e where lower(e.sesarUserCode.userCode) = lower(?1) and ( e.archiveDate is null or e.archiveDate >= now() ) order by e.igsn ")
	public List<String> getAllIGSNsByUserCode(@Param("user_code") String user_code, Pageable pageable);

	@Query("SELECT e.igsn from Sample e where lower(e.sesarUserCode.userCode) = lower(?1) and e.publishDate < now() and ( e.archiveDate is null or e.archiveDate >= now() ) order by e.igsn ")
	public List<String> getPublicIGSNsByUserCode(@Param("user_code") String user_code, Pageable pageable);

	@Query("SELECT e.igsn from Sample e where lower(e.cruiseFieldPrgrm) like CONCAT('%',lower(?1),'%') and ( e.archiveDate is null or e.archiveDate >= now() ) order by e.igsn")
	public List<String> getAllIGSNsByCruiseFieldProgram(@Param("name") String name, Pageable pageable);

	@Query("SELECT e.igsn from Sample e where lower(e.cruiseFieldPrgrm) like CONCAT('%',lower(?1),'%') and e.publishDate < now() and ( e.archiveDate is null or e.archiveDate >= now() ) order by e.igsn ")
	public List<String> getPublicIGSNsByCruiseFieldProgram(@Param("name") String name, Pageable pageable);

    @Query("SELECT count(e.igsn) from Sample e where e.sesarUser1.ssoAccountId = ?1 ")
	public Integer getIGSNCountByGeoPassId(@Param("id") Integer id);
	  
	@Query("SELECT count(e.igsn) from Sample e where lower(e.sesarUser1.geopassId) = lower(?1) ")
	public Integer getIGSNCountByGeoPassUsername(@Param("name") String name);

	@Query("SELECT e from Sample e where lower(e.name) like CONCAT('%',lower(?1),'%')")
	public  List<Sample> getBySampleName(@Param("name") String name);

}
