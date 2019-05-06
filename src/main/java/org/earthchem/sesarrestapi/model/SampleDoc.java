package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the sample_doc database table.
 * 
 */
@Entity
@Table(name="sample_doc")
@NamedQuery(name="SampleDoc.findAll", query="SELECT s FROM SampleDoc s")
public class SampleDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sample_doc_id")
	private Integer sampleDocId;

	@Column(name="file_name")
	private String fileName;

	@Column(name="path_to_file")
	private String pathToFile;

	@Column(name="primary_image")
	private Integer primaryImage;

	@Column(name="uploaded_date")
	private Time uploadedDate;

	//bi-directional many-to-one association to Sample
	@ManyToOne
	@JoinColumn(name="sample_id")
	private Sample sample;

	//bi-directional many-to-one association to SesarUser
	@ManyToOne
	@JoinColumn(name="uploaded_by")
	private SesarUser sesarUser;

	public SampleDoc() {
	}

	public Integer getSampleDocId() {
		return this.sampleDocId;
	}

	public void setSampleDocId(Integer sampleDocId) {
		this.sampleDocId = sampleDocId;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPathToFile() {
		return this.pathToFile;
	}

	public void setPathToFile(String pathToFile) {
		this.pathToFile = pathToFile;
	}

	public Integer getPrimaryImage() {
		return this.primaryImage;
	}

	public void setPrimaryImage(Integer primaryImage) {
		this.primaryImage = primaryImage;
	}

	public Time getUploadedDate() {
		return this.uploadedDate;
	}

	public void setUploadedDate(Time uploadedDate) {
		this.uploadedDate = uploadedDate;
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