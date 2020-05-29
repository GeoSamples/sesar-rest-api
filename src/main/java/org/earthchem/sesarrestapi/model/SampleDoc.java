package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import java.sql.Time;
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

import org.earthchem.sesarrestapi.dao.SampleDocDAO;

import ch.qos.logback.core.joran.action.TimestampAction;


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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sesar_doc_seq")	
	@SequenceGenerator(name = "sesar_doc_seq", sequenceName = "sample_doc_sample_doc_id_seq",allocationSize=1)
	private Integer sampleDocId;

	@Column(name="file_name")
	private String fileName;

	@Column(name="path_to_file")
	private String pathToFile;

	@Column(name="primary_image")
	private Integer primaryImage;

	@Column(name="uploaded_date")
	private Timestamp uploadedDate;

	//bi-directional many-to-one association to Sample
	@ManyToOne
	@JoinColumn(name="sample_id")
	private Sample sample;

	//bi-directional many-to-one association to SesarUser
	@ManyToOne
	@JoinColumn(name="uploaded_by")
	private SesarUser sesarUser;

	@Column(name="file_size")
	private Long fileSize;
	
	@Column(name="file_type")
	private String fileType;
	
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

	public Timestamp getUploadedDate() {
		return this.uploadedDate;
	}

	public void setUploadedDate(Timestamp uploadedDate) {
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
    
	public SampleDocDAO getDAO()
	{
		SampleDocDAO a = new SampleDocDAO();
		a.setFileName(fileName);
		String[] dirl = pathToFile.split("/");
		int l = dirl.length;
		String str="";
		boolean f=false;
		for(int i=0; i<l; i++)
		{
			if(dirl[i].equalsIgnoreCase("uploads"))
			{
				f=true;
			}
			if(f == true)
				str +="/"+dirl[i];
		}
		//FIXME: Domain URL needs to be configurable
		a.setUrlToFile("https://app.geosamples.org"+str);		
		a.setPrimaryImage(primaryImage);
		return a;
	}
	

	public Long getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(Long s) {
		this.fileSize = s;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String s) {
		this.fileType = s;
	}
}