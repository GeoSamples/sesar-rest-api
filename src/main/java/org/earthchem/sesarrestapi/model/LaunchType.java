package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the launch_type database table.
 * 
 */
@Entity
@Table(name="launch_type")
@NamedQuery(name="LaunchType.findAll", query="SELECT l FROM LaunchType l")
public class LaunchType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="launch_type_id")
	private Long launchTypeId;

	private String description;

	private String name;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="launchType")
	private List<Sample> samples;

	public LaunchType() {
	}

	public Long getLaunchTypeId() {
		return this.launchTypeId;
	}

	public void setLaunchTypeId(Long launchTypeId) {
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

	public List<Sample> getSamples() {
		return this.samples;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}

	public Sample addSample(Sample sample) {
		getSamples().add(sample);
		sample.setLaunchType(this);

		return sample;
	}

	public Sample removeSample(Sample sample) {
		getSamples().remove(sample);
		sample.setLaunchType(null);

		return sample;
	}

}