package org.earthchem.sesarrestapi.repository;

import org.earthchem.sesarrestapi.model.SesarUserCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesarUserCodeRepo extends CrudRepository<SesarUserCode, Integer> {
	}
