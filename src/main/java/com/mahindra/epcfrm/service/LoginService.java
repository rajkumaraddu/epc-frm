/**
 * 
 */
package com.mahindra.epcfrm.service;

import com.mahindra.epcfrm.entity.ApiResponseDto;

/**
 * @author Raju.Addu
 *
 */
public interface LoginService {
	
	public ApiResponseDto getOtp(String tokenId);

}
