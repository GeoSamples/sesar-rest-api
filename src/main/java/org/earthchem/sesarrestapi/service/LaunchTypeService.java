/**
 * 
 */
package org.earthchem.sesarrestapi.service;

import java.util.HashMap;
import java.util.Optional;

import org.earthchem.sesarrestapi.model.LaunchType;
import org.earthchem.sesarrestapi.repository.LaunchTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author song
 *
 */
@Service
public class LaunchTypeService {

		@Autowired
		LaunchTypeRepo repo;

		public LaunchTypeService() {};
		
		public void setLaunchTypeRepo( LaunchTypeRepo r)
		{ this.repo = r; };
		
		/**
		 * Get launch type information from Table 'launch_type' according to id.
		 * @return LaunchTypeDAO object.
		 */
		public LaunchType get(Integer id)
		{
			Optional<LaunchType> al = repo.findById(id);
			return al.get();
		}

		/**
		 * Get launch type information from Table 'launch_type' according to Country name.
		 * @return all table data in JSON format.
		 */
		public LaunchType getByName(String name)
		{
			Optional<LaunchType> al = repo.getByName(name);
			return al.get();
		}
		
		/**
		 * Get a complete list of launch type information from Table 'launch_type'.
		 * @return all table data in JSON format.
		 */
		public HashMap<String, String > getAll()
		{
		    Iterable<LaunchType> al = repo.findAll();
		    HashMap<String,String> list = new HashMap<String, String>();
		    for(LaunchType o : al)
		    {
	                list.put(o.getLaunchTypeId().toString(), o.getName());
			 
		    }
		    return list ;
		}
		
}
