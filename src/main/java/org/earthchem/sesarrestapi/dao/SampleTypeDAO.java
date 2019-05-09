package org.earthchem.sesarrestapi.dao;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the sample_type database table.
 * 
 */
public class SampleTypeDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sample_type_id")
	private Integer SampleTypeId;

	@Column(name="legacy_id")
	private Integer legacyId;

	@Column(name="legacy_parent_id")
	private Integer legacyParentId;

	private String name;

	@Column(name="parent_sample_type_id")
	private Integer parent_sample_type_id;

	public SampleTypeDAO() {
	}

	public Integer getSampleTypeId() {
		return this.SampleTypeId;
	}

	public void setSampleTypeId(Integer SampleTypeId) {
		this.SampleTypeId = SampleTypeId;
	}

	public Integer getLegacyId() {
		return this.legacyId;
	}

	public void setLegacyId(Integer legacyId) {
		this.legacyId = legacyId;
	}

	public Integer getLegacyParentId() {
		return this.legacyParentId;
	}

	public void setLegacyParentId(Integer legacyParentId) {
		this.legacyParentId = legacyParentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Integer getParentSampleTypeId() {
		return this.parent_sample_type_id;
	}

	public void setParentSampleTypeId(Integer pid) {
		this.parent_sample_type_id = pid;
	}

}