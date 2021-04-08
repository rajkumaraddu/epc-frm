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
@Table(name = "StateMaster")
public class StateMasterEntity extends BaseEntity {

	private static final long serialVersionUID = 2261339448095347282L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int stateCode;
	@Column(length = 100)
	private String stateName;
	private int gstCode;
	@Column(length = 10)
	private String stateOrUT;
	@Column(length = 1)
	private String activeStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public int getGstCode() {
		return gstCode;
	}

	public void setGstCode(int gstCode) {
		this.gstCode = gstCode;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

}
