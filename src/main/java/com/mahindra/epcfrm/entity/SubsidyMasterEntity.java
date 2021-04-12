/**
 * 
 */
package com.mahindra.epcfrm.entity;

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
@Table(name = "SubsidyMaster")
public class SubsidyMasterEntity extends BaseEntity {

	private static final long serialVersionUID = -5885386005687845412L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int stateCode;
	private double subsidy;

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

	public double getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(double subsidy) {
		this.subsidy = subsidy;
	}

}
