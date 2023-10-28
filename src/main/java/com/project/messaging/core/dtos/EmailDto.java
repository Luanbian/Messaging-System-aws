package com.project.messaging.core.dtos;

public record EmailDto(
        String to,
        String subject,
        String body
) {}
