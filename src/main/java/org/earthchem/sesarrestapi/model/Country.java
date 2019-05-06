package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="country_id")
	private Integer countryId;

	@Column(name="is_active")
	private Integer isActive;

	private String name;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="country")
	private List<Sample> samples;

	//bi-directional many-to-one association to SesarUser
	@OneToMany(mappedBy="country")
	private List<SesarUser> sesarUsers;

	public Country() {
	}

	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
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
		sample.setCountry(this);

		return sample;
	}

	public Sample removeSample(Sample sample) {
		getSamples().remove(sample);
		sample.setCountry(null);

		return sample;
	}

	public List<SesarUser> getSesarUsers() {
		return this.sesarUsers;
	}

	public void setSesarUsers(List<SesarUser> sesarUsers) {
		this.sesarUsers = sesarUsers;
	}

	public SesarUser addSesarUser(SesarUser sesarUser) {
		getSesarUsers().add(sesarUser);
		sesarUser.setCountry(this);

		return sesarUser;
	}

	public SesarUser removeSesarUser(SesarUser sesarUser) {
		getSesarUsers().remove(sesarUser);
		sesarUser.setCountry(null);

		return sesarUser;
	}

}