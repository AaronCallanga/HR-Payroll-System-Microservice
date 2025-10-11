package com.hrps.notificationservice.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Sends a simple plain-text email.
     *
     * @param to recipient email address
     * @param subject email subject
     * @param body message content
     */
    public void sendEmail(String to, String subject, String body) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true); // true = HTML email
            helper.setFrom("hr@yourcompany.com"); // optional but recommended
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email to " + to, e);
        } finally {
            log.info("Email sent to {}", to);
            log.info("Email body: {}", body);
        }
    }

    /**
     * Sends a simple welcome email to a newly created employee.
     *
     * @param recipientEmail email of the new employee
     * @param employeeName name of the new employee
     */
    public void sendWelcomeEmail(String recipientEmail, String employeeName) {
        String subject = "🎉 Welcome to the Company!";
        String body = String.format("""
                <p>Hi <b>%s</b>,</p>
                <p>Welcome to our company! We’re thrilled to have you on board.</p>
                <p>If you have any questions, feel free to reach out to HR anytime.</p>
                <br>
                <p>Best regards,<br><b>HR Team</b></p>
                """, employeeName);

        sendEmail(recipientEmail, subject, body);
    }
}
