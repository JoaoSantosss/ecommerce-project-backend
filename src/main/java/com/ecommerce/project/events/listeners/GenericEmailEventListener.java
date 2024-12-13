package com.ecommerce.project.events.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.ecommerce.project.events.GenericEmailEvent;

@Component
public class GenericEmailEventListener {
	
	@Value("${spring.mail.username}")
	private String senderEmail;
	
	@Autowired
    private JavaMailSender mailSender;

    @EventListener
    public void handleEmailEvent(GenericEmailEvent event) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderEmail);
        message.setTo(event.getEmail());
        message.setSubject(event.getSubject());
        message.setText(event.getParagraph());

        mailSender.send(message);
        System.out.println("Email sent to " + event.getEmail());
    }

}
