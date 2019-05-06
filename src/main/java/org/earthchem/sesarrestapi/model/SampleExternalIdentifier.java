package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sample_external_identifier database table.
 * 
 */
@Entity
@Table(name="sample_external_identifier")
@NamedQuery(name="SampleExternalIdentifier.findAll", query="SELECT s FROM SampleExternalIdentifier s")
public class SampleExternalIdentifier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sample_external_identifier_id")
	private Integer sampleExternalIdentifierId;

	@Column(name="identifier_value")
	private String identifierValue;

	@Column(name="sample_column_external_identifier_system_id")
	private Integer sampleColumnExternalIdentifierSystemId;

	@Column(name="sample_id")
	private Integer sampleId;

	public SampleExternalIdentifier() {
	}

	public Integer getSampleExternalIdentifierId() {
		return this.sampleExternalIdentifierId;
	}

	public void setSampleExternalIdentifierId(Integer sampleExternalIdentifierId) {
		this.sampleExternalIdentifierId = sampleExternalIdentifierId;
	}

	public String getIdentifierValue() {
		return this.identifierValue;
	}

	public void setIdentifierValue(String identifierValue) {
		this.identifierValue = identifierValue;
	}

	public Integer getSampleColumnExternalIdentifierSystemId() {
		return this.sampleColumnExternalIdentifierSystemId;
	}

	public void setSampleColumnExternalIdentifierSystemId(Integer sampleColumnExternalIdentifierSystemId) {
		this.sampleColumnExternalIdentifierSystemId = sampleColumnExternalIdentifierSystemId;
	}

	public Integer getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(Integer sampleId) {
		this.sampleId = sampleId;
	}

}