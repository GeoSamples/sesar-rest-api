package org.earthchem.sesarrestapi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.earthchem.sesarrestapi.model.SampleType;
import org.earthchem.sesarrestapi.repository.SampleTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleTypeService {

	@Autowired
	SampleTypeRepo repo;

	public SampleTypeService() {};
	
	public void setSampleTypeRepo( SampleTypeRepo r)
	{ this.repo = r; };
	
	/**
	 * Get a sample type information from Table 'sample_type' according to id.
	 * @return SampleType object.
	 */
	public SampleType get(Integer id)
	{
		Optional<SampleType> al = repo.findById(id);
		return al.get();
	}

	/**
	 * Get a sample type information from Table 'sample_type' according to SampleType name.
	 * @return all table data in JSON format.
	 */
	public SampleType getByName(String name)
	{
		Optional<SampleType> al = repo.getByName(name);
		return al.get();
	}
	
	/**
	 * Get a complete list of sample type information from Table 'sample_type'.
	 * @return all table data in JSON format.
	 */
	public HashMap<String, ArrayList<String> > getAll()
	{
		Iterable<SampleType> al = repo.findAll();
		HashMap<String,ArrayList<String>> list = new HashMap<String, ArrayList<String>>();
		for(SampleType o : al)
		{
		  SampleType p = o.getSampleType();
		  if(p != null) //parent SampleType exists
		  {
			  if(list.containsKey(p.getName()))
			  {
				  list.get(p.getName()).add(o.getName());
			  }
			  else
			  {
			    ArrayList<String> n= new ArrayList<String>();
			    n.add(o.getName());
			    list.put(p.getName(),n);
			  }
		  }
		  else
		  {
			  if(list.containsKey("objecttypes"))
			  {
				  list.get("objecttypes").add(o.getName());
			  }
			  else
			  {
			    ArrayList<String> n= new ArrayList<String>();
			    n.add(o.getName());
			    list.put("objecttypes", n);
		      }
		  }
		}
		return list ;
	}

	
	/**
	 * Get a complete list of top level sample type from table 'sample_type'.
	 * @return all table data in JSON format.
	 */
	public HashMap<String, ArrayList<String> > getAllMaterials()
	{
		Iterable<SampleType> al = repo.findAll();
		HashMap<String,ArrayList<String>> list = new HashMap<String, ArrayList<String>>();
		for(SampleType o : al)
		{
		  SampleType p = o.getSampleType();
		  if(p != null) //parent SampleType exists, meaning it is a sub type of main material
		  {
			  continue;
		  }
		  else
		  {
			  if(list.containsKey("objecttypes"))
			  {
				  list.get("objecttypes").add(o.getName());
			  }
			  else
			  {
			    ArrayList<String> n= new ArrayList<String>();
			    n.add(o.getName());
			    list.put("objecttypes", n);
		      }
		  }
		}
		return list ;
	}
	
}
