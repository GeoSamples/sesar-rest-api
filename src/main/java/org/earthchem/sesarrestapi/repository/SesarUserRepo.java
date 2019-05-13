package org.earthchem.sesarrestapi.repository;

import org.earthchem.sesarrestapi.model.SesarUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesarUserRepo extends CrudRepository<SesarUser, Integer> {
	}
