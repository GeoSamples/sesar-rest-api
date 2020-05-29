package org.earthchem.sesarrestapi.dao;
import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * The presentation class for the sample_publication_url database table. 
 */
@JacksonXmlRootElement(localName="sample_publication_url")
public class SamplePublicationUrlDAO  implements Serializable {
	private static final long serialVersionUID = 1L;
	 
	private String description;

	private String url;

	private String urlType;

	public SamplePublicationUrlDAO() {
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

}