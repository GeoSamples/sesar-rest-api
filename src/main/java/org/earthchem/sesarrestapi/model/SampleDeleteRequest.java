package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sample_delete_request database table.
 * 
 */
@Entity
@Table(name="sample_delete_request")
@NamedQuery(name="SampleDeleteRequest.findAll", query="SELECT s FROM SampleDeleteRequest s")
public class SampleDeleteRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="deactivated_by")
	private Integer deactivatedBy;

	@Column(name="deactivated_date")
	private Timestamp deactivatedDate;

	@Column(name="delete_reason")
	private String deleteReason;

	@Column(name="deleted_by")
	private Integer deletedBy;

	@Column(name="deleted_date")
	private Timestamp deletedDate;

	@Column(name="duplicate_igsns")
	private String duplicateIgsns;

	@Column(name="other_reason")
	private String otherReason;

	@Column(name="requestor_user_id")
	private Integer requestorUserId;

	@Column(name="sample_id")
	private Integer sampleId;

	public SampleDeleteRequest() {
	}

	public Integer getDeactivatedBy() {
		return this.deactivatedBy;
	}

	public void setDeactivatedBy(Integer deactivatedBy) {
		this.deactivatedBy = deactivatedBy;
	}

	public Timestamp getDeactivatedDate() {
		return this.deactivatedDate;
	}

	public void setDeactivatedDate(Timestamp deactivatedDate) {
		this.deactivatedDate = deactivatedDate;
	}

	public String getDeleteReason() {
		return this.deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	public Integer getDeletedBy() {
		return this.deletedBy;
	}

	public void setDeletedBy(Integer deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Timestamp getDeletedDate() {
		return this.deletedDate;
	}

	public void setDeletedDate(Timestamp deletedDate) {
		this.deletedDate = deletedDate;
	}

	public String getDuplicateIgsns() {
		return this.duplicateIgsns;
	}

	public void setDuplicateIgsns(String duplicateIgsns) {
		this.duplicateIgsns = duplicateIgsns;
	}

	public String getOtherReason() {
		return this.otherReason;
	}

	public void setOtherReason(String otherReason) {
		this.otherReason = otherReason;
	}

	public Integer getRequestorUserId() {
		return this.requestorUserId;
	}

	public void setRequestorUserId(Integer requestorUserId) {
		this.requestorUserId = requestorUserId;
	}

	public Integer getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(Integer sampleId) {
		this.sampleId = sampleId;
	}

}