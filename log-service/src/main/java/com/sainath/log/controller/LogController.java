package com.sainath.log.controller;

import com.sainath.log.dto.LogRequest;
import com.sainath.log.entity.EmailLog;
import com.sainath.log.repository.EmailLogRepository;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    private final EmailLogRepository repository;

    public LogController(EmailLogRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void save(@RequestBody LogRequest request) {
        EmailLog log = new EmailLog();
        log.setEmail(request.getEmail());
        log.setType(request.getType());
        log.setSentTime(LocalDateTime.now());

        repository.save(log);
    }
}
