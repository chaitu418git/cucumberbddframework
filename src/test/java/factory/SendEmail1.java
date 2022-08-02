package factory;

import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmail1 {
	//public static void main(String[] args) throws  EmailException
	public   void sendEmail() throws  EmailException
{
	System.out.println("Started");
	MultiPartEmail  email = new MultiPartEmail ();
	/*
	 * EmailAttachment attachment = new EmailAttachment(); attachment.setPath(
	 * "C:\\Users\\chaitanya.buddi\\eclipse-workspace\\Cucumberbdd\\target\\cucumber-report\\cucumber.html"
	 * ); attachment.setDisposition(EmailAttachment.ATTACHMENT);
	 * attachment.setDescription("Cucumber Report");
	 * attachment.setName("Automation Status Report");
	 */

	  email.setHostName("smtp.gmail.com");
	  email.setSmtpPort(465);
	  email.setAuthenticator(new DefaultAuthenticator("chaitanyabuddi123@gmail.com", "bvntopzvtusmsmln"));
	  email.setSSLOnConnect(true);
	  email.setFrom("Chaitanya@gmail.com");
	  email.setSubject("Automation Status Report");
	  email.addTo("chaitanyabuddi123@gmail.com");
	  
	  email.attach(new File("C:/Users/chaitanya.buddi/eclipse-workspace/Cucumberbdd/target/cucumber-report/cucumber.html"));
	  // embed the image and get the content id
	 /* URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
	  String cid = email.embed(url, "Apache logo");
	  
	  // set the html message
	  email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");

	  // set the alternative message
	  email.setTextMsg("Your email client does not support HTML messages");*/

	  // send the email
	  email.send();
	  System.out.println("Done");
}
}
