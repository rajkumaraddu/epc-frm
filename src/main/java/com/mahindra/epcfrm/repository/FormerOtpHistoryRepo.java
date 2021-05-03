/**
 * 
 */
package com.mahindra.epcfrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mahindra.epcfrm.entity.FormerOtpHistoryEntity;

/**
 * @author Raju.Addu
 *
 */
@Repository
public interface FormerOtpHistoryRepo extends JpaRepository<FormerOtpHistoryEntity, Integer> {

	/**
	 * @param leadId
	 * @param mobile
	 * @param otpType
	 * @return
	 */
	@Query(value="SELECT * FROM epc_frm.former_otp_history f WHERE date(f.created_on)=current_date() and f.lead_id = :leadId "
			+ " and f.formar_mobile_no = :mobile and f.otp_type= :otpType and now() < date_add(f.created_on,interval 30 minute) "
			+ " order by created_on LIMIT 1 ", nativeQuery = true)
	FormerOtpHistoryEntity getFormerOtp(int leadId, String mobile, String otpType);

	/**
	 * @param leadId
	 * @param mobile
	 * @param otp
	 * @param otpType
	 * @return
	 */
	@Query(value="SELECT * FROM epc_frm.former_otp_history f WHERE date(f.created_on)=current_date() and f.lead_id = :leadId "
			+ " and f.formar_mobile_no = :mobile and f.otp_type= :otpType and f.otp = :otp "
			+ " order by created_on LIMIT 1 ", nativeQuery = true)
	FormerOtpHistoryEntity validateFormerOtp(int leadId, String mobile, String otp, String otpType);

}
