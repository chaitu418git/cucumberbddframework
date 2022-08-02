package factory;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
	
public static void sendEmail() throws EmailException
{
	
	System.out.println("Test Started");
//	EmailAttachment attachment=new EmailAttachment();
//	attachment.setPath(null);
	Email email = new SimpleEmail();
	email.setHostName("smtp.gmail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("chaitanyabuddi123@gmail.com", "bvntopzvtusmsmln"));
	email.setSSLOnConnect(true);
	email.setFrom("chaitanya@gmail.com");
	email.setSubject("Selenium Test Report");
	email.setMsg(System.getProperty("user.dir")+ "/target/cucumber.html");
	//email
	email.addTo("chaitu.090418@gmail.com");
	email.send();
	System.out.println("Test Done");
}
}
