/**
 * 
 */
package com.mahindra.epcfrm.entity;

import java.io.Serializable;

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
@Table(name = "DistrictMaster")
public class DistrictMasterEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 6037514368429831549L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int districtCode;
	@Column(length = 100)
	private String districtName;
	private int stateCode;
	@Column(length = 10)
	private String distShortName;
	@Column(length = 1)
	private String activeStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(int districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	public String getDistShortName() {
		return distShortName;
	}

	public void setDistShortName(String distShortName) {
		this.distShortName = distShortName;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

}
