package com.sainath.subscription.feign;

import com.sainath.subscription.dto.EmailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "EMAIL-SERVICE")
public interface EmailClient {

    @PostMapping("/email/send")
    void sendEmail(@RequestBody EmailRequest request);
}
