package org.earthchem.sesarrestapi.repository;

import java.sql.Timestamp;
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
	
    @Query("SELECT distinct e.collectionMethod from Sample e  where (e.archiveDate is null or e.archiveDate >= now()) and e.collectionMethod is not null order by e.collectionMethod")
	public List<String> getCollectionMethods();
	  
	@Query("SELECT distinct e.platformType from Sample e where (e.archiveDate is null or e.archiveDate >= now()) and e.platformType is not null order by e.platformType")
	public List<String> getPlatformTypes();

	@Query("SELECT distinct e.primaryLocationType from Sample e where (e.archiveDate is null or e.archiveDate >= now()) and e.primaryLocationType is not null order by e.primaryLocationType")
	public List<String> getPrimaryLocationTypes();

	@Query("SELECT distinct e.platformName from Sample e where (e.archiveDate is null or e.archiveDate >= now()) and e.platformName is not null order by e.platformName")
	public List<String> getPlatformNames();

	@Query("SELECT distinct e.cruiseFieldPrgrm from Sample e where (e.archiveDate is null or e.archiveDate >= now()) and e.cruiseFieldPrgrm is not null order by e.cruiseFieldPrgrm")
	public List<String> getCruiseFieldPrgrm();

	@Query("SELECT distinct e.collector from Sample e where (e.archiveDate is null or e.archiveDate >= now()) and e.collector is not null order by e.collector")
	public List<String> getCollectors();

	@Query("SELECT e from Sample e where e.igsn = ?1 ")
	public  Optional<Sample> getByIGSN(@Param("igsn") String igsn);
	  
	@Query("SELECT e.igsn from Sample e where e.sesarUser1.ssoAccountId = ?1 and ( e.archiveDate is null or e.archiveDate >= now() ) order by e.sampleId ")
	public List<String> getIGSNsByGeoPassId(@Param("id") Integer id, Pageable pageable);
	  
	@Query("SELECT e.igsn from Sample e where lower(e.sesarUser1.geopassId) = lower(?1) and ( e.archiveDate is null or e.archiveDate >= now() ) order by e.sampleId ")
	public List<String> getIGSNsByGeoPassUsername(@Param("name") String name, Pageable pageable);

	@Query("SELECT e.igsn from Sample e where lower(e.sesarUserCode.userCode) = lower(?1) and ( e.archiveDate is null or e.archiveDate >= now() ) order by e.sampleId ")
	public List<String> getAllIGSNsByUserCode(@Param("user_code") String user_code, Pageable pageable);

	@Query("SELECT e.igsn from Sample e where lower(e.sesarUserCode.userCode) = lower(?1) and ( e.archiveDate is null or e.archiveDate >= now() ) order by e.sampleId ")
	public List<String> getPublicIGSNsByUserCode(@Param("user_code") String user_code, Pageable pageable);

	@Query("SELECT e.igsn from Sample e where lower(e.cruiseFieldPrgrm) like CONCAT('%',lower(?1),'%') and ( e.archiveDate is null or e.archiveDate >= now() ) order by e.sampleId")
	public List<String> getAllIGSNsByCruiseFieldProgram(@Param("name") String name, Pageable pageable);

	@Query("SELECT e.igsn from Sample e where lower(e.cruiseFieldPrgrm) like CONCAT('%',lower(?1),'%') and ( e.archiveDate is null or e.archiveDate >= now() ) order by e.sampleId ")
	public List<String> getPublicIGSNsByCruiseFieldProgram(@Param("name") String name, Pageable pageable);

    @Query("SELECT count(e.igsn) from Sample e where e.sesarUser1.ssoAccountId = ?1 ")
	public Integer getIGSNCountByGeoPassId(@Param("id") Integer id);
	  
	@Query("SELECT count(e.igsn) from Sample e where lower(e.sesarUser1.geopassId) = lower(?1) ")
	public Integer getIGSNCountByGeoPassUsername(@Param("name") String name);

	@Query("SELECT e from Sample e where lower(e.name) like CONCAT('%',lower(?1),'%')")
	public  List<Sample> getBySampleName(@Param("name") String name);

	@Query("SELECT e.sampleType3.name, e.igsn from Sample e where e.publishDate < now() and ( e.archiveDate is null or e.archiveDate >= now()) order by e.sampleId")
	public  List<Object[]> getAllPublishedIGSNs(Pageable pageable);	

	@Query("SELECT e.igsn,e.lastUpdateDate from Sample e where e.sample is not null and e.publishDate < now() and ( e.archiveDate is null or e.archiveDate >= now()) order by e.sampleId")
	public  List<Object[]> getAllPublishedRootIGSNWithLastUpdate(Pageable pageable);

	@Query("SELECT e.igsn,e.lastUpdateDate from Sample e where e.publishDate < now() and ( e.archiveDate is null or e.archiveDate >= now()) order by e.sampleId")
	public  List<Object[]> getAllPublishedIGSNWithLastUpdate(Pageable pageable);
	
	@Query("SELECT count(e.igsn) from Sample e where e.publishDate < now() and ( e.archiveDate is null or e.archiveDate >= now() ) ")
	public Integer getAllPublishedIGSNTotalNumber();	

	@Query("SELECT e.sampleType3.name, e.igsn from Sample e where e.publishDate < now() and ( e.archiveDate is null or e.archiveDate >= now()) and e.sample is null order by e.sampleId")
	public  List<Object[]> getAllPublishedParentIGSNs(Pageable pageable);
	
	@Query("SELECT count(e.igsn) from Sample e where e.publishDate < now() and ( e.archiveDate is null or e.archiveDate >= now() ) and e.sample is null ")
	public Integer getAllPublishedParentIGSNTotalNumber();
	
	@Query("SELECT e.igsn from Sample e where  e.name = ?1 and lower(e.sesarUserCode.userCode) = lower(?2) ")
	public List<String> getIGSNBySampleNameUserCode(@Param("name") String name, @Param("user_code") String user_code);
	
	@Query("SELECT e.igsn from Sample e where  e.name = ?1 and lower(e.sesarUserCode.userCode) = lower(?2) and e.publishDate < now() and ( e.archiveDate is null or e.archiveDate >= now() ) ")
	public List<String> getPublicIGSNBySampleNameUserCode(@Param("name") String name, @Param("user_code") String user_code);	
	
	@Query("SELECT e.sesarUser1.institution, count(e), e.sesarUser1.country.name from Sample e where e.registrationDate >?1 and e.registrationDate <?2 and e.publishDate < now() and ( e.archiveDate is null or e.archiveDate >= now() ) and e.sesarUser1.institution is not null group by e.sesarUser1.institution, e.sesarUser1.country.name order by count(e) desc")
	public List<Object[]> getPublicIGSNCountByInstitude(@Param("start_date") Timestamp start_date, @Param("end_date") Timestamp end_date);
	
	@Query("SELECT e.sesarUser1.institution, count(e), e.sesarUser1.country.name  from Sample e where e.registrationDate >?1 and e.registrationDate <?2 and ( e.archiveDate is null or e.archiveDate >= now() ) and e.sesarUser1.institution is not null group by e.sesarUser1.institution, e.sesarUser1.country.name order by count(e) desc")
	public List<Object[]> getAllIGSNCountByInstitude(@Param("start_date") Timestamp start_date, @Param("end_date") Timestamp end_date);

	@Query("SELECT date_trunc('year',e.registrationDate), count(distinct e.sesarUser1.sesarUserId) from Sample e where e.archiveDate is null or e.archiveDate >= now() group by date_trunc('year',e.registrationDate) order by date_trunc('year',e.registrationDate) desc")
	public List<Object[]> getActiveUserCountByYear();	

	@Query("SELECT date_trunc('month',e.registrationDate), count(distinct e.sesarUser1.sesarUserId) from Sample e where e.archiveDate is null or e.archiveDate >= now() group by date_trunc('month',e.registrationDate) order by date_trunc('month',e.registrationDate) desc")
	public List<Object[]> getActiveUserCountByMonth();
	
	@Query("SELECT e.sampleType3.name, count(e.igsn) from Sample e where e.registrationDate <?1 and e.publishDate < now() and ( e.archiveDate is null or e.archiveDate >= now()) group by e.sampleType3.name order by count(e.igsn) desc")
	public List<Object[]> getPublishedIGSNCountBySampleType(@Param("end_date") Timestamp end_date);
	
	@Query("SELECT e.sampleType3.name, count(e.igsn) from Sample e where e.registrationDate <?1 and ( e.archiveDate is null or e.archiveDate >= now()) group by e.sampleType3.name order by count(e.igsn) desc")
	public List<Object[]> getIGSNCountBySampleType(@Param("end_date") Timestamp end_date);
}