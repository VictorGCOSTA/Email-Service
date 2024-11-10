package com.service.email_service.core.usecase;

import com.service.email_service.core.model.EmailForm;

public interface EmailSenderUseCase {
    void sendEmail(EmailForm emailForm);
}
