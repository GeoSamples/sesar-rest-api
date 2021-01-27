package org.earthchem.sesarrestapi.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;

import org.earthchem.sesarrestapi.repository.SampleRepo;
import org.earthchem.sesarrestapi.repository.SesarUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesarUserService {

	@Autowired
	SesarUserRepo repo;

	@Autowired
	SampleRepo repo2;
	
	public SesarUserService() {};
	
	public void setSesarUserRepo( SesarUserRepo r)
	{ this.repo = r; };

	public SesarUserRepo getSesarUserRepo()
	{ return this.repo; };

	/**
	 * Get new user count by month since SESAR inception.
	 * @return new user count by year and month.
	 */
	public LinkedHashMap<String, String> getNewUserCountByMonth() {
	LinkedHashMap<String, String> b = new LinkedHashMap<String, String>();
		
		try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		    List<Object[]> aa = repo.getNewUserCountByMonth();
		    for(Object[] oneb : aa)
		    {
		        Timestamp s= (Timestamp) oneb[0];
		    	String st = dateFormat.format(s);
		    	String c = oneb[1].toString();
		    	b.put(st, c);
		    } 
		    return b;
	    } catch(Exception e) {
			b.put("error:"+e.getMessage(), "-1");
			return b;
	    }
		
	}
	/**
	 * Get new user count by year since SESAR inception.
	 * @return new user count by year.
	 */
	public LinkedHashMap<String, String> getNewUserCountByYear() {
	LinkedHashMap<String, String> b = new LinkedHashMap<String, String>();
		
		try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		    List<Object[]> aa = repo.getNewUserCountByYear();
		    for(Object[] oneb : aa)
		    {
		        Timestamp s= (Timestamp) oneb[0];
		    	String st = dateFormat.format(s);
		    	String c = oneb[1].toString();
		    	b.put(st, c);
		    } 
		    return b;
	    } catch(Exception e) {
			b.put("error:"+e.getMessage(), "-1");
			return b;
	    }
		
	}
	
	/**
	 * Get active user count by year since SESAR inception.
	 * @return active user count by year.
	 */
	public LinkedHashMap<String, String> getActiveUserCountByYear() {
	LinkedHashMap<String, String> b = new LinkedHashMap<String, String>();
		
		try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		    List<Object[]> aa = repo2.getActiveUserCountByYear();
		    for(Object[] oneb : aa)
		    {
		        Timestamp s= (Timestamp) oneb[0];
		    	String st = dateFormat.format(s);
		    	String c = oneb[1].toString();
		    	b.put(st, c);
		    } 
		    return b;
	    } catch(Exception e) {
			b.put("error:"+e.getMessage(), "-1");
			return b;
	    }
		
	}
	
	
	/**
	 * Get active user count by month since SESAR inception.
	 * @return active user count by year and month.
	 */
	public LinkedHashMap<String, String> getActiveUserCountByMonth() {
	LinkedHashMap<String, String> b = new LinkedHashMap<String, String>();
		
		try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		    List<Object[]> aa = repo2.getActiveUserCountByMonth();
		    for(Object[] oneb : aa)
		    {
		        Timestamp s= (Timestamp) oneb[0];
		    	String st = dateFormat.format(s);
		    	String c = oneb[1].toString();
		    	b.put(st, c);
		    } 
		    return b;
	    } catch(Exception e) {
			b.put("error:"+e.getMessage(), "-1");
			return b;
	    }
		
	}
	
	/**
	 * Get registered user count by country since SESAR inception.
	 * @return registered user count by country.
	 */
	public LinkedHashMap<String, String> getRegisteredUserCountByCountry() {
	LinkedHashMap<String, String> b = new LinkedHashMap<String, String>();
		
		try {
		    List<Object[]> aa = repo.getUserCountByCountry();
		    for(Object[] oneb : aa)
		    {
		        String s= (String) oneb[0];
		    	String c = oneb[1].toString();
		    	b.put(s, c);
		    } 
		    return b;
	    } catch(Exception e) {
			b.put("error:"+e.getMessage(), "-1");
			return b;
	    }
		
	}
	
}
