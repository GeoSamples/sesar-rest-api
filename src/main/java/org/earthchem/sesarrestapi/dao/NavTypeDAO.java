package org.earthchem.sesarrestapi.dao;

public class NavTypeDAO {

	private Integer navTypeId;

	private String description;

	private String name;

	public NavTypeDAO() {
	}

	public Integer getNavTypeId() {
		return this.navTypeId;
	}

	public void setNavTypeId(Integer navTypeId) {
		this.navTypeId = navTypeId;
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
