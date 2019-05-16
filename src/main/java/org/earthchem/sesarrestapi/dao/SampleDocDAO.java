package org.earthchem.sesarrestapi.dao;

import java.io.Serializable;

/**
 * The presentation class for the sample_doc database table.
 * 
 */
public class SampleDocDAO  implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fileName;

	//url to the file
	private String urlToFile;

	private Integer primaryImage;

	public SampleDocDAO() {
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUrlToFile() {
		return this.urlToFile;
	}

	public void setUrlToFile(String pathToFile) {
		this.urlToFile = pathToFile;
	}

	public Integer getPrimaryImage() {
		return this.primaryImage;
	}

	public void setPrimaryImage(Integer primaryImage) {
		this.primaryImage = primaryImage;
	}
}