package com.project.messaging.presentation.controllers;

import com.project.messaging.application.usecases.EmailSender;
import com.project.messaging.core.dtos.EmailDto;
import com.project.messaging.core.usecases.exceptions.EmailSenderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    private final EmailSender emailSender;
    @Autowired
    public EmailController (EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @PostMapping()
    public ResponseEntity<String> send(@RequestBody EmailDto data) {
        try {
            this.emailSender.send(data.to(), data.subject(), data.body());
            return ResponseEntity.ok("email sent successfully");
        } catch (EmailSenderException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
        }
    }
}
