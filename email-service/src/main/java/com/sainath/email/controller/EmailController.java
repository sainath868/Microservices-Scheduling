package com.sainath.email.controller;

import com.sainath.email.dto.EmailRequest;
import com.sainath.email.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService service;

    public EmailController(EmailService service) {
        this.service = service;
    }

    @PostMapping("/send")
    public String send(@RequestBody EmailRequest request) {
        service.send(request);
        return "Email Sent";
    }
}
