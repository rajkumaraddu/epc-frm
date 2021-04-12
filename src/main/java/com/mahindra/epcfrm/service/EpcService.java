/**
 * 
 */
package com.mahindra.epcfrm.service;

import com.mahindra.epcfrm.dto.MasterResponseDto;

/**
 * @author Raju.Addu
 *
 */
public interface EpcService {

	/**
	 * @return
	 */
	MasterResponseDto getAllDealers();

	/**
	 * @param stateCode
	 * @return
	 */
	MasterResponseDto getSubsidy(int stateCode);

}
