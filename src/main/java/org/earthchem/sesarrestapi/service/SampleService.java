/**
 * 
 */
package org.earthchem.sesarrestapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.earthchem.sesarrestapi.dao.SampleJSONLDDAO;
import org.earthchem.sesarrestapi.model.Sample;
import org.earthchem.sesarrestapi.repository.SampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author song
 */
@Service
public class SampleService {

	@Autowired
	SampleRepo repo;

	public SampleService() {};
		
	public void setSampleRepo( SampleRepo r)
	{ this.repo = r; };
		
	/**
	 * Get a Get a sample information from Table 'sample' according sample id.
	 * @return Sample object.
	 */
	public Sample get(Integer id)
	{
	    Optional<Sample> al = repo.findById(id);
	    return al.get();
	}

	/**
	 * Get a sample information from Table 'sample' according igsn.
	 * @return Sample object.
	 */
	public Sample getByIGSN(String name)
	{
	    Optional<Sample> al = repo.getByIGSN(name);
	    return al.get();
	}

	/**
	 * Get a sample information from Table 'sample' according to sample name.
	 * @return Sample object.
	 */
	public List<Sample> getByName(String name)
	{
	    List<Sample> al = repo.getBySampleName(name);
	    return al;
	}
		
	/**
	 * Get a existing list of platform type from table 'sample' platform_type column.
	 * @return  a list of string.
	 */
	public List<String> getPlatformTypes()
	{
	    return repo.getPlatformTypes() ;
	}

	/**
	 * Get a existing list of collection method from table 'sample' collection_method column.
	 * @return  a list of string.
	 */
	public List<String> getCollectionMethods()
	{
		List<String> rl =  repo.getCollectionMethods() ;
		return rl;
	}

	/**
	 * Get a existing list of physiographic feature from table 'sample' primary_location_type column.
	 * @return  a list of string.
	 */
	public List<String> getPrimaryLocationTypes()
	{
	    return repo.getPrimaryLocationTypes() ;
	}


	/**
	 * Get a existing list of platform name from table 'sample' platform_name column.
	 * @return a list of string.
	 */
	public List<String> getPlatformNames()
	{
		List<String> rl =  repo.getPlatformNames() ;
		return rl;
	}
	
	/**
	 * Get a existing list of cruise or field program names from table 'sample' field_name column.
	 * @return  a list of string.
	 */
	public List<String> getCruiseFieldPrgrm()
	{
		List<String> rl =  repo.getCruiseFieldPrgrm() ;
		return rl;
	}
	
	
	/**
	 * Get a existing list of collector from table 'sample' collector column.
	 * @return  a list of string.
	 */
	public List<String> getCollectors()
	{
		List<String> rl =  repo.getCollectors() ;
		return rl;
	}
	
	
	/**
	 * Get a list of IGSNs from table 'sample' which is owned by the user
	 * @id: The geopass id
	 * @return  a list of string of IGSNs.
	 */
	public List<String> getIGSNsByGeoPassId(Integer id, Integer limit, Integer pagenum)
	{
		List<String> rl =  repo.getIGSNsByGeoPassId(id,PageRequest.of(pagenum,limit)) ;
		return rl;
	}
	
	/**
	 * Get a list of IGSNs from table 'sample' which is owned by the user
	 * @name: The geopass user name
	 * @return  a list of string of IGSNs.
	 */
	public List<String> getIGSNsByGeoPassUserName(String name, Integer limit, Integer pagenum)
	{
		List<String> rl =  repo.getIGSNsByGeoPassUsername(name, PageRequest.of(pagenum,limit)) ;
		return rl;
	}
	
	/**
	 * Get a list of IGSNs from table 'sample' according to its user code 
	 * @param usercode: IGSN user code or prefix
	 * @param hidePrivate: if it is 1, the returned list will not include IGSNs whose metadata are not public.
	 * @return  a list of string of IGSNs.
	 */
	public List<String> getIGSNsByUserCode(String usercode, Integer hidePrivate, Integer limit, Integer pagenum)
	{
		List<String> rl = new ArrayList<String>();

		if( hidePrivate != null && hidePrivate.intValue() == 1 )
			rl =  repo.getPublicIGSNsByUserCode(usercode,PageRequest.of(pagenum, limit));
		else
			rl =  repo.getAllIGSNsByUserCode(usercode,PageRequest.of(pagenum,limit));

		return rl;
	}
	/**
	 * Get a list of IGSNs from table 'sample' according to cruise or field program name
	 * @param field_name: cruise or field program name. It is case insensitive.
	 * @param hidePrivate: if it is 1, the returned list will not include IGSNs whose metadata are not public.
	 * @return  a list of string of IGSNs.
	 */
	public List<String> getIGSNsByCruiseFieldProgram(String field_name, Integer hidePrivate, Integer limit, Integer pagenum)
	{
		List<String> rl = new ArrayList<String>();

		if( hidePrivate != null && hidePrivate.intValue() == 1 )
			rl =  repo.getPublicIGSNsByCruiseFieldProgram(field_name,PageRequest.of(pagenum, limit));
		else
			rl =  repo.getAllIGSNsByCruiseFieldProgram(field_name,PageRequest.of(pagenum,limit));

		return rl;
	}
	/**
	 * Get total number of IGSN from table 'sample' according to geopass id
	 * @name: The geopass id
	 * @return total number of IGSNs.
	 */
	public Integer getIGSNCountByGeoPassId(Integer id)
	{
		Integer r =  repo.getIGSNCountByGeoPassId(id) ;
		return r;
	}
	
	/**
	 * Get total number of IGSN from table 'sample' according to geopass username
	 * @name: The geopass user name
	 * @return total number of IGSNs.
	 */
	public Integer getIGSNCountByGeoPassUserName(String name)
	{
		Integer rl =  repo.getIGSNCountByGeoPassUsername(name) ;
		return rl;
	}
}
