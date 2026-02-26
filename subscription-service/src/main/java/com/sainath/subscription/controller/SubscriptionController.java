package com.sainath.subscription.controller;

import com.sainath.subscription.entity.UserSubscription;
import com.sainath.subscription.service.SubscriptionService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @PostMapping
    public UserSubscription create(@RequestBody UserSubscription subscription) {
        return service.save(subscription);
    }

    @GetMapping
    public List<UserSubscription> list() {
        return service.findAll();
    }
}
