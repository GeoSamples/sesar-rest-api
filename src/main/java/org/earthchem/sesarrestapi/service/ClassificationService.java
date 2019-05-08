package org.earthchem.sesarrestapi.service;

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
}
