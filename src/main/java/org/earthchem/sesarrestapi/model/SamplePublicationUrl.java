package org.earthchem.sesarrestapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.earthchem.sesarrestapi.dao.SamplePublicationUrlDAO;


/**
 * The persistent class for the sample_publication_url database table.
 * 
 */
@Entity
@Table(name="sample_publication_url")
@NamedQuery(name="SamplePublicationUrl.findAll", query="SELECT s FROM SamplePublicationUrl s")
public class SamplePublicationUrl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sample_publication_url_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sesar_publication_url_seq")	
	@SequenceGenerator(name = "sesar_publication_url_seq", sequenceName = "sample_publication_url_sample_publication_url_id_seq",allocationSize=1)
	private Integer samplePublicationUrlId;

	private String description;

	private String url;

	@Column(name="url_type")
	private String urlType;

	//bi-directional many-to-one association to Sample
	@ManyToOne
	@JoinColumn(name="sample_id")
	private Sample sample;

	public SamplePublicationUrl() {
	}

	public Integer getSamplePublicationUrlId() {
		return this.samplePublicationUrlId;
	}

	public void setSamplePublicationUrlId(Integer samplePublicationUrlId) {
		this.samplePublicationUrlId = samplePublicationUrlId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlType() {
		return this.urlType;
	}

	public void setUrlType(String urlType) {
		this.urlType = urlType;
	}

	public Sample getSample() {
		return this.sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}

	public SamplePublicationUrlDAO getDAO()
	{
		SamplePublicationUrlDAO a = new SamplePublicationUrlDAO();
		a.setDescription(description);
		a.setUrl(url);
		a.setUrlType(urlType);
		
		return a;
	}
}