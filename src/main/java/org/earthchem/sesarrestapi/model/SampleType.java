package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.earthchem.sesarrestapi.dao.SampleTypeDAO;


/**
 * The persistent class for the sample_type database table.
 * 
 */
@Entity
@Table(name="sample_type")
@NamedQuery(name="SampleType.findAll", query="SELECT s FROM SampleType s")
public class SampleType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sample_type_id")
	private Integer sampleTypeId;

	@Column(name="legacy_id")
	private Integer legacyId;

	@Column(name="legacy_parent_id")
	private Integer legacyParentId;

	private String name;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="sampleType1")
	private List<Sample> samples1;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="sampleType3")
	private List<Sample> samples3;

	//bi-directional many-to-one association to SampleType
	@ManyToOne
	@JoinColumn(name="parent_sample_type_id")
	private SampleType sampleType;

	//bi-directional many-to-one association to SampleType
	@OneToMany(mappedBy="sampleType")
	private List<SampleType> sampleTypes;

	public SampleType() {
	}

	public Integer getSampleTypeId() {
		return this.sampleTypeId;
	}

	public void setSampleTypeId(Integer sampleTypeId) {
		this.sampleTypeId = sampleTypeId;
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

	public List<Sample> getSamples1() {
		return this.samples1;
	}

	public void setSamples1(List<Sample> samples1) {
		this.samples1 = samples1;
	}

	public Sample addSamples1(Sample samples1) {
		getSamples1().add(samples1);
		samples1.setSampleType1(this);

		return samples1;
	}

	public Sample removeSamples1(Sample samples1) {
		getSamples1().remove(samples1);
		samples1.setSampleType1(null);

		return samples1;
	}

	public List<Sample> getSamples3() {
		return this.samples3;
	}

	public void setSamples3(List<Sample> samples3) {
		this.samples3 = samples3;
	}

	public Sample addSamples3(Sample samples3) {
		getSamples3().add(samples3);
		samples3.setSampleType3(this);

		return samples3;
	}

	public Sample removeSamples3(Sample samples3) {
		getSamples3().remove(samples3);
		samples3.setSampleType3(null);

		return samples3;
	}

	public SampleType getSampleType() {
		return this.sampleType;
	}

	public void setSampleType(SampleType sampleType) {
		this.sampleType = sampleType;
	}

	public List<SampleType> getSampleTypes() {
		return this.sampleTypes;
	}

	public void setSampleTypes(List<SampleType> sampleTypes) {
		this.sampleTypes = sampleTypes;
	}

	public SampleType addSampleType(SampleType sampleType) {
		getSampleTypes().add(sampleType);
		sampleType.setSampleType(this);

		return sampleType;
	}

	public SampleType removeSampleType(SampleType sampleType) {
		getSampleTypes().remove(sampleType);
		sampleType.setSampleType(null);

		return sampleType;
	}

	public SampleTypeDAO getDAO()
	{
		SampleTypeDAO a = new SampleTypeDAO();
		a.setSampleTypeId(this.sampleTypeId);
		a.setName(this.name);
		a.setLegacyId(this.legacyId);
		a.setLegacyParentId(this.legacyParentId);
		if(this.sampleType != null)
		  a.setParentSampleTypeId(this.sampleType.getSampleTypeId());
		return a;
	}
}