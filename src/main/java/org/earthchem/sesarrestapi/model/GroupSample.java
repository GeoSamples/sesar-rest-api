package org.earthchem.sesarrestapi.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the group_sample database table.
 * 
 */
@Entity
@Table(name="group_sample")
@NamedQuery(name="GroupSample.findAll", query="SELECT g FROM GroupSample g")
public class GroupSample implements Serializable {
	private static final long serialVersionUID = 1L;

	public GroupSample() {
	}

}