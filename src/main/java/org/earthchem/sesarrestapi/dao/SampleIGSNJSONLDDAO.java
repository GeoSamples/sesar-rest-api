package org.earthchem.sesarrestapi.dao;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The IGSN-ev JSON-LD Content for sample profile. See https://github.com/IGSN/igsn-json for more details.
 */
@JsonPropertyOrder({ "context", "id", "title", "type", "igsn", "registrant","log", "description"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SampleIGSNJSONLDDAO {

	@JsonProperty("@context")
	private String context;
	private String igsn;
	@JsonProperty("@id")
	private String id;
	private HashMap<String,Object> registrant;
	
	private SampleDescription description;
	
	@JsonProperty("event")
	private HashMap<String,Object> log;
	
	public SampleIGSNJSONLDDAO() {
		context= "https://raw.githubusercontent.com/IGSN/igsn-json/master/schema.igsn.org/json/registration/v0.1/context.jsonld";	    
	}

	public String getContext() {
		return this.context;
	}

	public void setContext(String t) {
		this.context = t;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getIgsn() {
		return this.igsn;
	}
	public void setIgsn(String t) {
		this.igsn = t;
	}	
	
	public HashMap<String, Object> getRegistrant() {
			return this.registrant;
	}

	public void setRegistrant(HashMap<String, Object> t) {
			this.registrant = t;
	}
	
	public SampleDescription getDescription() {
	        return this.description;
	}
	
	public void setDescription(SampleDescription sd) {
	       this.description = sd;
	}

	public HashMap<String, Object> getLog() {
			return this.log;
	}

	public void setLog(HashMap<String, Object> t) {
			this.log = t;
	}
}

