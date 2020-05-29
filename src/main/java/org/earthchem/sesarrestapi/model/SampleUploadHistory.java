package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import java.sql.Timestamp;

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


/**
 * The persistent class for the sample_upload_history database table.
 * 
 */
@Entity
@Table(name="sample_upload_history")
@NamedQuery(name="SampleUploadHistory.findAll", query="SELECT s FROM SampleUploadHistory s")
public class SampleUploadHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sample_upload_history_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sesar_upload_history_seq")	
	@SequenceGenerator(name = "sesar_upload_history_seq", sequenceName = "sample_upload_history_sample_upload_history_id_seq",allocationSize=1)
	private Integer sampleUploadHistoryId;

	@Column(name="upload_from")
	private String uploadFrom;

	@Column(name="upload_time")
	private Timestamp uploadTime;

	//bi-directional many-to-one association to Sample
	@ManyToOne
	@JoinColumn(name="sample_id")
	private Sample sample;

	//bi-directional many-to-one association to SesarUser
	@ManyToOne
	@JoinColumn(name="upload_by")
	private SesarUser sesarUser;

	public SampleUploadHistory() {
	}

	public Integer getSampleUploadHistoryId() {
		return this.sampleUploadHistoryId;
	}

	public void setSampleUploadHistoryId(Integer sampleUploadHistoryId) {
		this.sampleUploadHistoryId = sampleUploadHistoryId;
	}

	public String getUploadFrom() {
		return this.uploadFrom;
	}

	public void setUploadFrom(String uploadFrom) {
		this.uploadFrom = uploadFrom;
	}

	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Sample getSample() {
		return this.sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}

	public SesarUser getSesarUser() {
		return this.sesarUser;
	}

	public void setSesarUser(SesarUser sesarUser) {
		this.sesarUser = sesarUser;
	}

}