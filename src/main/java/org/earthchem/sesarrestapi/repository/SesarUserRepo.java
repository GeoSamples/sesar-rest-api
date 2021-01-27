package org.earthchem.sesarrestapi.repository;

import java.util.List;

import org.earthchem.sesarrestapi.model.SesarUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesarUserRepo extends CrudRepository<SesarUser, Integer> {
	
	@Query("SELECT date_trunc('month',e.registrationDate), count(e) from SesarUser e where e.deactivationDate is null group by date_trunc('month',e.registrationDate) order by date_trunc('month',e.registrationDate) desc")
	public List<Object[]> getNewUserCountByMonth();

	@Query("SELECT date_trunc('year',e.registrationDate), count(e) from SesarUser e where e.deactivationDate is null group by date_trunc('year',e.registrationDate) order by date_trunc('year',e.registrationDate) desc")
	public List<Object[]> getNewUserCountByYear();
	
	@Query("SELECT e.country.name, count(e) as cnt from SesarUser e where e.deactivationDate is null and e.country is not null group by e.country.name order by cnt desc, e.country.name")
	public List<Object[]> getUserCountByCountry();

}
