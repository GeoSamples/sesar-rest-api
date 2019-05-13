package org.earthchem.sesarrestapi.repository;

import org.earthchem.sesarrestapi.model.SampleUploadHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleUploadHistoryRepo extends CrudRepository<SampleUploadHistory, Integer> {
	}
