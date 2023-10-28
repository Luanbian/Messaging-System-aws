package com.project.messaging.adapters;

public interface EmailSenderGateway {
    void sendMail (
            String to,
            String subject,
            String body
    );
}
