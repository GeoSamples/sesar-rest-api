package org.earthchem.sesarrestapi.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The presentation level class for the submissions database table.
 * 
 */
@JsonPropertyOrder({ "context", "id", "type", "userCode", "igsn", "name", "sampleType", "classificationType", "sameAs", "citation", "author", "description", "dateCreated","datePublished","keywords", "publisher", "spatialCoverage", "haspart" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SampleJSONLDDAO {

	@JsonProperty("@context")
	private HashMap<String, String> context;
	@JsonProperty("@type")
	private String type;
	private String name; //sample name
	private String userCode; //user code or igsn prefix
	private String igsn; //user code or igsn prefix
	private String sameAs; //ECL landing page URL
	/*
	 *  "author": [
        {
          "@type": "Role",
          "roleName": "Lead Author",
          "author":
          {
            "@type": "Person",
            "name": "Suzanne K Birner",
            "givenName": "Suzanne K ",
            "familyName": "Birner"   
          }
         },
         {
           "@type": "Role",
           "roleName": "Co Author",
           "author":
           {
             "@type": "Person",
             "name": "Jessica M Warren",
             "givenName": "Jessica M",
             "familyName": "Warren"   
            }
          },
          {
            "@type": "Role",
            "roleName": "Co Author",
            "author":
            {
              "@type": "Person",
              "name": "Elizabeth Cottrell",
              "givenName": "Elizabeth",
              "familyName": "Cottrell"   
            }
          }
        ]
	 */
	private ArrayList<Object> contributor;	
	private String description;
	/*
	 * "spatialCoverage": {
         "@type": "Place",
         "geo": [{
                   "@type": "GeoShape",
                   "box": "-173.27,-172.34 -20.38,-15.5",
                   "polygon": "-173.27,-172.34 -20.38,-15.5 -173.27,-172.34"
                 },
                 {
                    "@type": "GeoCoordinates",
                    "latitude": -20.38,
                    "longitude": -173.27
                 },
                 {
                    "@type": "GeoCoordinates",
                    "latitude": -19.25,
                    "longitude": -172.94
                 }]
       }
	 */
	private HashMap<String, Object> spatialCoverage;
	private String url;//landing page URL	
	/**
	 * "hasPart":{
         "@type": ["CreativeWork"],
         "identifier": [
            {
                "@type": "PropertyValue",
                "PropertyId":"IGSN Number",
                "URL": "http://igsn.org/DMO000002",
                "value":  "DMO000002"
            },
            {
                "@type": "PropertyValue",
                "PropertyId":"Cruise DOI",
                "URL": "https://dx.doi.org/10.7284/906699",
                "value":  "10.7284/906699"
            }]
        }
	 */
	@JsonProperty("hasPart")
	private HashMap<String, Object> identifier;	
	private String dateCreated;
	private String datePublished;

	/*
	"publisher": {
		   "@id": "https://www.earthchem.org",
		   "@type": "Organization",
		   "name": "EarthChem Library",
		   "url": "https://www.earthchem.org/library",
		   "contactPoint": {	
		     "@type": "ContactPoint",
		     "name": "Information Desk",
		     "email": "info@earthchem.org",
		     "url": "https://www.earthchem.org/contact/",
		     "contactType": "Customer Service"
		     }
		},
	*/
	private HashMap<String, Object> publisher;
	//private String keywords;
	private String sampleType;
	private String classificationType;
	

	@JsonProperty("@id")
	private String id;
		
	public SampleJSONLDDAO() {
	}

	public HashMap<String, String> getContext() {
		return this.context;
	}

	public void setContext(HashMap<String, String> t) {
		this.context = t;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String t) {
		this.type = t;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String t) {
		this.name = t;
	}

	public String getSameAs() {
		return this.sameAs;
	}

	public void setSameAs(String t) {
		this.sameAs = t;
	}
	
	public ArrayList<Object> getContributor() {
		return this.contributor;
	}

	public void setContributor(ArrayList<Object> t) {
		this.contributor = t;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String t) {
		this.description = t;
	}

	public HashMap<String, Object> getSpaticalCoverage() {
		return this.spatialCoverage;
	}

	public void setSpatialCoverage(HashMap<String, Object> t) {
		this.spatialCoverage = t;
	}
	
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String t) {
		this.url = t;
	}
	
	public HashMap<String, Object> getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(HashMap<String, Object> t) {
		this.identifier = t;
	}
	

	public String getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(String t) {
		this.dateCreated = t;
	}	

	public String getDatePublished() {
		return this.datePublished;
	}

	public void setDatePublished(String t) {
		this.datePublished = t;
	}
	
	public HashMap<String, Object> getPublisher() {
		return this.publisher;
	}

	public void setPublisher(HashMap<String, Object> t) {
		this.publisher = t;
	}	

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String t) {
		this.userCode = t;
	}

	public String getIGSN() {
		return this.igsn;
	}

	public void setIGSN(String t) {
		this.igsn = t;
	}

	public String getSampleType() {
		return this.sampleType;
	}

	public void setSampleType(String t) {
		this.sampleType = t;
	}
	

	public String getClassificationType() {
		return this.classificationType;
	}

	public void setClassificationType(String t) {
		this.classificationType = t;
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}	
}

