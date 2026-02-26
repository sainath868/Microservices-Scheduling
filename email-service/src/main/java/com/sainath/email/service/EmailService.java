package com.sainath.email.service;

import com.sainath.email.dto.EmailRequest;
import com.sainath.email.entity.EmailHistory;
import com.sainath.email.repository.EmailHistoryRepository;
import java.time.LocalDateTime;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final EmailHistoryRepository repository;

    public EmailService(JavaMailSender mailSender, EmailHistoryRepository repository) {
        this.mailSender = mailSender;
        this.repository = repository;
    }

    public void send(EmailRequest request) {
        EmailHistory history = new EmailHistory();
        history.setRecipient(request.getRecipient());
        history.setSubject(request.getSubject());
        history.setSentTime(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(request.getRecipient());
            message.setSubject(request.getSubject());
            message.setText(request.getBody());
            mailSender.send(message);
            history.setStatus("SENT");
        } catch (Exception exception) {
            history.setStatus("FAILED");
        }

        repository.save(history);
    }
}
