package com.isource.mail;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.isource.utility.PropertiesReader;

@Component
public class SendMail {

	private static final String MAIL_URL = PropertiesReader.getProperty("constant", "URL_FOR_MAIL");

	private Logger logger = null;

	public SendMail() {
		logger = Logger.getLogger(SendMail.class);
	}

	/**
	 * This method is used to Send DATA through calling web service. mailForClient
	 * 
	 * @author
	 * @return
	 */
	public boolean mailSend(String mailType, String jsoString) {
		boolean isLogoutDone = false;
		try {
			String WSUrl = MAIL_URL + mailType;
			URL url = new URL(WSUrl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setRequestProperty("Content-Type", "application/json");
			httpUrlConnection.setRequestProperty("Accept", "application/json");
			httpUrlConnection.setConnectTimeout(0);
			httpUrlConnection.setReadTimeout(0);
			httpUrlConnection.setDoOutput(true);
			                                                                 //returns the output Straem
			DataOutputStream wr = new DataOutputStream(httpUrlConnection.getOutputStream());
			wr.writeBytes(jsoString);
			wr.flush();
			wr.close();
			
			if (httpUrlConnection.getResponseCode() == 200) {
				httpUrlConnection.disconnect();
				logger.info("Mail Sent Successfully..");
				isLogoutDone = true;
			} 
			else {
				logger.info("Mail NOT Sent Refreshed...");
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Exception @callRefreshCacheDataWS inside GeneralDAO class :=>" + ex.getMessage());
		}
		return isLogoutDone;
	}
}
