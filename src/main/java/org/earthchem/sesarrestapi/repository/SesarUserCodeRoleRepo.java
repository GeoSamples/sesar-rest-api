package org.earthchem.sesarrestapi.repository;

import org.earthchem.sesarrestapi.model.SesarUserCodeRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesarUserCodeRoleRepo extends CrudRepository<SesarUserCodeRole, Integer> {
	}
