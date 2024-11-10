package com.service.email_service.controllers;

import com.service.email_service.core.model.EmailForm;
import com.service.email_service.core.usecase.EmailSenderUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {
    private final EmailSenderUseCase emailSenderUseCase;

    public EmailSenderController(EmailSenderUseCase emailSenderUseCase) {
        this.emailSenderUseCase = emailSenderUseCase;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailForm emailForm) {
        this.emailSenderUseCase.sendEmail(emailForm);
        return ResponseEntity.ok("Email sent successfully");
    }
}
