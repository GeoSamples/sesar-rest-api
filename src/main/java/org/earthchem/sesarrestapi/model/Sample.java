package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import javax.persistence.*;

import org.earthchem.sesarrestapi.dao.SampleDocDAO;
import org.earthchem.sesarrestapi.dao.SampleProfileDAO;
import org.earthchem.sesarrestapi.dao.SamplePublicationUrlDAO;
import org.postgresql.geometric.PGpoint;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sample database table.
 * 
 */
@Entity
@NamedQuery(name="Sample.findAll", query="SELECT s FROM Sample s")
public class Sample implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sample_id")
	private Integer sampleId;

	@Column(name="age_max")
	private Double ageMax;

	@Column(name="age_min")
	private Double ageMin;

	@Column(name="age_unit")
	private String ageUnit;

	@Column(name="archive_date")
	private Timestamp archiveDate;

	private String city;

	@Column(name="classification_comment")
	private String classificationComment;

	@Column(name="collection_date_precision")
	private String collectionDatePrecision;

	@Column(name="collection_end_date")
	private Timestamp collectionEndDate;

	@Column(name="collection_method")
	private String collectionMethod;

	@Column(name="collection_method_descr")
	private String collectionMethodDescr;

	@Column(name="collection_start_date")
	private Timestamp collectionStartDate;

	private String collector;

	@Column(name="collector_detail")
	private String collectorDetail;

	private String county;

	@Column(name="cruise_field_prgrm")
	private String cruiseFieldPrgrm;

	@Column(name="current_archive")
	private String currentArchive;

	@Column(name="current_archive_contact")
	private String currentArchiveContact;

	@Column(name="depth_max")
	private Double depthMax;

	@Column(name="depth_min")
	private Double depthMin;

	@Column(name="depth_scale")
	private String depthScale;

	private String description;

	private String easting;

	private Double elevation;

	@Column(name="elevation_end")
	private Double elevationEnd;

	@Column(name="elevation_unit")
	private String elevationUnit;

	@Column(name="external_parent_name")
	private String externalParentName;

	@Column(name="external_sample_id")
	private String externalSampleId;

	@Column(name="field_name")
	private String fieldName;

	@Column(name="geological_age")
	private String geologicalAge;

	@Column(name="geological_unit")
	private String geologicalUnit;
	
	@Column(name="geom_latlong", columnDefinition = "geometry(Point,4326)")
	private transient PGpoint geomLatlong;
	
	@Column(name="igsn")
	private String igsn;

	@Column(name="igsn_digit")
	private String igsnDigit;

	@Column(name="igsn_is_system_assigned")
	private Integer igsnIsSystemAssigned;

	@Column(name="igsn_to_int")
	private Long igsnToInt;

	@Column(name="last_registrant_id")
	private Integer lastRegistrantId;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	@Column(name="latitude")
	private Double latitude;

	@Column(name="latitude_end")
	private Double latitudeEnd;

	@Column(name="launch_id")
	private String launchId;

	@Column(name="launch_platform_name")
	private String launchPlatformName;

	@Column(name="legcy_country")
	private String legcyCountry;

	@Column(name="legcy_dataeditor_id")
	private Integer legcyDataeditorId;

	@Column(name="legcy_datecollected")
	private String legcyDatecollected;

	@Column(name="legcy_endgeodeticdatum")
	private String legcyEndgeodeticdatum;

	@Column(name="legcy_formcoordsys")
	private String legcyFormcoordsys;

	@Column(name="legcy_geoobjecttype")
	private Long legcyGeoobjecttype;

	@Column(name="legcy_id")
	private Long legcyId;

	@Column(name="legcy_locationname")
	private String legcyLocationname;

	@Column(name="legcy_mineralclassified")
	private Integer legcyMineralclassified;

	@Column(name="legcy_parent_id")
	private Long legcyParentId;

	@Column(name="legcy_rockclassified")
	private Integer legcyRockclassified;

	@Column(name="legcy_shapetype")
	private String legcyShapetype;

	@Column(name="legcy_startgeodeticdatum")
	private String legcyStartgeodeticdatum;

	@Column(name="legcy_verticaldatum")
	private String legcyVerticaldatum;

	private String locality;

	@Column(name="locality_description")
	private String localityDescription;

	@Column(name="location_description")
	private String locationDescription;

	private Double longitude;

	@Column(name="longitude_end")
	private Double longitudeEnd;

	@Column(name="metadata_store_status")
	private String metadataStoreStatus;

	private String name;

	private String northing;

	@Column(name="original_archive")
	private String originalArchive;

	@Column(name="original_archive_contact")
	private String originalArchiveContact;

	@Column(name="platform_descr")
	private String platformDescr;

	@Column(name="platform_name")
	private String platformName;

	@Column(name="platform_type")
	private String platformType;

	@Column(name="primary_location_name")
	private String primaryLocationName;

	@Column(name="primary_location_type")
	private String primaryLocationType;

	private String province;

	@Column(name="publish_date")
	private Timestamp publishDate;

	private String purpose;

	@Column(name="registration_date")
	private Timestamp registrationDate;

	@Column(name="sample_comment")
	private String sampleComment;

	@Column(name="sample_unit")
	private Integer sampleUnit;

	private String size;

	@Column(name="size_unit")
	private String sizeUnit;

	@Column(name="vertical_datum")
	private String verticalDatum;

	private String zone;

	//bi-directional many-to-one association to GroupSample
	@OneToMany(mappedBy="sample")
	private List<GroupSample> groupSamples;

	//bi-directional many-to-one association to Classification
	@ManyToOne
	@JoinColumn(name="classification_id")
	private Classification classification1;

	//bi-directional many-to-one association to Classification
	@ManyToOne
	@JoinColumn(name="top_level_classification_id")
	private Classification classification2;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;

	//bi-directional many-to-one association to LaunchType
	@ManyToOne
	@JoinColumn(name="launch_type_id")
	private LaunchType launchType;

	//bi-directional many-to-one association to NavType
	@ManyToOne
	@JoinColumn(name="nav_type_id")
	private NavType navType;

	//bi-directional many-to-one association to Sample
	@ManyToOne
	@JoinColumn(name="origin_sample_id")
	private Sample sample;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="sample")
	private List<Sample> samples;

	//bi-directional many-to-one association to SampleType
	@ManyToOne
	@JoinColumn(name="external_parent_sample_type_id")
	private SampleType sampleType1;

	//bi-directional many-to-one association to SampleType
	@ManyToOne
	@JoinColumn(name="sample_type_id")
	private SampleType sampleType3;

	//bi-directional many-to-one association to SesarUser
	@ManyToOne
	@JoinColumn(name="cur_owner_id")
	private SesarUser sesarUser1;

	//bi-directional many-to-one association to SesarUser
	@ManyToOne
	@JoinColumn(name="cur_registrant_id")
	private SesarUser sesarUser2;

	//bi-directional many-to-one association to SesarUser
	@ManyToOne
	@JoinColumn(name="last_changed_by")
	private SesarUser sesarUser3;

	//bi-directional many-to-one association to SesarUser
	@ManyToOne
	@JoinColumn(name="orig_owner_id")
	private SesarUser sesarUser5;

	//bi-directional many-to-one association to SesarUser
	@ManyToOne
	@JoinColumn(name="req_registrant_id")
	private SesarUser sesarUser6;

	//bi-directional many-to-one association to SesarUserCode
	@ManyToOne
	@JoinColumn(name="igsn_prefix", referencedColumnName="user_code")
	private SesarUserCode sesarUserCode;

	//bi-directional many-to-one association to SampleAdditionalName
	@OneToMany(mappedBy="sample")
	private List<SampleAdditionalName> sampleAdditionalNames;

	//bi-directional many-to-one association to SampleDoc
	@OneToMany(mappedBy="sample")
	private List<SampleDoc> sampleDocs;

	//bi-directional many-to-one association to SamplePublicationUrl
	@OneToMany(mappedBy="sample")
	private List<SamplePublicationUrl> samplePublicationUrls;

	//bi-directional many-to-one association to SampleUploadHistory
	@OneToMany(mappedBy="sample")
	private List<SampleUploadHistory> sampleUploadHistories;

	public Sample() {
	}

	public Integer getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(Integer sampleId) {
		this.sampleId = sampleId;
	}

	public double getAgeMax() {
		return this.ageMax;
	}

	public void setAgeMax(double ageMax) {
		this.ageMax = ageMax;
	}

	public double getAgeMin() {
		return this.ageMin;
	}

	public void setAgeMin(double ageMin) {
		this.ageMin = ageMin;
	}

	public String getAgeUnit() {
		return this.ageUnit;
	}

	public void setAgeUnit(String ageUnit) {
		this.ageUnit = ageUnit;
	}

	public Timestamp getArchiveDate() {
		return this.archiveDate;
	}

	public void setArchiveDate(Timestamp archiveDate) {
		this.archiveDate = archiveDate;
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

	public String getCollectionDatePrecision() {
		return this.collectionDatePrecision;
	}

	public void setCollectionDatePrecision(String collectionDatePrecision) {
		this.collectionDatePrecision = collectionDatePrecision;
	}

	public Timestamp getCollectionEndDate() {
		return this.collectionEndDate;
	}

	public void setCollectionEndDate(Timestamp collectionEndDate) {
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

	public Timestamp getCollectionStartDate() {
		return this.collectionStartDate;
	}

	public void setCollectionStartDate(Timestamp collectionStartDate) {
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

	public double getDepthMax() {
		return this.depthMax;
	}

	public void setDepthMax(double depthMax) {
		this.depthMax = depthMax;
	}

	public double getDepthMin() {
		return this.depthMin;
	}

	public void setDepthMin(double depthMin) {
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

	public double getElevation() {
		return this.elevation;
	}

	public void setElevation(double elevation) {
		this.elevation = elevation;
	}

	public double getElevationEnd() {
		return this.elevationEnd;
	}

	public void setElevationEnd(double elevationEnd) {
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
	@Transient
	public PGpoint getGeomLatlong() {
		return this.geomLatlong;
	}
    @Transient
	public void setGeomLatlong(PGpoint geomLatlong) {
		this.geomLatlong = geomLatlong;
	}

	public String getIgsn() {
		return this.igsn;
	}

	public void setIgsn(String igsn) {
		this.igsn = igsn;
	}

	public String getIgsnDigit() {
		return this.igsnDigit;
	}

	public void setIgsnDigit(String igsnDigit) {
		this.igsnDigit = igsnDigit;
	}

	public Integer getIgsnIsSystemAssigned() {
		return this.igsnIsSystemAssigned;
	}

	public void setIgsnIsSystemAssigned(Integer igsnIsSystemAssigned) {
		this.igsnIsSystemAssigned = igsnIsSystemAssigned;
	}

	public Long getIgsnToInt() {
		return this.igsnToInt;
	}

	public void setIgsnToInt(Long igsnToInt) {
		this.igsnToInt = igsnToInt;
	}

	public Integer getLastRegistrantId() {
		return this.lastRegistrantId;
	}

	public void setLastRegistrantId(Integer lastRegistrantId) {
		this.lastRegistrantId = lastRegistrantId;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLatitudeEnd() {
		return this.latitudeEnd;
	}

	public void setLatitudeEnd(double latitudeEnd) {
		this.latitudeEnd = latitudeEnd;
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

	public String getLegcyCountry() {
		return this.legcyCountry;
	}

	public void setLegcyCountry(String legcyCountry) {
		this.legcyCountry = legcyCountry;
	}

	public Integer getLegcyDataeditorId() {
		return this.legcyDataeditorId;
	}

	public void setLegcyDataeditorId(Integer legcyDataeditorId) {
		this.legcyDataeditorId = legcyDataeditorId;
	}

	public String getLegcyDatecollected() {
		return this.legcyDatecollected;
	}

	public void setLegcyDatecollected(String legcyDatecollected) {
		this.legcyDatecollected = legcyDatecollected;
	}

	public String getLegcyEndgeodeticdatum() {
		return this.legcyEndgeodeticdatum;
	}

	public void setLegcyEndgeodeticdatum(String legcyEndgeodeticdatum) {
		this.legcyEndgeodeticdatum = legcyEndgeodeticdatum;
	}

	public String getLegcyFormcoordsys() {
		return this.legcyFormcoordsys;
	}

	public void setLegcyFormcoordsys(String legcyFormcoordsys) {
		this.legcyFormcoordsys = legcyFormcoordsys;
	}

	public Long getLegcyGeoobjecttype() {
		return this.legcyGeoobjecttype;
	}

	public void setLegcyGeoobjecttype(Long legcyGeoobjecttype) {
		this.legcyGeoobjecttype = legcyGeoobjecttype;
	}

	public Long getLegcyId() {
		return this.legcyId;
	}

	public void setLegcyId(Long legcyId) {
		this.legcyId = legcyId;
	}

	public String getLegcyLocationname() {
		return this.legcyLocationname;
	}

	public void setLegcyLocationname(String legcyLocationname) {
		this.legcyLocationname = legcyLocationname;
	}

	public Integer getLegcyMineralclassified() {
		return this.legcyMineralclassified;
	}

	public void setLegcyMineralclassified(Integer legcyMineralclassified) {
		this.legcyMineralclassified = legcyMineralclassified;
	}

	public Long getLegcyParentId() {
		return this.legcyParentId;
	}

	public void setLegcyParentId(Long legcyParentId) {
		this.legcyParentId = legcyParentId;
	}

	public Integer getLegcyRockclassified() {
		return this.legcyRockclassified;
	}

	public void setLegcyRockclassified(Integer legcyRockclassified) {
		this.legcyRockclassified = legcyRockclassified;
	}

	public String getLegcyShapetype() {
		return this.legcyShapetype;
	}

	public void setLegcyShapetype(String legcyShapetype) {
		this.legcyShapetype = legcyShapetype;
	}

	public String getLegcyStartgeodeticdatum() {
		return this.legcyStartgeodeticdatum;
	}

	public void setLegcyStartgeodeticdatum(String legcyStartgeodeticdatum) {
		this.legcyStartgeodeticdatum = legcyStartgeodeticdatum;
	}

	public String getLegcyVerticaldatum() {
		return this.legcyVerticaldatum;
	}

	public void setLegcyVerticaldatum(String legcyVerticaldatum) {
		this.legcyVerticaldatum = legcyVerticaldatum;
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

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLongitudeEnd() {
		return this.longitudeEnd;
	}

	public void setLongitudeEnd(double longitudeEnd) {
		this.longitudeEnd = longitudeEnd;
	}

	public String getMetadataStoreStatus() {
		return this.metadataStoreStatus;
	}

	public void setMetadataStoreStatus(String metadataStoreStatus) {
		this.metadataStoreStatus = metadataStoreStatus;
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

	public String getOriginalArchive() {
		return this.originalArchive;
	}

	public void setOriginalArchive(String originalArchive) {
		this.originalArchive = originalArchive;
	}

	public String getOriginalArchiveContact() {
		return this.originalArchiveContact;
	}

	public void setOriginalArchiveContact(String originalArchiveContact) {
		this.originalArchiveContact = originalArchiveContact;
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

	public Timestamp getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Timestamp getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
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

	public List<GroupSample> getGroupSamples() {
		return this.groupSamples;
	}

	public void setGroupSamples1(List<GroupSample> groupSamples) {
		this.groupSamples = groupSamples;
	}

	public GroupSample addGroupSamples(GroupSample groupSamples) {
		getGroupSamples().add(groupSamples);
		groupSamples.setSample(this);

		return groupSamples;
	}

	public GroupSample removeGroupSamples1(GroupSample groupSamples) {
		getGroupSamples().remove(groupSamples);
		groupSamples.setSample(null);

		return groupSamples;
	}

	public Classification getClassification1() {
		return this.classification1;
	}

	public void setClassification1(Classification classification1) {
		this.classification1 = classification1;
	}

	public Classification getClassification2() {
		return this.classification2;
	}

	public void setClassification2(Classification classification2) {
		this.classification2 = classification2;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public LaunchType getLaunchType() {
		return this.launchType;
	}

	public void setLaunchType(LaunchType launchType) {
		this.launchType = launchType;
	}

	public NavType getNavType() {
		return this.navType;
	}

	public void setNavType(NavType navType) {
		this.navType = navType;
	}

	public Sample getSample() {
		return this.sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}

	public List<Sample> getSamples() {
		return this.samples;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}

	public Sample addSample(Sample sample) {
		getSamples().add(sample);
		sample.setSample(this);

		return sample;
	}

	public Sample removeSample(Sample sample) {
		getSamples().remove(sample);
		sample.setSample(null);

		return sample;
	}

	public SampleType getSampleType1() {
		return this.sampleType1;
	}

	public void setSampleType1(SampleType sampleType1) {
		this.sampleType1 = sampleType1;
	}
	
	public SampleType getSampleType3() {
		return this.sampleType3;
	}

	public void setSampleType3(SampleType sampleType3) {
		this.sampleType3 = sampleType3;
	}

	public SesarUser getSesarUser1() {
		return this.sesarUser1;
	}

	public void setSesarUser1(SesarUser sesarUser1) {
		this.sesarUser1 = sesarUser1;
	}

	public SesarUser getSesarUser2() {
		return this.sesarUser2;
	}

	public void setSesarUser2(SesarUser sesarUser2) {
		this.sesarUser2 = sesarUser2;
	}

	public SesarUser getSesarUser3() {
		return this.sesarUser3;
	}

	public void setSesarUser3(SesarUser sesarUser3) {
		this.sesarUser3 = sesarUser3;
	}

	public SesarUser getSesarUser5() {
		return this.sesarUser5;
	}

	public void setSesarUser5(SesarUser sesarUser5) {
		this.sesarUser5 = sesarUser5;
	}

	public SesarUser getSesarUser6() {
		return this.sesarUser6;
	}

	public void setSesarUser6(SesarUser sesarUser6) {
		this.sesarUser6 = sesarUser6;
	}

	public SesarUserCode getSesarUserCode() {
		return this.sesarUserCode;
	}

	public void setSesarUserCode(SesarUserCode sesarUserCode) {
		this.sesarUserCode = sesarUserCode;
	}

	public List<SampleAdditionalName> getSampleAdditionalNames() {
		return this.sampleAdditionalNames;
	}

	public void setSampleAdditionalNames(List<SampleAdditionalName> sampleAdditionalNames) {
		this.sampleAdditionalNames = sampleAdditionalNames;
	}

	public SampleAdditionalName addSampleAdditionalName(SampleAdditionalName sampleAdditionalName) {
		getSampleAdditionalNames().add(sampleAdditionalName);
		sampleAdditionalName.setSample(this);

		return sampleAdditionalName;
	}

	public SampleAdditionalName removeSampleAdditionalName(SampleAdditionalName sampleAdditionalName) {
		getSampleAdditionalNames().remove(sampleAdditionalName);
		sampleAdditionalName.setSample(null);

		return sampleAdditionalName;
	}

	public List<SampleDoc> getSampleDocs() {
		return this.sampleDocs;
	}

	public void setSampleDocs(List<SampleDoc> sampleDocs) {
		this.sampleDocs = sampleDocs;
	}

	public SampleDoc addSampleDoc(SampleDoc sampleDoc) {
		getSampleDocs().add(sampleDoc);
		sampleDoc.setSample(this);

		return sampleDoc;
	}

	public SampleDoc removeSampleDoc(SampleDoc sampleDoc) {
		getSampleDocs().remove(sampleDoc);
		sampleDoc.setSample(null);

		return sampleDoc;
	}

	public List<SamplePublicationUrl> getSamplePublicationUrls() {
		return this.samplePublicationUrls;
	}

	public void setSamplePublicationUrls(List<SamplePublicationUrl> samplePublicationUrls) {
		this.samplePublicationUrls = samplePublicationUrls;
	}

	public SamplePublicationUrl addSamplePublicationUrl(SamplePublicationUrl samplePublicationUrl) {
		getSamplePublicationUrls().add(samplePublicationUrl);
		samplePublicationUrl.setSample(this);

		return samplePublicationUrl;
	}

	public SamplePublicationUrl removeSamplePublicationUrl(SamplePublicationUrl samplePublicationUrl) {
		getSamplePublicationUrls().remove(samplePublicationUrl);
		samplePublicationUrl.setSample(null);

		return samplePublicationUrl;
	}

	public List<SampleUploadHistory> getSampleUploadHistories() {
		return this.sampleUploadHistories;
	}

	public void setSampleUploadHistories(List<SampleUploadHistory> sampleUploadHistories) {
		this.sampleUploadHistories = sampleUploadHistories;
	}

	public SampleUploadHistory addSampleUploadHistory(SampleUploadHistory sampleUploadHistory) {
		getSampleUploadHistories().add(sampleUploadHistory);
		sampleUploadHistory.setSample(this);

		return sampleUploadHistory;
	}

	public SampleUploadHistory removeSampleUploadHistory(SampleUploadHistory sampleUploadHistory) {
		getSampleUploadHistories().remove(sampleUploadHistory);
		sampleUploadHistory.setSample(null);

		return sampleUploadHistory;
	}

	public SampleProfileDAO getDAO()
	{
		SampleProfileDAO a = new SampleProfileDAO();
		a.setIgsn(igsn);
		
		if(sesarUserCode != null)
		  a.setSesarUserCode(sesarUserCode.getUserCode());
			
		Date today= new Date();		
		if(archiveDate == null)
		{
		  if(publishDate.after(today) )
		  {
			a.setStatus("Private");
			return a;
		  }
		  else
	        a.setStatus("Public");
		}
		else if(archiveDate.before(today))
		{
			a.setStatus("Deleted");
			return a;
		}
		
		a.setAgeMax(ageMax);
		a.setAgeMin(ageMin);
		a.setAgeUnit(ageUnit);
		
		a.setCity(city);
	
		if(classification1 !=null )
		  a.setClassification(classification1.getName());
			
		if(classification2 !=null )
		  a.setMaterial(classification2.getName());
		
	    a.setClassificationComment(classificationComment);
		a.setCollectionDatePrecision(collectionDatePrecision);
		
		String pattern = "yyyy-MM-dd";
		if(collectionDatePrecision != null)
		{
		if(collectionDatePrecision.equalsIgnoreCase("time"))
			pattern = "yyyy-MM-dd HH:mm:ss";
		else if(collectionDatePrecision.equalsIgnoreCase("year"))
				pattern = "yyyy";
		else if(collectionDatePrecision.equalsIgnoreCase("day"))
			pattern = "yyyy-MM-dd";
		else if(collectionDatePrecision.equalsIgnoreCase("month"))
			pattern = "yyyy-MM";
		}
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		if(collectionStartDate != null)
		  a.setCollectionStartDate(simpleDateFormat.format(collectionStartDate));		
		if(collectionEndDate != null)
	      a.setCollectionEndDate(simpleDateFormat.format(collectionEndDate));
	    
		a.setCollectionMethod(collectionMethod);
		a.setCollectionMethodDescr(collectionMethodDescr);
		
		a.setCollector(collector);
		a.setCollectorDetail(collectorDetail);
	
		if(country != null)
		  a.setCountry(country.getName());
		
		a.setCounty(county);
		a.setCruiseFieldPrgrm(cruiseFieldPrgrm);
		a.setCurrentArchive(currentArchive);
		a.setCurrentArchiveContact(currentArchiveContact);
		a.setDepthMax(depthMax);
		a.setDepthMin(depthMin);
		a.setDepthScale(depthScale);
		a.setDescription(description);
		a.setEasting(easting);
		a.setElevation(elevation);
		a.setElevationEnd(elevationEnd);
		a.setElevationUnit(elevationUnit);
		a.setExternalParentName(externalParentName);
		if(sampleType1 != null)
		  a.setExternalParentSampleTypeId(sampleType1.getSampleTypeId());
		a.setExternalSampleId(externalSampleId);
		a.setFieldName(fieldName);
		a.setGeologicalAge(geologicalAge);
		a.setGeologicalUnit(geologicalUnit);
		a.setLatitude(latitude);
		a.setLatitudeEnd(latitudeEnd);
		a.setLaunchId(launchId);
		a.setLaunchPlatformName(launchPlatformName);
		if(launchType != null)
		  a.setLaunchTypeName(launchType.getName());
		a.setLocality(locality);
		a.setLocalityDescription(localityDescription);
		a.setLocationDescription(locationDescription);
		a.setLongitude(longitude);
		a.setLongitudeEnd(longitudeEnd);
		a.setName(name);
		if(navType !=null)
		  a.setNavigationType(navType.getName());
		a.setNorthing(northing);
		a.setOriginalArchive(originalArchive);
		a.setOriginalArchiveContact(originalArchiveContact);

		if(sample != null)
		  a.setParentIGSN(sample.getIgsn());

		//Set up children IGSN
		if(samples != null)
		{
			List<String> l = new ArrayList<String>();
			for(Sample s: samples)
			{
				l.add(s.getIgsn());
			}
			a.setSampleChildrenIGSNs(l);
		}
		
		a.setPlatformDescr(platformDescr);
		a.setPlatformName(launchPlatformName);
		a.setPlatformType(platformType);
		a.setPrimaryLocationName(primaryLocationName);
		a.setPrimaryLocationType(primaryLocationType);
		a.setProvince(province);
		pattern = "yyyy-MM-dd";
		simpleDateFormat = new SimpleDateFormat(pattern);
		
		if( publishDate != null )
		  a.setPublishDate(simpleDateFormat.format(publishDate));
		a.setPurpose(purpose);
		if( registrationDate != null )
		  a.setRegistrationDate(simpleDateFormat.format(registrationDate));
		a.setSampleComment(sampleComment);
		a.setSampleId(sampleId);

		if(sampleAdditionalNames != null)
		{
		  List<String> nl = new ArrayList<String>();
		  for(SampleAdditionalName sdn : sampleAdditionalNames)
		  {
			  nl.add(sdn.getName());
		  }
		  a.setSampleOtherNames(nl);
		}
		
		if(sampleType3 != null)
		{
			if(sampleType3.getSampleType() != null) //parent sample type
			{
		      a.setSampleSubType(sampleType3.getName());
		      a.setSampleType(sampleType3.getSampleType().getName());
			}
			else
			{
				a.setSampleType(sampleType3.getName());
			}
		}
		a.setSampleUnit(sampleUnit);
		a.setSize(size);
		a.setSizeUnit(sizeUnit);
		a.setVerticalDatum(legcyVerticaldatum);
		a.setZone(zone);

		if( samplePublicationUrls !=null)
		{   List<SamplePublicationUrlDAO> l = new ArrayList<SamplePublicationUrlDAO>();
			for(SamplePublicationUrl p : samplePublicationUrls)
			{
				l.add(p.getDAO());
			}
			a.setSamplePublicationUrls(l);
		}
		if(sampleDocs != null)
		{   
			List<SampleDocDAO> l = new ArrayList<SampleDocDAO>();
		    for(SampleDoc p : sampleDocs)
		    {		    
			  l.add(p.getDAO());
		    }
		     a.setSampleDocs(l);
        }

		return a;
	}
}