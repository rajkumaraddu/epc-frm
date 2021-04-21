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
public class CropRespDto {

	private int id;
	private String cropName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

}
