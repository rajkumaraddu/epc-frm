/**
 * 
 */
package com.mahindra.epcfrm.serviceimpl;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mahindra.epcfrm.dto.ApiResponseDto;
import com.mahindra.epcfrm.dto.CreateUpdateRespDto;
import com.mahindra.epcfrm.entity.FormerOtpHistoryEntity;
import com.mahindra.epcfrm.entity.UserMasterEntity;
import com.mahindra.epcfrm.repository.FormerOtpHistoryRepo;
import com.mahindra.epcfrm.repository.UserMasterRepo;
import com.mahindra.epcfrm.service.LoginService;
import com.mahindra.epcfrm.service.SMSService;

/**
 * @author Raju.Addu
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private SMSService smsService;
	@Autowired
	private UserMasterRepo userRepo;
	@Autowired
	FormerOtpHistoryRepo otpRepo;

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	private static Random random = new Random();
	public static final int OTPVALIDITYSECS = 120;
	public static final String TOOMANYREQ = "toomanyreq";
	private String logedinUser = "EPC-User";

	@Override
	public ApiResponseDto getOtp(String mobile, String userType, int leadId, String otpType, HttpSession session) {
		logedinUser = session != null ? (String) session.getAttribute("loginUser") : "Admin";
		long curMillis = System.currentTimeMillis();
		logger.info("inside getOtp() for mobile: {}", mobile);
		if (mobile == null || mobile.isEmpty()) {
			logger.info("Empty mobile provided, returning..");
			return new ApiResponseDto("fail", 1, mobile, null, "Provide mandatory fields");
		}
		String status = "";
		int statusCode;
		String message = "";
		String otpValidity = "";
		String otp = "";
		int mobLen = 0;

		if (mobile != null && !mobile.isEmpty()) {
			logger.info("Generating OTP and sending to Mobile No. " + mobile);
			mobLen = mobile.length();

			if (mobLen != 10) {
				ApiResponseDto responseDto = new ApiResponseDto("fail", 1, "", mobile, "", "",
						"Please enter 10-digits mobile number.");
				logger.info("Returing resonse: " + responseDto);
				return responseDto;
			}

			UserMasterEntity user = userRepo.findByMobile(mobile);
			if ("User".equalsIgnoreCase(userType) && user == null) {
				ApiResponseDto responseDto = new ApiResponseDto("no-user", 1, "",
						"XXXX" + mobile.substring(mobLen - 3, mobLen), "", "", "User not available.");
				logger.info("Returing resonse: " + responseDto);
				return responseDto;
			}

			try {
				otp = "" + (10000 + random.nextInt(90000));
				logger.info("Generated OTP: " + otp);
				otpValidity = LocalDateTime.now().plusSeconds(OTPVALIDITYSECS).toString();

				// String sms = otp + " is the OTP to reset your Mahindra login id password,
				// valid till " + otpValidity;
				String sms = "";

				if ("Former".equalsIgnoreCase(userType)) {
					otp = this.getFormerHistoryOtp(leadId, mobile, otpType, otp);

					sms = "*Mahindra NT Account* " + otp
							+ " is the OTP to reset your Mahindra Domain password, valid till " + otpValidity;

				} else if ("User".equalsIgnoreCase(userType)) {
					sms = "*Mahindra NT Account* " + otp
							+ " is the OTP to reset your Mahindra Domain password, valid till " + otpValidity;

					if (!updateUserOtp(mobile, otp, otpValidity)) {
						ApiResponseDto responseDto = new ApiResponseDto("db-issue", 1, "",
								"XXXX" + mobile.substring(mobLen - 3, mobLen), "", "", "Please try after sometime.");
						logger.info("Returing resonse: {}", responseDto);
						return responseDto;
					}
				}

				if (smsService.sendSMS(mobile, sms)) {
					logger.info("OTP sent successfully to Mobile No. " + mobile + ", with SMS text: " + sms);
					status = "success";
					statusCode = 0;
					message = "OTP is sent to Mobile No. ending with XXXX" + mobile.substring(mobLen - 3, mobLen);
				} else {
					logger.info("Failed to send OTP on Mobile No. " + mobile + ", with SMS text: " + sms);
					status = "fail";
					statusCode = 1;
					message = "Failed to sent OTP to Mobile No. ending with XXXX"
							+ mobile.substring(mobLen - 3, mobLen);
				}
			} catch (Exception e) {
				logger.error("Exception while sending opt to mobile \"" + mobile + "\", details: " + e.getMessage()
						+ ", trace: ", e);
				status = "fail";
				statusCode = 1;
				message = "Failed to sent OTP to Mobile No. ending with XXXX" + mobile.substring(mobLen - 3, mobLen);
			}
		} else {
			logger.info("Mobile No. is not registered with EPC. " + mobile);
			status = "fail";
			statusCode = 1;
			message = "Mobile No. is not registered with EPC.";
		}
		if (mobile.isEmpty()) {
			mobile = "XXXX";
			mobLen = 3;
		}
		ApiResponseDto responseDto = new ApiResponseDto(status, statusCode, mobile,
				"XXXX" + mobile.substring(mobLen - 3, mobLen), otp, otpValidity, message);
		logger.info("Returing resonse: " + responseDto);
		logger.info("Time taken by sendOtp() including getEmpDetailsByTokenId() and SMSService calls in millis: "
				+ (System.currentTimeMillis() - curMillis));
		return responseDto;
	}

	/**
	 * @param leadId
	 * @param mobile
	 * @param otp
	 * @param otpValidity
	 * @return
	 */
	private String getFormerHistoryOtp(int leadId, String mobile, String otpType, String otp) {
		FormerOtpHistoryEntity otpEntity = otpRepo.getFormerOtp(leadId, mobile, otpType);
		if (otpEntity == null) {
			FormerOtpHistoryEntity saveOtp = new FormerOtpHistoryEntity();
			saveOtp.setFormarMobileNo(mobile);
			saveOtp.setCreatedBy(logedinUser);
			saveOtp.setLeadId(leadId);
			saveOtp.setOtp(otp);
			saveOtp.setOtyType(otpType);
			otpRepo.save(saveOtp);
		} else {
			otp = otpEntity.getOtp();
		}
		return otp;
	}

	/**
	 * @param mobile
	 * @param otp
	 * @param otpValidity
	 */
	private boolean updateUserOtp(String mobile, String otp, String otpValidity) {
		try {
			UserMasterEntity user = userRepo.findByMobile(mobile);
			if (user != null) {
				user.setPassword(otp);
				user.setPwdValidity(LocalDateTime.parse(otpValidity));
				userRepo.save(user);
				return true;
			}
		} catch (Exception e) {
			logger.info("exception in updateUserOTP");
			return false;
		}
		return true;
	}

	public static Date getValidity(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, OTPVALIDITYSECS);
		return calendar.getTime();
	}

	@Override
	public CreateUpdateRespDto validateFormerOtp(String mobile, int leadId, String otp, String otpType,
			HttpSession session) {
		CreateUpdateRespDto resp = new CreateUpdateRespDto();
		FormerOtpHistoryEntity otpEntity = otpRepo.validateFormerOtp(leadId, mobile, otp, otpType);
		if (otpEntity == null) {
			resp.setStatusCode(1);
			resp.setMessage("OTP: '"+ otp +", is not valid. Please get the valid OTP from former or recheck the entered one ");
		}else {
			resp.setStatusCode(0);
			resp.setMessage("OTP: '"+ otp +"' validated successfully");
		}
		return resp;
	}

}
