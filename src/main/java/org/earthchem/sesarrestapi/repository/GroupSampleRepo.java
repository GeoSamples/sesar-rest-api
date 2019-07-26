package org.earthchem.sesarrestapi.repository;

import java.util.List;

import org.earthchem.sesarrestapi.model.GroupSample;
import org.earthchem.sesarrestapi.model.Sample;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupSampleRepo extends CrudRepository<GroupSample, Integer> {
	@Query("SELECT e.sample from GroupSample e  where (e.group.isPrivate = false and (e.sample.archiveDate is null or e.sample.archiveDate > now()) and e.sample.publishDate < now() and e.group.id = ?1) ")
	public List<Sample> getPublicSamplesById(@Param("id") Integer id, Pageable pageable);

	@Query("SELECT count(e.sample) from GroupSample e  where (e.group.isPrivate = false and (e.sample.archiveDate is null or e.sample.archiveDate > now()) and e.sample.publishDate < now() and e.group.id = ?1) ")
	public Integer getTotalPublicSamplesById(@Param("id") Integer id);

	@Query("SELECT e.sample from GroupSample e  where (e.group.isPrivate = false and (e.sample.archiveDate is null or e.sample.archiveDate > now()) and e.sample.publishDate < now() and e.group.name = ?1) ")
	public List<Sample> getPublicSamplesByName(@Param("name") String name, Pageable pageable);
	
	@Query("SELECT count(e.sample) from GroupSample e  where (e.group.isPrivate = false and (e.sample.archiveDate is null or e.sample.archiveDate > now()) and e.sample.publishDate < now() and e.group.name = ?1) ")
	public Integer getTotalPublicSamplesByName(@Param("name") String name);	
}
