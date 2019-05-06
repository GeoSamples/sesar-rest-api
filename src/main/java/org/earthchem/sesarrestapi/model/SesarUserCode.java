package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sesar_user_code database table.
 * 
 */
@Entity
@Table(name="sesar_user_code")
@NamedQuery(name="SesarUserCode.findAll", query="SELECT s FROM SesarUserCode s")
public class SesarUserCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="igsn_count")
	private Long igsnCount;

	@Column(name="is_available")
	private Integer isAvailable;

	@Column(name="is_grandfather_code")
	private Boolean isGrandfatherCode;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="sesarUserCode")
	private List<Sample> samples;

	//bi-directional many-to-one association to SesarUser
	@ManyToOne
	@JoinColumn(name="sesar_user_id")
	private SesarUser sesarUser;

	public SesarUserCode() {
	}

	public Long getIgsnCount() {
		return this.igsnCount;
	}

	public void setIgsnCount(Long igsnCount) {
		this.igsnCount = igsnCount;
	}

	public Integer getIsAvailable() {
		return this.isAvailable;
	}

	public void setIsAvailable(Integer isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Boolean getIsGrandfatherCode() {
		return this.isGrandfatherCode;
	}

	public void setIsGrandfatherCode(Boolean isGrandfatherCode) {
		this.isGrandfatherCode = isGrandfatherCode;
	}

	public List<Sample> getSamples() {
		return this.samples;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}

	public Sample addSample(Sample sample) {
		getSamples().add(sample);
		sample.setSesarUserCode(this);

		return sample;
	}

	public Sample removeSample(Sample sample) {
		getSamples().remove(sample);
		sample.setSesarUserCode(null);

		return sample;
	}

	public SesarUser getSesarUser() {
		return this.sesarUser;
	}

	public void setSesarUser(SesarUser sesarUser) {
		this.sesarUser = sesarUser;
	}

}