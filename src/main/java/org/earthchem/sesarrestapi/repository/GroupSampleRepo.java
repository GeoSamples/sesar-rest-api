package org.earthchem.sesarrestapi.repository;

import org.earthchem.sesarrestapi.model.GroupSample;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupSampleRepo extends CrudRepository<GroupSample, Integer> {
	}
