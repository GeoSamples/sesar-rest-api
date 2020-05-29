package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the sesar_user database table.
 * 
 */
@Entity
@Table(name="sesar_user")
@NamedQuery(name="SesarUser.findAll", query="SELECT s FROM SesarUser s")
public class SesarUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sesar_user_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sesar_user_seq")	
	@SequenceGenerator(name = "sesar_user_seq", sequenceName = "sesar_user_sesar_user_id_seq",allocationSize=1)

	private Integer sesarUserId;

	private String address1;

	private String address2;

	private String city;

	@Column(name="deactivation_date")
	private Timestamp deactivationDate;

	private String email;

	private String fax;

	private String fname;

	@Column(name="geopass_id")
	private String geopassId;

	private String institution;

	@Column(name="institution_detail")
	private String institutionDetail;

	@Column(name="is_admin")
	private Integer isAdmin;

	@Column(name="legacy_user_id")
	private Integer legacyUserId;

	private String lname;

	private String note;

	private String orcid;

	private String password;

	private String phone;

	@Column(name="postal_code")
	private String postalCode;

	@Column(name="registration_date")
	private Timestamp registrationDate;

	@Column(name="sso_account_id")
	private Integer ssoAccountId;

	@Column(name="state_province")
	private String stateProvince;

	@Temporal(TemporalType.DATE)
	@Column(name="upload_permission_date")
	private Date uploadPermissionDate;

	@Column(name="upload_permission_status")
	private Integer uploadPermissionStatus;

	//bi-directional many-to-one association to Group
	@OneToMany(mappedBy="sesarUser")
	private List<Group> groups;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="sesarUser1")
	private List<Sample> samples1;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="sesarUser2")
	private List<Sample> samples2;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="sesarUser3")
	private List<Sample> samples3;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="sesarUser5")
	private List<Sample> samples5;

	//bi-directional many-to-one association to Sample
	@OneToMany(mappedBy="sesarUser6")
	private List<Sample> samples6;

	//bi-directional many-to-one association to SampleDoc
	@OneToMany(mappedBy="sesarUser")
	private List<SampleDoc> sampleDocs;

	//bi-directional many-to-one association to SampleUploadHistory
	@OneToMany(mappedBy="sesarUser")
	private List<SampleUploadHistory> sampleUploadHistories;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;

	//bi-directional many-to-one association to SesarUserCode
	@OneToMany(mappedBy="sesarUser")
	private List<SesarUserCode> sesarUserCodes;

	public SesarUser() {
	}

	public Integer getSesarUserId() {
		return this.sesarUserId;
	}

	public void setSesarUserId(Integer sesarUserId) {
		this.sesarUserId = sesarUserId;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Timestamp getDeactivationDate() {
		return this.deactivationDate;
	}

	public void setDeactivationDate(Timestamp deactivationDate) {
		this.deactivationDate = deactivationDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getGeopassId() {
		return this.geopassId;
	}

	public void setGeopassId(String geopassId) {
		this.geopassId = geopassId;
	}

	public String getInstitution() {
		return this.institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getInstitutionDetail() {
		return this.institutionDetail;
	}

	public void setInstitutionDetail(String institutionDetail) {
		this.institutionDetail = institutionDetail;
	}

	public Integer getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getLegacyUserId() {
		return this.legacyUserId;
	}

	public void setLegacyUserId(Integer legacyUserId) {
		this.legacyUserId = legacyUserId;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOrcid() {
		return this.orcid;
	}

	public void setOrcid(String orcid) {
		this.orcid = orcid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Timestamp getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Integer getSsoAccountId() {
		return this.ssoAccountId;
	}

	public void setSsoAccountId(Integer ssoAccountId) {
		this.ssoAccountId = ssoAccountId;
	}

	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public Date getUploadPermissionDate() {
		return this.uploadPermissionDate;
	}

	public void setUploadPermissionDate(Date uploadPermissionDate) {
		this.uploadPermissionDate = uploadPermissionDate;
	}

	public Integer getUploadPermissionStatus() {
		return this.uploadPermissionStatus;
	}

	public void setUploadPermissionStatus(Integer uploadPermissionStatus) {
		this.uploadPermissionStatus = uploadPermissionStatus;
	}

	public List<Group> getGroups() {
		return this.groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public Group addGroup(Group group) {
		getGroups().add(group);
		group.setSesarUser(this);

		return group;
	}

	public Group removeGroup(Group group) {
		getGroups().remove(group);
		group.setSesarUser(null);

		return group;
	}

	public List<Sample> getSamples1() {
		return this.samples1;
	}

	public void setSamples1(List<Sample> samples1) {
		this.samples1 = samples1;
	}

	public Sample addSamples1(Sample samples1) {
		getSamples1().add(samples1);
		samples1.setSesarUser1(this);

		return samples1;
	}

	public Sample removeSamples1(Sample samples1) {
		getSamples1().remove(samples1);
		samples1.setSesarUser1(null);

		return samples1;
	}

	public List<Sample> getSamples2() {
		return this.samples2;
	}

	public void setSamples2(List<Sample> samples2) {
		this.samples2 = samples2;
	}

	public Sample addSamples2(Sample samples2) {
		getSamples2().add(samples2);
		samples2.setSesarUser2(this);

		return samples2;
	}

	public Sample removeSamples2(Sample samples2) {
		getSamples2().remove(samples2);
		samples2.setSesarUser2(null);

		return samples2;
	}

	public List<Sample> getSamples3() {
		return this.samples3;
	}

	public void setSamples3(List<Sample> samples3) {
		this.samples3 = samples3;
	}

	public Sample addSamples3(Sample samples3) {
		getSamples3().add(samples3);
		samples3.setSesarUser3(this);

		return samples3;
	}

	public Sample removeSamples3(Sample samples3) {
		getSamples3().remove(samples3);
		samples3.setSesarUser3(null);

		return samples3;
	}

	public List<Sample> getSamples5() {
		return this.samples5;
	}

	public void setSamples5(List<Sample> samples5) {
		this.samples5 = samples5;
	}

	public Sample addSamples5(Sample samples5) {
		getSamples5().add(samples5);
		samples5.setSesarUser5(this);

		return samples5;
	}

	public Sample removeSamples5(Sample samples5) {
		getSamples5().remove(samples5);
		samples5.setSesarUser5(null);

		return samples5;
	}

	public List<Sample> getSamples6() {
		return this.samples6;
	}

	public void setSamples6(List<Sample> samples6) {
		this.samples6 = samples6;
	}

	public Sample addSamples6(Sample samples6) {
		getSamples6().add(samples6);
		samples6.setSesarUser6(this);

		return samples6;
	}

	public Sample removeSamples6(Sample samples6) {
		getSamples6().remove(samples6);
		samples6.setSesarUser6(null);

		return samples6;
	}

	public List<SampleDoc> getSampleDocs() {
		return this.sampleDocs;
	}

	public void setSampleDocs(List<SampleDoc> sampleDocs) {
		this.sampleDocs = sampleDocs;
	}

	public SampleDoc addSampleDoc(SampleDoc sampleDoc) {
		getSampleDocs().add(sampleDoc);
		sampleDoc.setSesarUser(this);

		return sampleDoc;
	}

	public SampleDoc removeSampleDoc(SampleDoc sampleDoc) {
		getSampleDocs().remove(sampleDoc);
		sampleDoc.setSesarUser(null);

		return sampleDoc;
	}

	public List<SampleUploadHistory> getSampleUploadHistories() {
		return this.sampleUploadHistories;
	}

	public void setSampleUploadHistories(List<SampleUploadHistory> sampleUploadHistories) {
		this.sampleUploadHistories = sampleUploadHistories;
	}

	public SampleUploadHistory addSampleUploadHistory(SampleUploadHistory sampleUploadHistory) {
		getSampleUploadHistories().add(sampleUploadHistory);
		sampleUploadHistory.setSesarUser(this);

		return sampleUploadHistory;
	}

	public SampleUploadHistory removeSampleUploadHistory(SampleUploadHistory sampleUploadHistory) {
		getSampleUploadHistories().remove(sampleUploadHistory);
		sampleUploadHistory.setSesarUser(null);

		return sampleUploadHistory;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<SesarUserCode> getSesarUserCodes() {
		return this.sesarUserCodes;
	}

	public void setSesarUserCodes(List<SesarUserCode> sesarUserCodes) {
		this.sesarUserCodes = sesarUserCodes;
	}

	public SesarUserCode addSesarUserCode(SesarUserCode sesarUserCode) {
		getSesarUserCodes().add(sesarUserCode);
		sesarUserCode.setSesarUser(this);

		return sesarUserCode;
	}

	public SesarUserCode removeSesarUserCode(SesarUserCode sesarUserCode) {
		getSesarUserCodes().remove(sesarUserCode);
		sesarUserCode.setSesarUser(null);

		return sesarUserCode;
	}

}