package com.sainath.subscription.feign;

import com.sainath.subscription.dto.LogRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "LOG-SERVICE")
public interface LogClient {

    @PostMapping("/log")
    void saveLog(@RequestBody LogRequest request);
}
