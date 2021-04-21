/**
 * 
 */
package com.mahindra.epcfrm.dto;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Raju.Addu
 *
 */
@Component
public class LeadMasterDataRespDto {

	private int statusCode;
	private String message;
	private List<DlrRespDto> dealers;
	private List<CropRespDto> crops;
	private List<StateSubsidyRespDto> stateAndSubsidy;
	private List<MISRespDto> misProducts;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<DlrRespDto> getDealers() {
		return dealers;
	}

	public void setDealers(List<DlrRespDto> dealers) {
		this.dealers = dealers;
	}

	public List<CropRespDto> getCrops() {
		return crops;
	}

	public void setCrops(List<CropRespDto> crops) {
		this.crops = crops;
	}

	public List<StateSubsidyRespDto> getStateAndSubsidy() {
		return stateAndSubsidy;
	}

	public void setStateAndSubsidy(List<StateSubsidyRespDto> stateAndSubsidy) {
		this.stateAndSubsidy = stateAndSubsidy;
	}

	public List<MISRespDto> getMisProducts() {
		return misProducts;
	}

	public void setMisProducts(List<MISRespDto> misProducts) {
		this.misProducts = misProducts;
	}

}
