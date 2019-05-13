package org.earthchem.sesarrestapi.repository;

import java.util.Optional;

import org.earthchem.sesarrestapi.model.LaunchType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface LaunchTypeRepo extends CrudRepository<LaunchType, Integer> {

          @Query("SELECT e from LaunchType e where lower(e.name) = lower( ?1 )")
          public  Optional<LaunchType> getByName(@Param("name") String name);


	}
