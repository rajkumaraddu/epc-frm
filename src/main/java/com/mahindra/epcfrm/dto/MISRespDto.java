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
public class MISRespDto {

	private int id;
	private String misName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMisName() {
		return misName;
	}

	public void setMisName(String misName) {
		this.misName = misName;
	}

}
