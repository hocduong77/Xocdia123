package org.baeldung.validation.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService implements Runnable  {
private Thread t;

private String to;
private String content;
private String title;

public MailService(String to, String content, String title){
	this.to= to;
	this.content = content;
	this.title = title;
}
public void run() {
	sendMail(to,content, title);
	
}
	public void sendMail(String to, String content, String title){
		
		String from = "xocdia123.sg@gmail.com";
		String password = "chienthan";
		String[] tos = {to};
		String googleHost = "smtp.gmail.com";
		String googlePort = "587";
		
		Properties props = System.getProperties();
		props.put("mail.smtp.host", googleHost);
		props.put("mail.smtp.port", googlePort);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		Session session = Session.getDefaultInstance(props);
		
		MimeMessage msg = new MimeMessage(session);
		
		try {
			msg.setFrom(new InternetAddress(from));
			
			for (int i = 0; i < tos.length; i++) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(tos[i]));
			}
			
			msg.setText(content);
			msg.setSubject(title);
			
			Transport transport = session.getTransport("smtp");
			transport.connect(googleHost, from, password);
			
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	 public void start ()
	   {
	      if (t == null)
	      {
	         t = new Thread (this, "email");
	         t.start ();
	      }
	   }
	
}
