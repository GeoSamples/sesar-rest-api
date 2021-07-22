/**
 * Class SampleService
 */
package org.earthchem.sesarrestapi.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.earthchem.sesarrestapi.model.Sample;
import org.earthchem.sesarrestapi.repository.SampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

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
		if(repo.existsByIGSN(name) == true)
		{
	      Optional<Sample> al = repo.getByIGSN(name.toUpperCase());
	      return al.get();
		}
		return null;
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
			rl =  repo.getPublicIGSNsByUserCode(usercode.toUpperCase(),PageRequest.of(pagenum, limit));
		else
			rl =  repo.getAllIGSNsByUserCode(usercode.toUpperCase(),PageRequest.of(pagenum,limit));

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
	 * Get published top level parent IGSNs with last update date.
	 * @return IGSNs with last update date.
	 */
	public HashMap<String, ArrayList<String>> getAllPublishedRootIGSNWithLastUpdate(Integer limit,Integer pagenum)
	{
		List<Object[]> igsn_types = repo.getAllPublishedRootIGSNWithLastUpdate(PageRequest.of(pagenum,limit));		
		HashMap<String, ArrayList<String>> l = new HashMap<String, ArrayList<String>>();
		String currKey="";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for (Object[] entry : igsn_types)
		{
			currKey = (String) entry[0];
		    if(l.containsKey(currKey)) //Exists Key
		    {
		    	Timestamp t = (Timestamp) entry[1];
		    	l.get(currKey).add( formatter.format( t.toLocalDateTime() ));
		    }
		    else
		    {
		    	ArrayList<String> a = new ArrayList<String>();
		    	Timestamp t = (Timestamp) entry[1];
                a.add( formatter.format( t.toLocalDateTime() ));
		    	l.put(currKey, a);
		    }		    	
		}
	    return l;
	}	
	
	/**
	 * Get published IGSNs with last update date.
	 * @return IGSNs with last update date.
	 */
	public HashMap<String, ArrayList<String>> getAllPublishedIGSNWithLastUpdate(Integer limit,Integer pagenum)
	{
		List<Object[]> igsn_types = repo.getAllPublishedIGSNWithLastUpdate(PageRequest.of(pagenum,limit));		
		HashMap<String, ArrayList<String>> l = new HashMap<String, ArrayList<String>>();
		String currKey="";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for (Object[] entry : igsn_types)
		{
			currKey = (String) entry[0];
		    if(l.containsKey(currKey)) //Exists Key
		    {
		    	Timestamp t = (Timestamp) entry[1];
		    	l.get(currKey).add( formatter.format( t.toLocalDateTime() ));
		    }
		    else
		    {
		    	ArrayList<String> a = new ArrayList<String>();
		    	Timestamp t = (Timestamp) entry[1];
                a.add( formatter.format( t.toLocalDateTime() ));
		    	l.put(currKey, a);
		    }		    	
		}
	    return l;
	}
	
	
	/**
	 * Get IGSN according sample name and user code
	 * @return IGSN
	 */
	public List<String> getIGSNBySampleNameUserCode(String name, String usercode, Integer hideprivate) 
	{
		if( hideprivate != null && hideprivate.intValue() == 1 )
		   return repo.getPublicIGSNBySampleNameUserCode(name, usercode);
		else
		   return repo.getIGSNBySampleNameUserCode(name, usercode); //Get All IGSNs regardless public or private
	}
	/**
	 * Get IGSN count between start_date and end_date. If hideprivate is 1, unpublished IGSNs are excluded.
	 * @return IGSN count from registration date begins with 'start_date' and ends with 'end_date' for the different institutions.
	 */
	public LinkedHashMap<String, String> getIGSNCountByInstitude(String start_date, String end_date, Integer hideprivate) 
	{
		LinkedHashMap<String, String> b = new LinkedHashMap<String, String>();
		try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    Date startDate = dateFormat.parse(start_date);
		    Timestamp start = new java.sql.Timestamp(startDate.getTime());
		    Date endDate = dateFormat.parse(end_date);
		    Timestamp end = new java.sql.Timestamp(endDate.getTime());

		    if( hideprivate != null && hideprivate.intValue() == 1 )
		    {
                List<Object[]> a = repo.getPublicIGSNCountByInstitude(start, end);
                for(Object[] oneb : a)
                {
                     String s= (String) oneb[0];
                     String c = oneb[1].toString();
                     if( oneb.length > 2)
                     {
                       String d = (String) oneb[2];
                       b.put(s+","+d, c);
                     }
                     else
                    	 b.put(s, c);
                }
		    }
		    else
		    {
                 List<Object[]> aa = repo.getAllIGSNCountByInstitude(start, end); //Get All IGSNs regardless public or private
                 for(Object[] oneb : aa)
                 {
                     String s= (String) oneb[0];
                     String c = oneb[1].toString();
                     if( oneb.length > 2)
                     {
                       String d = (String) oneb[2];
                       b.put(s+","+d, c);
                     }
                     else
                    	 b.put(s, c);
                 }
		    }
		    return b;
	    } catch(Exception e) {
			b.put("error:"+e.getMessage(), "-1");
			return b;
	    }
	}

	/**
	 * Get IGSN count up to end date. If hideprivate is 1, unpublished IGSNs are excluded.
	 * @return IGSN count from inception to 'end_date' for the different sample types.
	 */
	public LinkedHashMap<String, String> getIGSNCountBySampleType(String end_date, Integer hideprivate) 
	{
		LinkedHashMap<String, String> b = new LinkedHashMap<String, String>();
		try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    Date endDate = dateFormat.parse(end_date);
		    Timestamp end = new java.sql.Timestamp(endDate.getTime());

		    if( hideprivate != null && hideprivate.intValue() == 1 )
		    {
                List<Object[]> a = repo.getPublishedIGSNCountBySampleType(end);
                for(Object[] oneb : a)
                {
                     String s= (String) oneb[0];
                     String c = oneb[1].toString();
                     b.put(s, c);
                }
		    }
		    else
		    {
                 List<Object[]> aa = repo.getIGSNCountBySampleType(end); //Get All IGSNs regardless public or private
                 for(Object[] oneb : aa)
                 {
                     String s= (String) oneb[0];
                     String c = oneb[1].toString();
                     b.put(s, c);
                 }
		    }
		    return b;
	    } catch(Exception e) {
			b.put("error:"+e.getMessage(), "-1");
			return b;
	    }
	}
}
