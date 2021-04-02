/**
 * 
 */
package com.mahindra.epcfrm.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author Raju.Addu
 *
 */
@Component
public class ApiResponseDto implements Serializable {

	private static final long serialVersionUID = 3692733483653598722L;

	private String status;
	private String tokenId;
	private String mobile;
	private String otp;
	private String otpValidity;
	private String message;
	
	
	public ApiResponseDto() { }

	public ApiResponseDto(String status, String tokenId, String mobile, String message) {
		super();
		this.status = status;
		this.tokenId = tokenId;
		this.mobile = mobile;
		this.message = message;
		this.otp = "";
		this.otpValidity = "";
	}

	public ApiResponseDto(String status, String tokenId, String mobile, String otp, String otpValidity, String message) {
		super();
		this.status = status;
		this.tokenId = tokenId;
		this.mobile = mobile;
		this.otp = otp;
		this.otpValidity = otpValidity;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getOtpValidity() {
		return otpValidity;
	}

	public void setOtpValidity(String otpValidity) {
		this.otpValidity = otpValidity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ApiResponseDto [status=" + status + ", tokenId=" + tokenId + ", mobile=" + mobile+ ", otp=" + otp
				+ ", otpValidity=" + otpValidity + ", message=" + message + "]";
	}

}
