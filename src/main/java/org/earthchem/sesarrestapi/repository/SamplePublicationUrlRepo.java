package org.earthchem.sesarrestapi.repository;

import org.earthchem.sesarrestapi.model.SamplePublicationUrl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SamplePublicationUrlRepo extends CrudRepository<SamplePublicationUrl, Integer> {
	}
