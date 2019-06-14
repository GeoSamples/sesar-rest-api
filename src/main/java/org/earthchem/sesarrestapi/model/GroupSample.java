package org.earthchem.sesarrestapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the group_sample database table.
 * 
 */
@Entity
@Table(name="group_sample")
@NamedQuery(name="GroupSample.findAll", query="SELECT g FROM GroupSample g")
public class GroupSample implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	//bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name="group_id")
	private Group group;

	//bi-directional many-to-one association to Sample
	@ManyToOne
	@JoinColumn(name="sample_id")
	private Sample sample;

	public GroupSample() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Sample getSample() {
		return this.sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}

}