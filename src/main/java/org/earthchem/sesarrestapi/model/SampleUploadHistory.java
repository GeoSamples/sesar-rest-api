package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


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