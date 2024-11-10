package com.service.email_service.application;

import com.service.email_service.adapters.EmailSenderGateway;
import com.service.email_service.core.model.EmailForm;
import com.service.email_service.core.usecase.EmailSenderUseCase;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    public EmailSenderService(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }
    @Override
    public void sendEmail(EmailForm emailForm) {
        this.emailSenderGateway.sendEmail(emailForm);
    }
}
