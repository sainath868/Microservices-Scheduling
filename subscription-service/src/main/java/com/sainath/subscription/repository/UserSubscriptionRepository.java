package com.sainath.subscription.repository;

import com.sainath.subscription.entity.UserSubscription;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Long> {

    List<UserSubscription> findByStatus(String status);
}
