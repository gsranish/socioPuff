package com.sociopuff.controller;

import com.sociopuff.mail.service.EmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailOtpController {

    private static final Logger LOGGER = LogManager.getLogger(EmailOtpController.class);
    private final EmailService emailService;

    @Autowired
    public EmailOtpController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-email")
    public void sendEmail(@RequestParam String emailId) {
        LOGGER.info("EmailOtpController sendEmail api called ");

        emailService.sendEmail(emailId,null);
    }
}
