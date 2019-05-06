package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


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