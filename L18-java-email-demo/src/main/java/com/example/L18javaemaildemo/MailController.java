package com.example.L18javaemaildemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private static Logger LOGGER = LoggerFactory.getLogger(MailController.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/sendEmail")
    ResponseEntity<String> sendEmail(@RequestBody SendEmailRequest request){


        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("jbdl.ewallet@gmail.com");
        simpleMailMessage.setSubject(request.getSubject());
        simpleMailMessage.setTo(request.getToEmail());
        simpleMailMessage.setText(request.getBody());
        simpleMailMessage.setCc(request.getCc());
        javaMailSender.send(simpleMailMessage);
        LOGGER.info("Send email to : {}",request.getToEmail());
        return ResponseEntity.ok("Sent");

    }
}
