/**
 * 
 */
package com.mahindra.epcfrm.service;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

import com.mahindra.epcfrm.dto.ApiResponseDto;
import com.mahindra.epcfrm.dto.CreateUpdateRespDto;

/**
 * @author Raju.Addu
 *
 */
public interface LoginService {
	
	public ApiResponseDto getOtp(String tokenId, String type, int leadId, String otpType, HttpSession session);

	/**
	 * @param mobile
	 * @param leadId
	 * @param otp
	 * @param otpType
	 * @param session
	 * @return
	 */
	public CreateUpdateRespDto validateFormerOtp(String mobile, int leadId, String otp, String otpType,
			HttpSession session);

}
