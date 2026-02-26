package com.sainath.subscription.service;

import com.sainath.subscription.entity.UserSubscription;
import com.sainath.subscription.repository.UserSubscriptionRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    private final UserSubscriptionRepository repository;

    public SubscriptionService(UserSubscriptionRepository repository) {
        this.repository = repository;
    }

    public UserSubscription save(UserSubscription subscription) {
        return repository.save(subscription);
    }

    public List<UserSubscription> findAll() {
        return repository.findAll();
    }
}
