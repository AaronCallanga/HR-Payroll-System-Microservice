package com.hrps.notificationservice.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    /**
     * Sends a welcome email when a new employee is created.
     */
    public void sendWelcomeEmail(String to, String employeeName) {
        System.out.println("📧 Sent welcome email to: " + to);
        System.out.println("<UNK> Sent welcome email employee: " + employeeName);
    }
}
