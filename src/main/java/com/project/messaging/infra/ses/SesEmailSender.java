package com.project.messaging.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.project.messaging.adapters.EmailSenderGateway;
import com.project.messaging.core.exceptions.EmailSenderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {
    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Value(value = "${from}")
    private String from;

    @Autowired
    public SesEmailSender (AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }
    @Override
    public void sendMail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource(from)
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                );
        try {
            this.amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonServiceException exception) {
            throw new EmailSenderException("Failure while sending email", exception);
        }
    }
}
