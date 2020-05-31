/**
 * Class SampleService
 */
package org.earthchem.sesarrestapi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.earthchem.sesarrestapi.model.Sample;
import org.earthchem.sesarrestapi.repository.SampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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

	
	/**
	 * Get total number of publised IGSN.
	 * @return total number of IGSN published.
	 */
	public Integer getAllPublishedIGSNTotalNumber()
	{
		return repo.getAllPublishedIGSNTotalNumber();
	}
	
	/**
	 * Get total number of publised parent IGSN.
	 * @return total number of IGSN published.
	 */
	public Integer getAllPublishedParentIGSNTotalNumber()
	{
		return repo.getAllPublishedParentIGSNTotalNumber();
	}
	

	/**
	 * Get published IGSNs with sample type
	 * @return IGSNs with sample types.
	 */
	public HashMap<String, ArrayList<String>> getAllPublishedIGSNs(Integer limit,Integer pagenum)
	{
		List<Object[]> igsn_types = repo.getAllPublishedIGSNs(PageRequest.of(pagenum,limit));		
		HashMap<String, ArrayList<String>> l = new HashMap<String, ArrayList<String>>();
		String currKey="";
		for (Object[] entry : igsn_types)
		{
			currKey = (String) entry[0];
		    if(l.containsKey(currKey)) //Exists Key
		    {
		    	l.get(currKey).add((String) entry[1]);
		    }
		    else
		    {
		    	ArrayList<String> a = new ArrayList<String>();
		    	a.add((String) entry[1]);
		    	l.put(currKey, a);
		    }		    	
		}
	    return l;
	}
	
	/**
	 * Get published top level parent IGSNs with sample type
	 * @return IGSNs with sample types.
	 */
	public HashMap<String, ArrayList<String>> getAllPublishedParentIGSNs(Integer limit,Integer pagenum)
	{
		List<Object[]> igsn_types = repo.getAllPublishedParentIGSNs(PageRequest.of(pagenum,limit));		
		HashMap<String, ArrayList<String>> l = new HashMap<String, ArrayList<String>>();
		String currKey="";
		for (Object[] entry : igsn_types)
		{
			currKey = (String) entry[0];
		    if(l.containsKey(currKey)) //Exists Key
		    {
		    	l.get(currKey).add((String) entry[1]);
		    }
		    else
		    {
		    	ArrayList<String> a = new ArrayList<String>();
		    	a.add((String) entry[1]);
		    	l.put(currKey, a);
		    }		    	
		}
	    return l;
	}
	
	/**
	 * Get IGSN according sample name and user code
	 * @return IGSN
	 */
	public List<String> getIGSNBySampleNameUserCode(String name, String usercode)
	{
		return repo.getIGSNBySampleNameUserCode(name, usercode);
	}
}
