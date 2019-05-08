package org.earthchem.sesarrestapi.repository;

import org.earthchem.sesarrestapi.model.Classification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesarUserCodeRoleRepo extends CrudRepository<Classification, Integer> {
	}
