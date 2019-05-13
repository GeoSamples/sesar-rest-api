package org.earthchem.sesarrestapi.repository;

import org.earthchem.sesarrestapi.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends CrudRepository<Group, Integer> {
	}
