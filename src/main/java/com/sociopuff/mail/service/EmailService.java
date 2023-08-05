package com.sociopuff.mail.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmailService {

    private static final Logger LOGGER = LogManager.getLogger(EmailService.class);
    private final JavaMailSender javaMailSender;
    private static final String SUBJECT = "RESET OTP";
    private static final String BODY = " HI ! \n" + "YOUR OTP IS ";

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String recipient,String body ) {
        LOGGER.info("EmailService : sendEmail method called ");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setSubject(SUBJECT);
        message.setText(Objects.requireNonNullElse(body, BODY));

        javaMailSender.send(message);
    }
}
