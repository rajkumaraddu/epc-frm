package com.mahindra.epcfrm.dto;

import org.springframework.stereotype.Component;

@Component
public class CityRequestDto {

	private int stateCode;
	//private int distCode;

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

}
