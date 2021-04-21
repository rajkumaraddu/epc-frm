/**
 * 
 */
package com.mahindra.epcfrm.dto;

import org.springframework.stereotype.Component;

/**
 * @author Raju.Addu
 *
 */
@Component
public class StateSubsidyRespDto {

	private int id;
	private int stateCode;
	private String stateName;
	private String stateOrUT;
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

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateOrUT() {
		return stateOrUT;
	}

	public void setStateOrUT(String stateOrUT) {
		this.stateOrUT = stateOrUT;
	}

	public double getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(double subsidy) {
		this.subsidy = subsidy;
	}

}
