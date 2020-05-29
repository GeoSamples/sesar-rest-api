package org.earthchem.sesarrestapi.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//https://schema.org/Person
@JsonPropertyOrder({  "type", "name", "givenName", "familyName", "sameAs" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Author {
	
	  @JsonProperty("@type")
	  private String type;       //Person
	  private String name;       //full name
      private String givenName;  //first name and middle name
	  private String familyName; //last name
	  
	  //"sameAs": "http://orcid.org/0000-0000-0000-0000",
      private String sameAs;     //ORCID URL if exists
      
	  public Author(String t, String n, String g, String f )
	  {
		  type = t;
		  name = n;
		  givenName = g;
		  familyName = f;
	  }
	  public String getType() {
		  return type;
	  }
	  public void setType(String t) {
		  type = t;
	  }
	  public String getName() {
		  return name;
	  }
	  public void setName(String t) {
		  name = t;
	  }
	  public String getGivenName() {
		  return givenName;
	  }
	  public void setGivenName(String t) {
		  givenName = t;
	  }
	  public String getFamilyName() {
		  return familyName;
	  }
	  public void setFamilyName(String t) {
		  familyName = t;
	  }
	  public String getSameAs() {
		  return sameAs;
	  }
	  public void setSameAs(String t) {
		  sameAs = t;
	  }
}//end of Author class