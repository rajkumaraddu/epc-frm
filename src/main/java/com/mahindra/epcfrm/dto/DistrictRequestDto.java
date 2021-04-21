package com.mahindra.epcfrm.dto;

import org.springframework.stereotype.Component;

@Component
public class DistrictRequestDto {

	private int stateCode;

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

}
