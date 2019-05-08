package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nav_type database table.
 * 
 */
@Entity
@Table(name="nav_type")
@NamedQuery(name="NavType.findAll", query="SELECT n FROM NavType n")
public class NavType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nav_type_id")
	private Long navTypeId;

	private String description;

	private String name;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="navType")
	private List<Sample> samples;

	public NavType() {
	}

	public Long getNavTypeId() {
		return this.navTypeId;
	}

	public void setNavTypeId(Long navTypeId) {
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

	public List<Sample> getSamples() {
		return this.samples;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}

	public Sample addSample(Sample sample) {
		getSamples().add(sample);
		sample.setNavType(this);

		return sample;
	}

	public Sample removeSample(Sample sample) {
		getSamples().remove(sample);
		sample.setNavType(null);

		return sample;
	}

}