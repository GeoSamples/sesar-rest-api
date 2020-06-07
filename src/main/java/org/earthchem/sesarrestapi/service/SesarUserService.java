package org.earthchem.sesarrestapi.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;

import org.earthchem.sesarrestapi.repository.SesarUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesarUserService {

	@Autowired
	SesarUserRepo repo;

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
}
