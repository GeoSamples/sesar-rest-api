package org.earthchem.sesarrestapi.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

/**
 * The IGSN-ev JSON-LD Sample Description Block Content for sample profile.
 */
@JsonPropertyOrder({ "context", "sampleName", "sampleType", "collector", "collectionStartDate", "contributors","geoLocation","material","collectionMethod","collectionTime", "description","supplementMetadata","log"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SampleDescription {

		private Integer sampleId;

		private String classificationComment;

		private String collectionDatePrecision;

		private String collectionEndDate;

		private String collectionMethod;

		private String collectionMethodDescr;

		private String collectionStartDate;

		private String collector;

		private String collectorDetail;

		private String currentArchive;

		private String currentArchiveContact;

		private String description;

		@JsonProperty("geoLocation")
		private HashMap<String, Object> geolocation;
        
		@JsonProperty("sampleName")
		private String name;

		private String northing;

		private ArrayList<Object> contributors;
		
	//	private String originalArchive;

	//	private String originalArchiveContact;

		private String sampleComment;

		//parent classification
		private String material;

		@JsonProperty("parentIdentifier")
		private String parentIGSN;

		private String sampleType;
		
		//Included into sampleType
		//private String sampleSubType;
		@JsonProperty("igsnPrefix")
		private String sesarUserCode;

		//List of image names
		//private List<SampleDocDAO> document=null;
	 
		//private List<SamplePublicationUrlDAO> publicationUrl=null;

		private HashMap<String, Object> publisher;

		@JsonProperty("supplementMetadata")
		private SampleSupplementData supplementdata;
		
		private ArrayList<Object> log;
		
		public SampleDescription() {
		}

		public Integer getSampleId() {
			return this.sampleId;
		}

		public void setSampleId(Integer sampleId) {
			this.sampleId = sampleId;
		}

		public String getParentIGSN() {
			return this.parentIGSN;
		}

		public void setParentIGSN(String pi) {
			this.parentIGSN = pi;
		}

		public String getClassificationComment() {
			return this.classificationComment;
		}

		public void setClassificationComment(String classificationComment) {
			this.classificationComment = classificationComment;
		}

		public String getCollectionDatePrecision() {
			return this.collectionDatePrecision;
		}

		public void setCollectionDatePrecision(String collectionDatePrecision) {
			this.collectionDatePrecision = collectionDatePrecision;
		}

		public String getCollectionEndDate() {
			return this.collectionEndDate;
		}

		public void setCollectionEndDate(String collectionEndDate) {
			this.collectionEndDate = collectionEndDate;
		}

		public String getCollectionMethod() {
			return this.collectionMethod;
		}

		public void setCollectionMethod(String collectionMethod) {
			this.collectionMethod = collectionMethod;
		}

		public String getCollectionMethodDescr() {
			return this.collectionMethodDescr;
		}

		public void setCollectionMethodDescr(String collectionMethodDescr) {
			this.collectionMethodDescr = collectionMethodDescr;
		}

		public String getCollectionStartDate() {
			return this.collectionStartDate;
		}

		public void setCollectionStartDate(String collectionStartDate) {
			this.collectionStartDate = collectionStartDate;
		}

		public String getCollector() {
			return this.collector;
		}

		public void setCollector(String collector) {
			this.collector = collector;
		}

		public String getCollectorDetail() {
			return this.collectorDetail;
		}

		public void setCollectorDetail(String collectorDetail) {
			this.collectorDetail = collectorDetail;
		}

		public String getCurrentArchive() {
			return this.currentArchive;
		}

		public void setCurrentArchive(String currentArchive) {
			this.currentArchive = currentArchive;
		}

		public String getCurrentArchiveContact() {
			return this.currentArchiveContact;
		}

		public void setCurrentArchiveContact(String currentArchiveContact) {
			this.currentArchiveContact = currentArchiveContact;
		}

		public String getDescription() {
			return this.description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

        public HashMap<String, Object> getGeolocation() {
        	return this.geolocation;
        }
		
        public void setGeolocation(HashMap<String, Object> t) {
        	this.geolocation = t;
        }

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNorthing() {
			return this.northing;
		}

		public void setNorthing(String northing) {
			this.northing = northing;
		}

    	public ArrayList<Object> getContributors() {
			return this.contributors;
		}
		
		public void setContributors(ArrayList<Object> t) {
			this.contributors=t;
		}

		public String getSampleComment() {
			return this.sampleComment;
		}

		public void setSampleComment(String sampleComment) {
			this.sampleComment = sampleComment;
		}

		public String getMaterial() {
			return this.material;
		}

		public void setMaterial(String m) {
			this.material = m;
		}
				
		public String getSampleType() {
			return this.sampleType;
		}

		public void setSampleType(String sampleType) {
			this.sampleType = sampleType;
		}
				
		//public String getSampleSubType() {
		//	return this.sampleSubType;
		//}

		//public void setSampleSubType(String sampleSubType) {
		//	this.sampleSubType = sampleSubType;
		//}

		public String getSesarUserCode() {
			return this.sesarUserCode;
		}

		public void setSesarUserCode(String sesarUserCode) {
			this.sesarUserCode = sesarUserCode;
		}
		


		public ArrayList<Object> getLog() {
				return this.log;
		}

		public void setLog(ArrayList<Object> t) {
				this.log = t;
		}

		public HashMap<String, Object> getPublisher() {
			return this.publisher;
		}
		
		public void setPublisher( HashMap<String, Object> t) {
			this.publisher = t;
		}
		
		public SampleSupplementData getSupplementdata () {
			return this.supplementdata;
		}
		public void setSupplementdata( SampleSupplementData t) {
			this.supplementdata = t;
		}
	}