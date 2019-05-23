package org.earthchem.sesarrestapi.service;

import java.util.List;

import org.earthchem.sesarrestapi.model.Sample;
import org.earthchem.sesarrestapi.repository.GroupSampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author song
 *
 */
@Service
public class GroupSampleService {

	@Autowired
	GroupSampleRepo repo;

	public GroupSampleService() {};
		
	public void setGroupSampleRepo( GroupSampleRepo r)
	{ this.repo = r; };
		
	/**
	 * Get a list of Sample from Table 'group_sample' according to group id.
	 * @return a list of Sample object.
	 */
	public List<Sample> getSamplesById(Integer id)
	{
	    List<Sample> al = repo.getSamplesById(id);
	    return al;
	}

}
