package org.earthchem.sesarrestapi.dao;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The data access class for the classification database table.
 * 
 */
public class ClassificationDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="classification_id")
	private Integer classificationId;

	private String description;

	private String name;
	
	@Column(name="parent_classification_id")
	private Integer parentClassificationId;

	public ClassificationDAO() {
	}

	public Integer getClassificationId() {
		return this.classificationId;
	}

	public void setClassificationId(Integer classificationId) {
		this.classificationId = classificationId;
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

	public Integer getParentClassificationId() {
		return this.parentClassificationId;
	}

	public void setParentClassificationId(Integer id) {
		this.parentClassificationId = id;
	}

}