package com.project.messaging.presentation.controllers;

import com.project.messaging.application.usecases.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
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
        this.emailSender.send();
    }
}
