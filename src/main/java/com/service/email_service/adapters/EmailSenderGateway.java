package com.service.email_service.adapters;

import com.service.email_service.core.model.EmailForm;

public interface EmailSenderGateway {
    void sendEmail(EmailForm emailForm);
}
