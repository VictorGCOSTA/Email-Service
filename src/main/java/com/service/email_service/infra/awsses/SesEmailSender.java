package com.service.email_service.infra.awsses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.service.email_service.adapters.EmailSenderGateway;
import com.service.email_service.core.exceptions.EmailServiceException;
import com.service.email_service.core.model.EmailForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Value("${aws.email}")
    private String awsEmail;

    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(EmailForm emailForm) {
        try {
            SendEmailRequest emailRequest = createEmailRequest(emailForm);
            amazonSimpleEmailService.sendEmail(emailRequest);
        } catch (AmazonServiceException e) {
            throw new EmailServiceException(e);
        }

    }

    private SendEmailRequest createEmailRequest(EmailForm emailForm) {
        return new SendEmailRequest()
                .withDestination(new Destination().withToAddresses(emailForm.to()))
                .withMessage(new Message()
                        .withSubject(new Content(emailForm.subject()))
                        .withBody( new Body().withText(new Content(emailForm.body()))))
                .withSource(awsEmail);
    }
}
