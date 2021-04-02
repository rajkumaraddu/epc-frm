/**
 * 
 */
package com.mahindra.epcfrm.service;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author Raju.Addu
 *
 */
@Service
public class SMSService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SMSService.class);
//	ExecutorService mConnectorPool = Executors.newCachedThreadPool();
//	ExecutorService netcorePool = Executors.newCachedThreadPool();
	
	public boolean sendSMS(String mobileNo, String sms) {
		LOGGER.info("Sending sms to mobileNo \"" + mobileNo + "\", text: " + sms);
		if(sendSMSViaMahindraSMS(mobileNo, sms)) {
			LOGGER.info("SMS sent successfuly to mobileNo \"" + mobileNo + "\", text: " + sms);
			return true;
		} else {
			LOGGER.info("Could Not Send the otp through \"mConnector\" service");
			return false;
		}
		
//		Future<Boolean> netcoreResult = null;	//netcorePool.submit(new SMSSenderNetcore(mobileNo, sms));
//		Future<Boolean> mConnectorResult = mConnectorPool.submit(new SMSSender(mobileNo, sms));;
//		boolean netcoreSend = false;
//		boolean mConnectorSend = false;
//		
//		//	wait 2 sec
//		try { TimeUnit.SECONDS.sleep(2);}
//		catch (InterruptedException e) { }
//		
//		if(mConnectorResult.isDone()) {
//			try { mConnectorSend =  mConnectorResult.get(); }
//			catch (Exception e) { LOGGER.error("SMS sending thread execution error: " + e.getMessage()); }
//		}
//		if(mConnectorSend) {
//			LOGGER.info("SMS sent successfuly to mobileNo \"" + mobileNo + "\", text: " + sms);
//			return true;
//		}
//		
//		LOGGER.info("Could Not Send the otp in 5 sec through \"mConnector\" service, trying to send through \"netcore\" service");
//		netcoreResult = netcorePool.submit(new SMSSenderNetcore(mobileNo, sms));
//		
//		//	wait 2 sec
//		try { TimeUnit.SECONDS.sleep(2);}
//		catch (InterruptedException e) { }
//		
//		if(netcoreResult.isDone()) {
//			try { netcoreSend =  netcoreResult.get(); }
//			catch (Exception e) { LOGGER.error("SMS sending thread execution error: " + e.getMessage()); }
//		}
//		if(mConnectorResult.isDone()) {
//			try { mConnectorSend = mConnectorResult.get(); } 
//			catch (Exception e) { LOGGER.error("SMS sending thread execution error: " + e.getMessage()); }
//		}
//		if(netcoreSend || mConnectorSend) {
//			LOGGER.info("SMS sent successfuly to mobileNo \"" + mobileNo + "\", text: " + sms);
//			return true;
//		}
//		LOGGER.info("Could Not Send the otp through both services in 4 sec, considering the sending is failed.");
//		
//		return false;
	}
	
	private static boolean sendSMSViaMahindraSMS(String mobileNo, String sms) {
		long curMillis = System.currentTimeMillis();
		boolean isSmsSent = false;
		try {
			System.getProperties().put("http.proxyHost", "10.2.152.4");
			System.getProperties().put("http.proxyPort", "80");

			Authenticator.setDefault(new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("mahindra\\coeconsultant3", "mahindra@123".toCharArray());
				}
			});

			String title = "MAHINDRA_RETIRED";
			String title2 = "MAHINDRA_RETIRED";
			title2 = URLEncoder.encode(title2, "utf-8");
			title = URLEncoder.encode(title, "utf-8");
			mobileNo = URLEncoder.encode(mobileNo, "utf-8");
			sms = URLEncoder.encode(sms, "utf-8");
			String resourceUrl = "http://mahindrasms.com:8080/mConnector/dispatchapi?cname=" + title + "&tname=" + title
					+ "&login=" + title2 + "&to=" + mobileNo + "&text=" + sms;

			LOGGER.info("sending through \"mahindrasms.com mConnecor\" sms service=");
			Client client = Client.create();
			WebResource webResource = client.resource(resourceUrl);
			ClientResponse response = webResource.get(ClientResponse.class);

			if (response.getStatus() != 200)
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());

			String output = response.getEntity(String.class);
			LOGGER.info("SMS Service Response: " + output);
			if (output.startsWith("SUCCESS")) {
				LOGGER.info("OTP SUCCESSFULLY SENT To: " + mobileNo);
				isSmsSent = true;
			}else {
				LOGGER.info("failed to send sms");
				isSmsSent = false;
			}
		} catch (Exception e) {
			LOGGER.error("Error while sending message through \"mConnector\" sms service, details: " + e.getMessage() + ", trace", e);
			isSmsSent = false;
		}
		LOGGER.debug("\"mConnector\" service end");
		LOGGER.info("Time taken by sendSMS() vid mConnector's MAHINDRA_RETIRED SMS service in millis: " + (System.currentTimeMillis() - curMillis));
		return isSmsSent;
	
	}
	
	private static boolean sendSMSViaEPAlert(String mobileNo, String sms) {
		long curMillis = System.currentTimeMillis();
		boolean isSmsSent = false;
		try {
//			System.getProperties().put("http.proxyHost", "10.2.152.4");
//			System.getProperties().put("http.proxyPort", "80");
//
//			Authenticator.setDefault(new Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication("mahindra\\coeconsultant3", "mahindra@123".toCharArray());
//				}
//			});

			String cname = "EPAlert";
			String tname = "EPAlert";
			String login = "mConnector";
			login = URLEncoder.encode(login, "utf-8");
			cname = URLEncoder.encode(cname, "utf-8");
			mobileNo = URLEncoder.encode(mobileNo, "utf-8");
			sms = URLEncoder.encode(sms, "utf-8");
			String resourceUrl = "http://mahindrasms.com:8080/mConnector/dispatchapi?cname=" + cname + "&tname=" + tname
					+ "&login=" + login + "&to=" + mobileNo + "&text=" + sms;

			LOGGER.info("sending through \"mahindrasms.com EPAlert\" sms service=");
			Client client = Client.create();
			WebResource webResource = client.resource(resourceUrl);
			ClientResponse response = webResource.get(ClientResponse.class);

			if (response.getStatus() != 200)
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());

			String output = response.getEntity(String.class);
			LOGGER.info("SMS Service Response: " + output);
			if (output.startsWith("SUCCESS")) {
				LOGGER.info("OTP SUCCESSFULLY SENT To: " + mobileNo);
				isSmsSent = true;
			}else {
				LOGGER.info("failed to send sms");
				isSmsSent = false;
			}
		} catch (Exception e) {
			LOGGER.error("Error while sending message through \"mConnector\" sms service, details: " + e.getMessage() + ", trace", e);
			isSmsSent = false;
		}
		LOGGER.debug("\"mConnector\" service end");
		LOGGER.info("Time taken by sendSMS() vid mConnector's EPAlert SMS service in millis: " + (System.currentTimeMillis() - curMillis));
		return isSmsSent;
	
	}


}
