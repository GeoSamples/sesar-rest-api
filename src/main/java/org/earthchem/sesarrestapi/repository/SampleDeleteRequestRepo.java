package org.earthchem.sesarrestapi.repository;

import org.earthchem.sesarrestapi.model.SampleDeleteRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleDeleteRequestRepo extends CrudRepository<SampleDeleteRequest, Integer> {
	}
