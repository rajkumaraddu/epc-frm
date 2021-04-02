/**
 * 
 */
package com.mahindra.epcfrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Raju.Addu
 *
 */
@Entity
@Table(name = "StateClusterMaster")
public class StateClusterMasterEntity extends BaseEntity {

	private static final long serialVersionUID = 3491072682364077748L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 20)
	private String scId;
	@Column(length = 50)
	private String scName;
	@Column(length = 100)
	private String scDesc;
	@Column(length = 1)
	private String activeStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScId() {
		return scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public String getScDesc() {
		return scDesc;
	}

	public void setScDesc(String scDesc) {
		this.scDesc = scDesc;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

}
