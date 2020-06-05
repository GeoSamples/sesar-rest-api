package org.earthchem.sesarrestapi.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

/**
 * The IGSN-ev JSON-LD Sample Description Supplement Metadata.
 */
@JsonPropertyOrder({ "context", "id", "title", "type", "igsn", "registrant","log", "description"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SampleSupplementData {

		private Integer sampleId;

		private Double ageMax;

		private Double ageMin;

		private String ageUnit;

		private String city;

		private String classificationComment;

		//private String collectionDatePrecision;

		//private String collectionEndDate;

		//private String collectionMethod;

		//private String collectionMethodDescr;

		//private String collectionStartDate;

		//private String collector;

		//private String collectorDetail;

		private String county;

		private String cruiseFieldPrgrm;

		private String currentArchive;

		private String currentArchiveContact;

		private Double depthMax;

		private Double depthMin;

		private String depthScale;

		private String description;

		private String easting;

		private Double elevation;

		private Double elevationEnd;

		private String elevationUnit;

		private String externalParentName;

		private String externalSampleId;

		private String fieldName;

		private String geologicalAge;

		private String geologicalUnit;
		
		private String igsn;

		private String launchId;

		private String launchPlatformName;

		private String locality;

		private String localityDescription;

		private String locationDescription;

		private String northing;

		private ArrayList<Object> contributors;
		
		private String originalArchive;

	//	private String originalArchiveContact;

		private String platformDescr;

		private String platformName;

		private String platformType;

		//physiographic feature name
		private String primaryLocationName;

		private String primaryLocationType;

		private String province;

		private String purpose;

		private String sampleComment;

		private Integer sampleUnit;

		private String size;

		private String sizeUnit;

		private String verticalDatum;

		private String zone;

		private String classification;

		private String country;

		private String launchTypeName;

		private String navigationType;

		private String parentIGSN;

		private List<String> childIGSN=null;

		private List<String> siblingIGSN=null;
		
		private Integer externalParentSampleTypeId;

		private String sampleType;
		
		private String sampleSubType;

		private String sesarUserCode;
		
		private String status;

		private List<String> otherName=null;

		//List of image names
		private List<SampleDocDAO> document=null;
	 
		private List<SamplePublicationUrlDAO> publicationUrl=null;

		private HashMap<String, Object> publisher;

		private ArrayList<Object> log;
		
		public SampleSupplementData(){
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

	    public Integer getExternalParentSampleTypeId() {
			return this.externalParentSampleTypeId;
		}

		public void setExternalParentSampleTypeId(Integer sampleId) {
			this.externalParentSampleTypeId = sampleId;
		}
		
		public Double getAgeMax() {
			return this.ageMax;
		}

		public void setAgeMax(Double ageMax) {
			this.ageMax = ageMax;
		}

		public Double getAgeMin() {
			return this.ageMin;
		}

		public void setAgeMin(Double ageMin) {
			this.ageMin = ageMin;
		}

		public String getAgeUnit() {
			return this.ageUnit;
		}

		public void setAgeUnit(String ageUnit) {
			this.ageUnit = ageUnit;
		}

		public String getCity() {
			return this.city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getClassificationComment() {
			return this.classificationComment;
		}

		public void setClassificationComment(String classificationComment) {
			this.classificationComment = classificationComment;
		}

		public String getCounty() {
			return this.county;
		}

		public void setCounty(String county) {
			this.county = county;
		}

		public String getCruiseFieldPrgrm() {
			return this.cruiseFieldPrgrm;
		}

		public void setCruiseFieldPrgrm(String cruiseFieldPrgrm) {
			this.cruiseFieldPrgrm = cruiseFieldPrgrm;
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

		public Double getDepthMax() {
			return this.depthMax;
		}

		public void setDepthMax(Double depthMax) {
			this.depthMax = depthMax;
		}

		public Double getDepthMin() {
			return this.depthMin;
		}

		public void setDepthMin(Double depthMin) {
			this.depthMin = depthMin;
		}

		public String getDepthScale() {
			return this.depthScale;
		}

		public void setDepthScale(String depthScale) {
			this.depthScale = depthScale;
		}

		public String getDescription() {
			return this.description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getEasting() {
			return this.easting;
		}

		public void setEasting(String easting) {
			this.easting = easting;
		}

		public Double getElevation() {
			return this.elevation;
		}

		public void setElevation(Double elevation) {
			this.elevation = elevation;
		}

		public Double getElevationEnd() {
			return this.elevationEnd;
		}

		public void setElevationEnd(Double elevationEnd) {
			this.elevationEnd = elevationEnd;
		}

		public String getElevationUnit() {
			return this.elevationUnit;
		}

		public void setElevationUnit(String elevationUnit) {
			this.elevationUnit = elevationUnit;
		}

		public String getExternalParentName() {
			return this.externalParentName;
		}

		public void setExternalParentName(String externalParentName) {
			this.externalParentName = externalParentName;
		}

		public String getExternalSampleId() {
			return this.externalSampleId;
		}

		public void setExternalSampleId(String externalSampleId) {
			this.externalSampleId = externalSampleId;
		}

		public String getFieldName() {
			return this.fieldName;
		}

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getGeologicalAge() {
			return this.geologicalAge;
		}

		public void setGeologicalAge(String geologicalAge) {
			this.geologicalAge = geologicalAge;
		}

		public String getGeologicalUnit() {
			return this.geologicalUnit;
		}

		public void setGeologicalUnit(String geologicalUnit) {
			this.geologicalUnit = geologicalUnit;
		}

		public String getIgsn() {
			return this.igsn;
		}

		public void setIgsn(String igsn) {
			this.igsn = igsn;
		}

		public String getLaunchId() {
			return this.launchId;
		}

		public void setLaunchId(String launchId) {
			this.launchId = launchId;
		}

		public String getLaunchPlatformName() {
			return this.launchPlatformName;
		}

		public void setLaunchPlatformName(String launchPlatformName) {
			this.launchPlatformName = launchPlatformName;
		}

		public String getLocality() {
			return this.locality;
		}

		public void setLocality(String locality) {
			this.locality = locality;
		}

		public String getLocalityDescription() {
			return this.localityDescription;
		}

		public void setLocalityDescription(String localityDescription) {
			this.localityDescription = localityDescription;
		}

		public String getLocationDescription() {
			return this.locationDescription;
		}

		public void setLocationDescription(String locationDescription) {
			this.locationDescription = locationDescription;
		}

		public String getNorthing() {
			return this.northing;
		}

		public void setNorthing(String northing) {
			this.northing = northing;
		}

		public String getOriginalArchive() {
			return this.originalArchive;
		}

		public void setOriginalArchive(String originalArchive) {
			this.originalArchive = originalArchive;
		}

    	public ArrayList<Object> getContributors() {
			return this.contributors;
		}
		
		public void setContributors(ArrayList<Object> t) {
			this.contributors=t;
		}
		
		public String getPlatformDescr() {
			return this.platformDescr;
		}

		public void setPlatformDescr(String platformDescr) {
			this.platformDescr = platformDescr;
		}

		public String getPlatformName() {
			return this.platformName;
		}

		public void setPlatformName(String platformName) {
			this.platformName = platformName;
		}

		public String getPlatformType() {
			return this.platformType;
		}

		public void setPlatformType(String platformType) {
			this.platformType = platformType;
		}

		public String getPrimaryLocationName() {
			return this.primaryLocationName;
		}

		public void setPrimaryLocationName(String primaryLocationName) {
			this.primaryLocationName = primaryLocationName;
		}

		public String getPrimaryLocationType() {
			return this.primaryLocationType;
		}

		public void setPrimaryLocationType(String primaryLocationType) {
			this.primaryLocationType = primaryLocationType;
		}

		public String getProvince() {
			return this.province;
		}

		public void setProvince(String province) {
			this.province = province;
		}


		public String getPurpose() {
			return this.purpose;
		}

		public void setPurpose(String purpose) {
			this.purpose = purpose;
		}

		public String getSampleComment() {
			return this.sampleComment;
		}

		public void setSampleComment(String sampleComment) {
			this.sampleComment = sampleComment;
		}

		public Integer getSampleUnit() {
			return this.sampleUnit;
		}

		public void setSampleUnit(Integer sampleUnit) {
			this.sampleUnit = sampleUnit;
		}

		public String getSize() {
			return this.size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getSizeUnit() {
			return this.sizeUnit;
		}

		public void setSizeUnit(String sizeUnit) {
			this.sizeUnit = sizeUnit;
		}

		public String getVerticalDatum() {
			return this.verticalDatum;
		}

		public void setVerticalDatum(String verticalDatum) {
			this.verticalDatum = verticalDatum;
		}

		public String getZone() {
			return this.zone;
		}

		public void setZone(String zone) {
			this.zone = zone;
		}

		public String getClassification() {
			return this.classification;
		}

		public void setClassification(String m) {
			this.classification = m;
		}
		
		public String getCountry() {
			return this.country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getLaunchTypeName() {
			return this.launchTypeName;
		}

		public void setLaunchTypeName(String launchType) {
			this.launchTypeName = launchType;
		}

		public String getNavigationType() {
			return this.navigationType;
		}

		public void setNavigationType(String navType) {
			this.navigationType = navType;
		}
		
		@JacksonXmlElementWrapper(localName = "children")
		public List<String> getChildIGSN() {
			return this.childIGSN;
		}

		public void setChildIGSN(List<String> s) {
			this.childIGSN = s;
		}
		
		@JacksonXmlElementWrapper(localName = "siblings")
		public List<String> getSiblingIGSN() {
			return this.siblingIGSN;
		}

		public void setSiblingIGSN(List<String> s) {
			this.siblingIGSN = s;
		}
				
		public String getSampleType() {
			return this.sampleType;
		}

		public void setSampleType(String sampleType) {
			this.sampleType = sampleType;
		}
				
		public String getSampleSubType() {
			return this.sampleSubType;
		}

		public void setSampleSubType(String sampleSubType) {
			this.sampleSubType = sampleSubType;
		}

		public String getSesarUserCode() {
			return this.sesarUserCode;
		}

		public void setSesarUserCode(String sesarUserCode) {
			this.sesarUserCode = sesarUserCode;
		}

		public String getStatus() {
			return this.status;
		}

		public void setStatus(String s) {
			this.status = s;
		}

		@JacksonXmlElementWrapper(localName = "otherNames")
		public List<String> getOtherName() {
			return this.otherName;
		}

		public void setOtherName(List<String> sampleOtherName) {
			this.otherName = sampleOtherName;
		}
		
		@JacksonXmlElementWrapper(localName = "documents")
		public List<SampleDocDAO> getDocument() {
			return this.document;
		}

		public void setDocument(List<SampleDocDAO> sampleDoc) {
			this.document = sampleDoc;
		}

		@JacksonXmlElementWrapper(localName = "publicationUrls")
		public List<SamplePublicationUrlDAO> getPublicationUrl() {
			return this.publicationUrl;
		}

		public void setPublicationUrl(List<SamplePublicationUrlDAO> samplePublicationUrl) {
			this.publicationUrl = samplePublicationUrl;
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
}
