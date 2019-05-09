package org.earthchem.sesarrestapi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.earthchem.sesarrestapi.model.Classification;
import org.earthchem.sesarrestapi.repository.ClassificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassificationService {

	@Autowired
	ClassificationRepo repo;

	public ClassificationService() {};
	
	public void setClassificationRepo( ClassificationRepo r)
	{ this.repo = r; };
	
	/**
	 * Get a Classification information from Table 'Classification' according to id.
	 * @return Classification object.
	 */
	public Classification get(Integer id)
	{
		Optional<Classification> al = repo.findById(id);
		return al.get();
	}

	/**
	 * Get a Classification information from Table 'Classification' according to Classification name.
	 * @return all table data in JSON format.
	 */
	public Classification getByName(String name)
	{
		Optional<Classification> al = repo.getByName(name);
		return al.get();
	}
	
	/**
	 * Get a complete list of classification information from Table 'classification'.
	 * @return all table data in JSON format.
	 */
	public HashMap<String, ArrayList<String> > getAll()
	{
		Iterable<Classification> al = repo.findAll();
		HashMap<String,ArrayList<String>> list = new HashMap<String, ArrayList<String>>();
		for(Classification o : al)
		{
		  Classification p = o.getClassification();
		  if(p != null) //parent classification exists
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
			  if(list.containsKey("materials"))
			  {
				  list.get("materials").add(o.getName());
			  }
			  else
			  {
			    ArrayList<String> n= new ArrayList<String>();
			    n.add(o.getName());
			    list.put("materials", n);
		      }
		  }
		}
		return list ;
	}

	
	/**
	 * Get a complete list of materials from Table 'classification'.
	 * @return all table data in JSON format.
	 */
	public HashMap<String, ArrayList<String> > getAllMaterials()
	{
		Iterable<Classification> al = repo.findAll();
		HashMap<String,ArrayList<String>> list = new HashMap<String, ArrayList<String>>();
		for(Classification o : al)
		{
		  Classification p = o.getClassification();
		  if(p != null) //parent classification exists, meaning it is a sub type of main material
		  {
			  continue;
		  }
		  else
		  {
			  if(list.containsKey("materials"))
			  {
				  list.get("materials").add(o.getName());
			  }
			  else
			  {
			    ArrayList<String> n= new ArrayList<String>();
			    n.add(o.getName());
			    list.put("materials", n);
		      }
		  }
		}
		return list ;
	}
	
}
