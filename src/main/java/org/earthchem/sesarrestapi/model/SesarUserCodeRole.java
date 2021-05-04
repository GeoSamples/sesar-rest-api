package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the sesar_user_code_role database table.
 * 
 */
@Entity
@Table(name="sesar_user_code_role")
@NamedQuery(name="SesarUserCodeRole.findAll", query="SELECT s FROM SesarUserCodeRole s")
public class SesarUserCodeRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sesar_user_code_role_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sesar_user_code_role_seq")	
	@SequenceGenerator(name = "sesar_user_code_role_seq", sequenceName = "sesar_user_code_role_sesar_user_code_role_id_seq",allocationSize=1)
	private Integer sesarUserCodeRoleId;

	@Column(name="activate_date")
	private Timestamp activateDate;

	@Column(name="deactivate_date")
	private Timestamp deactivateDate;

	@Column(name="geopass_id")
	private String geopassId;

	@Column(name="user_code")
	private String userCode;

	//bi-directional many-to-one association to SesarRole
	@ManyToOne
	@JoinColumn(name="sesar_role_id")
	private SesarRole sesarRole;

	public SesarUserCodeRole() {
	}

	public Integer getSesarUserCodeRoleId() {
		return this.sesarUserCodeRoleId;
	}

	public void setSesarUserCodeRoleId(Integer sesarUserCodeRoleId) {
		this.sesarUserCodeRoleId = sesarUserCodeRoleId;
	}

	public Timestamp getActivateDate() {
		return this.activateDate;
	}

	public void setActivateDate(Timestamp activateDate) {
		this.activateDate = activateDate;
	}

	public Timestamp getDeactivateDate() {
		return this.deactivateDate;
	}

	public void setDeactivateDate(Timestamp deactivateDate) {
		this.deactivateDate = deactivateDate;
	}

	public String getGeopassId() {
		return this.geopassId;
	}

	public void setGeopassId(String geopassId) {
		this.geopassId = geopassId;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public SesarRole getSesarRole() {
		return this.sesarRole;
	}

	public void setSesarRole(SesarRole sesarRole) {
		this.sesarRole = sesarRole;
	}

}