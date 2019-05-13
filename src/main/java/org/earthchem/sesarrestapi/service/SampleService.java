/**
 * 
 */
package org.earthchem.sesarrestapi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.earthchem.sesarrestapi.model.Sample;
import org.earthchem.sesarrestapi.repository.SampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author song
 *
 */
@Service
public class SampleService {

	@Autowired
	SampleRepo repo;

	public SampleService() {};
		
	public void setSampleRepo( SampleRepo r)
	{ this.repo = r; };
		
	/**
	 * Get a navigation type information from Table 'nav_type' according to id.
	 * @return Sample object.
	 */
	public Sample get(Integer id)
	{
	    Optional<Sample> al = repo.findById(id);
	    return al.get();
	}

	/**
	 * Get a navigation type information from Table 'nav_type' according to navigation type name.
	 * @return all table data in JSON format.
	 */
	public Sample getByIGSN(String name)
	{
	    Optional<Sample> al = repo.getByIGSN(name);
	    return al.get();
	}
		
	/**
	 * Get a existing list of platform type from table 'sample' platform_type column.
	 * @return all data in JSON format.
	 */
	public List<String> getPlatformTypes()
	{
	    return repo.getPlatformTypes() ;
	}

	/**
	 * Get a existing list of collection method from table 'sample' collection_method column.
	 * @return all data in JSON format.
	 */
	public List<String> getCollectionMethods()
	{
		List<String> rl =  repo.getCollectionMethods() ;
		return rl;
	}

	/**
	 * Get a existing list of physiographic feature from table 'sample' primary_location_type column.
	 * @return all data in JSON format.
	 */
	public List<String> getPrimaryLocationTypes()
	{
	    return repo.getPrimaryLocationTypes() ;
	}

}
