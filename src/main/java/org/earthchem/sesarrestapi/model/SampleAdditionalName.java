package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sample_additional_name database table.
 * 
 */
@Entity
@Table(name="sample_additional_name")
@NamedQuery(name="SampleAdditionalName.findAll", query="SELECT s FROM SampleAdditionalName s")
public class SampleAdditionalName implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sample_additional_name_id")
	private Integer sampleAdditionalNameId;

	private String name;

	//bi-directional many-to-one association to Sample
	@ManyToOne
	@JoinColumn(name="sample_id")
	private Sample sample;

	public SampleAdditionalName() {
	}

	public Integer getSampleAdditionalNameId() {
		return this.sampleAdditionalNameId;
	}

	public void setSampleAdditionalNameId(Integer sampleAdditionalNameId) {
		this.sampleAdditionalNameId = sampleAdditionalNameId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sample getSample() {
		return this.sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}

}