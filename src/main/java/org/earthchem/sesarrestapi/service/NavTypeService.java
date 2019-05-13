/**
 * 
 */
package org.earthchem.sesarrestapi.service;

import java.util.HashMap;
import java.util.Optional;

import org.earthchem.sesarrestapi.model.NavType;
import org.earthchem.sesarrestapi.repository.NavTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author song
 *
 */
@Service
public class NavTypeService {

	@Autowired
	NavTypeRepo repo;

	public NavTypeService() {};
		
	public void setNavTypeRepo( NavTypeRepo r)
	{ this.repo = r; };
		
	/**
	 * Get a navigation type information from Table 'nav_type' according to id.
	 * @return NavType object.
	 */
	public NavType get(Integer id)
	{
	    Optional<NavType> al = repo.findById(id);
	    return al.get();
	}

	/**
	 * Get a navigation type information from Table 'nav_type' according to navigation type name.
	 * @return all table data in JSON format.
	 */
	public NavType getByName(String name)
	{
	    Optional<NavType> al = repo.getByName(name);
	    return al.get();
	}
		
	/**
	 * Get a complete list of navigation type information from Table 'nav_type'.
	 * @return all table data in JSON format.
	 */
	public HashMap<String, String > getAll()
	{
	    Iterable<NavType> al = repo.findAll();
	    HashMap<String,String> list = new HashMap<String, String>();
	    for(NavType o : al)
	    {
                list.put(o.getNavTypeId().toString(), o.getName());

	    }
	    return list ;
	}

}
