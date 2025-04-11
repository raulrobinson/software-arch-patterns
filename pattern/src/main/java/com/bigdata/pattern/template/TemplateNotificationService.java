package com.bigdata.pattern.template;

import org.springframework.stereotype.Service;

@Service
public class TemplateNotificationService {

    private final EmailNotification emailNotification;
    private final SmsNotification smsNotification;

    public TemplateNotificationService(EmailNotification emailNotification, SmsNotification smsNotification) {
        this.emailNotification = emailNotification;
        this.smsNotification = smsNotification;
    }

    public void sendEmail(String to, String msg) {
        emailNotification.sendNotification(to, msg);
    }

    public void sendSms(String to, String msg) {
        smsNotification.sendNotification(to, msg);
    }
}
