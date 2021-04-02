/**
 * 
 */
package com.mahindra.epcfrm.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindra.epcfrm.entity.ApiResponseDto;

/**
 * @author Raju.Addu
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private SMSService smsService;

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	private static Random random = new Random();
	public static final int otpValiditySecs = 120;
	private static final DateFormat df = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

	@Override
	public ApiResponseDto getOtp(String tokenId) {
		long curMillis = System.currentTimeMillis();
		logger.info("inside sendOtp() for tokenId: " + tokenId);
		if (tokenId == null || tokenId.isEmpty()) {
			logger.info("Empty tokenId provided, returning..");
			return new ApiResponseDto("fail", tokenId, null, "Provide mandatory fields");
		}
		//Map<String, String> empDetails = getEmpDetailsByTokenId(tokenId);

//		if (empDetails == null || empDetails.isEmpty() || empDetails.get("commonName") == null) {
//			logger.info("No account found with Token No. : " + tokenId);
//			return new ApiResponseDto("fail", tokenId, null, "No account found with Token No. : " + tokenId);
//		}
		String mobile = tokenId; // getEmpMobile(tokenId);
		//logger.info("Employee details fetched from ldap for tokenId \"" + tokenId + "\", details: " + empDetails);
		String status = "";
		String message = "";
		String otpValidity = "";
		String otp = "";
		int mobLen = 0;

//		if (empDetails != null && !empDetails.isEmpty())
//			mobile = empDetails.get("mobile") == null ? empDetails.get("telephoneNumber") : empDetails.get("mobile");

		if (mobile != null && !mobile.isEmpty()) {
			logger.info("Generating OTP and sending to Mobile No. " + mobile);
			mobLen = mobile.length();

			try {
				otp = "" + (10000 + random.nextInt(90000));
				logger.info("Generated OTP: " + otp);
				//empDetails.put("otp", otp);
				Date now = new Date();
				//empDetails.put("entryTime", String.valueOf(now.getTime()));
				//empDetailsByTokenId.put(tokenId, empDetails);
//				otpByTokenId.put(tokenId, now.getTime() + "-" + otp);
				otpValidity = df.format(getValidity(now));
				String sms = otp + " is the OTP to reset your Mahindra login id password, valid till " + otpValidity;
				try {
					if (smsService.sendSMS(mobile, sms)) {
						logger.info("OTP sent successfully to Mobile No. " + mobile + ", with SMS text: " + sms);
						status = "success";
						message = "OTP is sent to Mobile No. ending with XXXX" + mobile.substring(mobLen - 3, mobLen);
					} else {
						logger.info("Failed to send OTP on Mobile No. " + mobile + ", with SMS text: " + sms);
						status = "fail";
						message = "Failed to sent OTP to Mobile No. ending with XXXX"
								+ mobile.substring(mobLen - 3, mobLen);
					}
				} catch (Exception e) {
					logger.error("Exception in SMSService.sendSms(), details: " + e.getMessage() + ", trace: ", e);
					status = "fail";
					message = "Failed to sent OTP to Mobile No. ending with XXXX"
							+ mobile.substring(mobLen - 3, mobLen);
				}

//				setCertificates();
//				HttpSession session = request.getSession();
//				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyyhh:mm:ss");
//				String str = sdf.format(new Date());
//				session.setAttribute("time", str);
//				setCertificates();
//				URL url = new URL("https://172.16.90.71/otp?username=mitc_otp&password=auML-38_&dest=91" + mobile + "&from=MNMOTP&sendToDest=1&template=Your%20OTP%20is%20%3C%3COTP%3E%3E");
//				URLConnection con = url.openConnection();
//				Reader reader = new InputStreamReader(con.getInputStream());
//				while (true) {
//					int ch = reader.read();
//					if (ch == -1) {
//						break;
//					}
//				}
//				status = "success";
//				message = "Otp sent successfuly on mobile number '" + mobile + "'";
			} catch (Exception e) {
				logger.error("Exception while sending opt to mobile \"" + mobile + "\", details: " + e.getMessage()
						+ ", trace: ", e);
				status = "fail";
				message = "Failed to sent OTP to Mobile No. ending with XXXX" + mobile.substring(mobLen - 3, mobLen);
			}
		} else {
			logger.info("Mobile No not maintained in AD for tokenId: " + tokenId);
			status = "fail";
			message = "Mobile No. for token '" + tokenId
					+ "' is not maintained, please write to MITC-REQUEST@mahindra.com";
		}
		if (mobile == null) {
			mobile = "XXXX";
			mobLen = 3;
		}
		ApiResponseDto responseDto = new ApiResponseDto(status, tokenId, "XXXX" + mobile.substring(mobLen - 3, mobLen),
				otp, otpValiditySecs + " sec", message);
		logger.info("Returing resonse: " + responseDto);
		logger.info("Time taken by sendOtp() including getEmpDetailsByTokenId() and SMSService calls in millis: "
				+ (System.currentTimeMillis() - curMillis));
		return responseDto;
//		return new ApiResponseDto(status, tokenId, mobile, message);
	}

	public static Date getValidity(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, otpValiditySecs);
		return calendar.getTime();
	}

}
