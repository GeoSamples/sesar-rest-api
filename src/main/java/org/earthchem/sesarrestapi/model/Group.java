package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the groups database table.
 * 
 */
@Entity
@Table(name="groups")
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="date_created")
	private Timestamp dateCreated;

	private String description;

	@Column(name="group_type")
	private String groupType;

	@Column(name="is_private")
	private Boolean isPrivate;

	private String name;

	//bi-directional many-to-one association to GroupSample
	@OneToMany(mappedBy="group")
	private List<GroupSample> groupSamples;

	//bi-directional many-to-one association to SesarUser
	@ManyToOne
	@JoinColumn(name="group_owner_id")
	private SesarUser sesarUser;

	public Group() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroupType() {
		return this.groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public Boolean getIsPrivate() {
		return this.isPrivate;
	}

	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GroupSample> getGroupSamples1() {
		return this.groupSamples;
	}

	public void setGroupSamples1(List<GroupSample> groupSamples) {
		this.groupSamples = groupSamples;
	}

	public GroupSample addGroupSamples1(GroupSample groupSamples1) {
		getGroupSamples1().add(groupSamples1);
		groupSamples1.setGroup(this);

		return groupSamples1;
	}

	public GroupSample removeGroupSamples1(GroupSample groupSamples1) {
		getGroupSamples1().remove(groupSamples1);
		groupSamples1.setGroup(null);

		return groupSamples1;
	}

	public SesarUser getSesarUser() {
		return this.sesarUser;
	}

	public void setSesarUser(SesarUser sesarUser) {
		this.sesarUser = sesarUser;
	}

}