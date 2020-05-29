package org.earthchem.sesarrestapi.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({  "type", "propertyId", "url", "value" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Identifier {

    @JsonProperty("@type")
    private	String type;// "type",
    String propertyId;  //
    String url;         //external publication URL 
    String value;       // description of the URL
    
   public Identifier(String propertyid_in, String url_in, String value_in)
   {
    	type = "PropertyValue";
    	propertyId = propertyid_in;
    	url = url_in;
    	value = value_in;
   }	
   public String getType() {
		  return type;
   }
   public void setType(String t) {
		  type = t;
   }
   public String getPropertyId() {
		  return propertyId;
   }
   public void setPropertyId(String t) {
	   propertyId = t;
   }
   public String getUrl() {
	  return url;
   }
   public void setUrl(String t) {
	  url = t;
   }
   public String getValue() {
	  return value;
   }
   public void setValue(String t) {
	  value = t;
   }
}
