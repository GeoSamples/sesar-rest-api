package org.earthchem.sesarrestapi.repository;

import org.earthchem.sesarrestapi.model.SesarRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesarRoleRepo extends CrudRepository<SesarRole, Integer> {
	}
