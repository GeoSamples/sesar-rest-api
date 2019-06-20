package org.earthchem.sesarrestapi.service;

import java.util.List;

import org.earthchem.sesarrestapi.model.Sample;
import org.earthchem.sesarrestapi.repository.GroupSampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	 * Get a list of Sample from Table 'group_sample' according to public group id.
	 * @param id: group id
	 * @param limit: number of samples returned in each page.
	 * @param pagenum: the page number. Default to 0.
	 * @return a list of Sample object.
	 */
	public List<Sample> getSamplesById(Integer id, Integer limit, Integer pagenum)
	{
	    List<Sample> al = repo.getSamplesById(id,PageRequest.of(pagenum, limit));
	    return al;
	}

	/**
	 * Get total number of Sample from Table 'group_sample' according to public group id.
	 * @param id: group id
	 * @return an Integer 
	 */
	public Integer getTotalSamplesById(Integer id)
	{
	    return repo.getTotalSamplesById(id);
	}

	/**
	 * Get a list of Sample from Table 'group_sample' according to public group name.
	 * @param name: group name
	 * @param limit: number of samples returned in each page.
	 * @param pagenum: the page number. Default to 0.
	 * @return a list of Sample object.
	 */
	public List<Sample> getSamplesByName(String name, Integer limit, Integer pagenum)
	{
	    List<Sample> al = repo.getSamplesByName(name,PageRequest.of(pagenum, limit));
	    return al;
	}

	/**
	 * Get total number of Sample from Table 'group_sample' according to public group name.
	 * @param name: group name
	 * @return an Integer 
	 */
	public Integer getTotalSamplesByName(String name)
	{
	    return repo.getTotalSamplesByName(name);
	}
}
