package com.mahindra.epcfrm.dto;

public class DashBoardCountResponseDto {

	private Integer workOrderStatusCount;
	private Integer kycStatusCount;
	private Integer quotaionStatusCount;

	public Integer getWorkOrderStatusCount() {
		return workOrderStatusCount;
	}

	public void setWorkOrderStatusCount(Integer workOrderStatusCount) {
		this.workOrderStatusCount = workOrderStatusCount;
	}

	public Integer getKycStatusCount() {
		return kycStatusCount;
	}

	public void setKycStatusCount(Integer kycStatusCount) {
		this.kycStatusCount = kycStatusCount;
	}

	public Integer getQuotaionStatusCount() {
		return quotaionStatusCount;
	}

	public void setQuotaionStatusCount(Integer quotaionStatusCount) {
		this.quotaionStatusCount = quotaionStatusCount;
	}

}
