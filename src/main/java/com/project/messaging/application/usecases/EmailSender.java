package com.project.messaging.application.usecases;

import com.project.messaging.adapters.EmailSenderGateway;
import com.project.messaging.core.usecases.EmailSenderUseCase;

public class EmailSender implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    public EmailSender (EmailSenderGateway emailGateway) {
        this.emailSenderGateway = emailGateway;
    }
    @Override
    public void send(String to, String subject, String body) {

    }
}
