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
public class FormerOtpRequestDto {

	private int leadId;
	private String formarMobileNo;
	private String otpType;
	private String otp = "0";

	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	public String getFormarMobileNo() {
		return formarMobileNo;
	}

	public void setFormarMobileNo(String formarMobileNo) {
		this.formarMobileNo = formarMobileNo;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getOtpType() {
		return otpType;
	}

	public void setOtpType(String otpType) {
		this.otpType = otpType;
	}

}
