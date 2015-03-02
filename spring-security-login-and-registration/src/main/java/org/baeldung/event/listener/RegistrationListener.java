package org.baeldung.event.listener;


import org.baeldung.event.OnRegistrationCompleteEvent;
import org.baeldung.persistence.model.User;
import org.baeldung.persistence.service.IUserService;
import org.baeldung.validation.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class RegistrationListener  {
	@Autowired
    private IUserService service;

    @Autowired
    private MessageSource messages;

    @Autowired
    private JavaMailSender mailSender;


    public void confirmRegistration(OnRegistrationCompleteEvent event) {
        User user = event.getUser();        
        String recipientAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl = event.getAppUrl();     
        MailService MS = new MailService(recipientAddress, "You registered successfully. We will send you a confirmation message to your email account." + " \r\n" + "http://xocdia123.com" + confirmationUrl, subject);
        MS.start();
        
        
    }
}
