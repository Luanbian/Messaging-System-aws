package com.project.messaging.core.usecases;

public interface EmailSenderUseCase {
    void send(
            String to,
            String subject,
            String body
    );
}
