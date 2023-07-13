package com.isource.config.mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.isource.utility.PropertiesReader;

/**
 * This class is responsible for sending email functionality.
 */
public class SendMailUtility {

	private String subject;
	private Logger logger = null;

	public static String SMTP = PropertiesReader.getProperty("constant", "LIVE_MAIL_SERVER_SMTP");

	public static String USERNAME = PropertiesReader.getProperty("constant", "LIVE_MAIL_SERVER_USERNAME");

	public static String PASSWORD = PropertiesReader.getProperty("constant", "LIVE_MAIL_SERVER_PASSWORD");

	public static String PORT = PropertiesReader.getProperty("constant", "LIVE_MAIL_SERVER_SMTP_PORT");

	public static String AUTH = PropertiesReader.getProperty("constant", "LIVE_MAIL_SERVER_SMTP_AUTH");

	private static String MailSent = PropertiesReader.getProperty("constant", "MAIL_SENT");

	public SendMailUtility() {
		try {
			logger = Logger.getLogger(SendMailUtility.class);
			
		} catch (Exception ex) {
			logger.error("Error while creating logger object" + ex.toString());
		}
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public static boolean sendMail(String recipientEmailIds, String alternateCC, String fromEmailId, String subject,
			String body, boolean isHtml) {
		
		boolean responseStatus = false;
		
		try {
			// Get the System Property and setting important properties to props object
			Properties props = new Properties();
			props.put("mail.smtp.auth", AUTH);
			props.put("mail.smtp.host", SMTP);
			props.put("mail.smtp.port", PORT);

			// 1st step :get the session object
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				
				  protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(USERNAME, PASSWORD);  //internal method is there in passwordAuthentication.
				}
		    	});

			// 2nd Step: compose the message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmailId, "Tender247 Alert"));

			if (recipientEmailIds != null && recipientEmailIds.length() > 0)
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmailIds));
			
			if (alternateCC != null && alternateCC.trim().length() > 0)
				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(alternateCC));

			//setting subject
			message.setSubject(subject);

			body = body + unsubSendinBlueFooterHtml();
			
			if (isHtml)
				message.setContent(body, "text/html; charset=utf-8");
			else
				message.setText(body);

			
			if (MailSent.equalsIgnoreCase("TRUE"))
				
				// 3rd step send the message
				Transport.send(message);

			responseStatus = true;
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {

		}
		return responseStatus;
	}

	public static String unsubSendinBlueFooterHtml() {
		return """
				   <br /><br /><br />
				   <table border='0' cellpadding='0' cellspacing='0' width='100%' id='canspamBarWrapper' style='background-color:#FFFFFF; border-top:1px solid #E5E5E5;'>
				   <tr><td align='center' valign='top' style='padding-top:20px; padding-bottom:20px;'>
				   <table border='0' cellpadding='0' cellspacing='0' id='canspamBar'><tr><td align='center' valign='top' style='color:#606060; font-family:Helvetica, Arial, sans-serif; font-size:11px; line-height:150%; padding-right:20px; padding-bottom:5px; padding-left:20px; text-align:center;'>
				   <a href='[UNSUBSCRIBE]' target='_blank'>Unsubscribe from this list</a></td></tr></table></td></tr></table>
			   """;
	}

	public String getTemplateforForgotpassword(String password, String email) {
		String content = "";
		try {
			//InputStream Returns a new {@code InputStream} that reads no bytes.
			InputStream is = this.getClass().getClassLoader()
					.getResourceAsStream("com/isource/html/ForgotPassword.html");
			BufferedReader reader = new BufferedReader(new InputStreamReader(is)); // It reads bytes and decodes them into characters.
			                                                                       // reads text, using buffering to enable large reads at a time for efficiency.
			
			String line;
			StringBuilder contentBuilder = new StringBuilder();
			
			while ((line = reader.readLine()) != null) {
				contentBuilder.append(line);    // to append the characters.
			}
			
			content = contentBuilder.toString().trim();  
			content = content.replace("{Login_ID}", email);
			content = content.replace("{password}", password);
			
		    } 
		catch (IOException e) {
			System.out.println(
					"Exception @getBulkMainTemplate inside SendSampleMailCalculationDAO class :=>" + e.toString());
		}
		return content;
	}
}















