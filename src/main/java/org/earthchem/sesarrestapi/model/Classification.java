package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.earthchem.sesarrestapi.dao.ClassificationDAO;


/**
 * The persistent class for the classification database table.
 * 
 */
@Entity
@NamedQuery(name="Classification.findAll", query="SELECT c FROM Classification c")
public class Classification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="classification_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="classification_seq")
	@SequenceGenerator(name = "classification_seq", sequenceName = "classification_classification_id_seq",allocationSize=1)
	private Integer classificationId;

	private String description;

	@Column(name="legacy_id")
	private Integer legacyId;

	@Column(name="legacy_parent_id")
	private Integer legacyParentId;

	private String name;

	//bi-directional many-to-one association to Classification
	@ManyToOne
	@JoinColumn(name="parent_classification_id")
	private Classification classification;

	//bi-directional many-to-one association to Classification
	@OneToMany(mappedBy="classification")
	private List<Classification> classifications;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="classification1")
	private List<Sample> samples1;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="classification2")
	private List<Sample> samples2;

	public Classification() {
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

	public Classification getClassification() {
		return this.classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	public List<Classification> getClassifications() {
		return this.classifications;
	}

	public void setClassifications(List<Classification> classifications) {
		this.classifications = classifications;
	}

	public Classification addClassification(Classification classification) {
		getClassifications().add(classification);
		classification.setClassification(this);

		return classification;
	}

	public Classification removeClassification(Classification classification) {
		getClassifications().remove(classification);
		classification.setClassification(null);

		return classification;
	}

	public List<Sample> getSamples1() {
		return this.samples1;
	}

	public void setSamples1(List<Sample> samples1) {
		this.samples1 = samples1;
	}

	public Sample addSamples1(Sample samples1) {
		getSamples1().add(samples1);
		samples1.setClassification1(this);

		return samples1;
	}

	public Sample removeSamples1(Sample samples1) {
		getSamples1().remove(samples1);
		samples1.setClassification1(null);

		return samples1;
	}

	public List<Sample> getSamples2() {
		return this.samples2;
	}

	public void setSamples2(List<Sample> samples2) {
		this.samples2 = samples2;
	}

	public Sample addSamples2(Sample samples2) {
		getSamples2().add(samples2);
		samples2.setClassification2(this);

		return samples2;
	}

	public Sample removeSamples2(Sample samples2) {
		getSamples2().remove(samples2);
		samples2.setClassification2(null);

		return samples2;
	}
    
	public ClassificationDAO getDAO()
	{
		ClassificationDAO d = new ClassificationDAO();
		d.setClassificationId(this.classificationId);
		d.setDescription(this.description);
		d.setName(this.name);
		if(this.classification != null)
		  d.setParentClassificationId(this.classification.getClassificationId());
		
		return d;
	}
}