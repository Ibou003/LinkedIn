package dant.linkedin.services;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class Mailing {

	private final String username = "linkedinDant@gmail.com";
	private final String password = "linkedindantupmc";

	public Mailing() {

	}

	public void sendMailToAll(List<String> dests, String msg, String obj, String filePath, String fileName) throws EmailException{

		EmailAttachment attachment = null;
		if(filePath != null){
			attachment = createAttachment(filePath, fileName);
		}
		MultiPartEmail email = null;
		for(String dest : dests){
			email = createMail(dest, obj, msg);
			if(attachment != null){
				email.attach(attachment);
			}
			email.send();
		}
	}

	public EmailAttachment createAttachment(String path, String name){
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(path);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setName(name);

		return attachment;
	}

	public MultiPartEmail createMail(String dest, String obj, String msg) throws EmailException {

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(username, password));
		email.setSSLOnConnect(true);
		email.setFrom(username);
		email.setSubject(obj);
		email.setMsg(msg);
		email.addTo(dest);

		return email;
	}



}