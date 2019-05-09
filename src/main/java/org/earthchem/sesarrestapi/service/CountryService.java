package org.earthchem.sesarrestapi.service;

import java.util.HashMap;
import java.util.Optional;

import org.earthchem.sesarrestapi.model.Country;
import org.earthchem.sesarrestapi.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

	@Autowired
	CountryRepo repo;

	public CountryService() {};
	
	public void setCountryRepo( CountryRepo r)
	{ this.repo = r; };
	
	/**
	 * Get a Country information from Table 'Country' according to id.
	 * @return Country object.
	 */
	public Country get(Integer id)
	{
		Optional<Country> al = repo.findById(id);
		return al.get();
	}

	/**
	 * Get a Country information from Table 'Country' according to Country name.
	 * @return all table data in JSON format.
	 */
	public Country getByName(String name)
	{
		Optional<Country> al = repo.getByName(name);
		return al.get();
	}
	
	/**
	 * Get a complete list of Country information from Table 'Country'.
	 * @return all table data in JSON format.
	 */
	public HashMap<String, String > getAll()
	{
		Iterable<Country> al = repo.findAll();
		HashMap<String,String> list = new HashMap<String, String>();
		for(Country o : al)
		{
          list.put(o.getCountryId().toString(), o.getName());
		 
		}
		return list ;
	}
	
}
