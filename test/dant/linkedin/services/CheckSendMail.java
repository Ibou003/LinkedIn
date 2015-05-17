package dant.linkedin.services;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.junit.Before;
import org.junit.Test;

import dant.linkedin.utils.LinkedInCsts;

public class CheckSendMail {

	private List<String> dests;
	private String msg = null;
	private String obj = null;
	private String filePath = null;
	private String fileName = null;
	
	private final String inputPath = new File("").getAbsolutePath()+File.separator+"input"+File.separator;

	private final String username = LinkedInCsts.LINKEDIN_MAIL;
	private final String password = LinkedInCsts.LINKEDIN_PWD;
	
	@Before
	public void setUp(){
		dests = new ArrayList<String>();
		dests.add("ghansum@gmail.com");
		//dests.add("pol.patrick1411@gmail.com");
		msg = "Ceci est un test !";
		obj = "Envoie avec file";
		filePath = inputPath+"LinkedIn.pdf";
		fileName = "fileName";
	}

	@Test
	public void checkMailAttachment() throws EmailException{

		Mailing mailing = new Mailing();
		mailing.sendMailToAll(dests, msg, obj, null, fileName);

		EmailAttachment attachment = mailing.createAttachment(filePath, fileName);

		assertEquals(filePath, attachment.getPath());
		assertEquals(fileName, attachment.getName());

	}

	@Test
	public void checkCreateMail() throws EmailException{

		Mailing mailing = new Mailing();
		MultiPartEmail email = null;
		EmailAttachment attachment = mailing.createAttachment(filePath, fileName);
		for(String dest : dests){
			email = mailing.createMail(dest, obj, msg);
			if(attachment != null){
				email.attach(attachment);
			}
			email.send();
			assertEquals(obj, email.getSubject());
			
		}
	}

	@Test
	public void checkInboxMail(){
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
		try {
			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore("imaps");
			store.connect("imap.gmail.com",username, password);
			
			Folder[] folders = store.getDefaultFolder().list("*");
			for (javax.mail.Folder folder : folders) {
				if ((folder.getType() & javax.mail.Folder.HOLDS_MESSAGES) != 0) {
					System.out.println(folder.getFullName() + ": " + folder.getMessageCount());
				}
			}
			
//			Folder sendMail = store.getFolder("[Gmail]/Messages envoyés");
//			sendMail.open(Folder.READ_ONLY);
//			Message messages[] = sendMail.getMessages();
//			for (Message message : messages) {
//				//System.out.println(message.get());
//			}
			
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (MessagingException e) {
			e.printStackTrace();
			System.exit(2);
		}
	}



}
