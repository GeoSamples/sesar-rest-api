package org.earthchem.sesarrestapi.dao;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * The data access class for the launch_type database table.
 * 
 */
@JacksonXmlRootElement(localName="launch_type")
public class LaunchTypeDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer launchTypeId;

	private String description;

	private String name;

	public LaunchTypeDAO() {
	}

	public Integer getLaunchTypeId() {
		return this.launchTypeId;
	}

	public void setLaunchTypeId(Integer launchTypeId) {
		this.launchTypeId = launchTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
