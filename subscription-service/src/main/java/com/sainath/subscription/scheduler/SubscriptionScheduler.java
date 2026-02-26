package com.sainath.subscription.scheduler;

import com.sainath.subscription.dto.EmailRequest;
import com.sainath.subscription.dto.LogRequest;
import com.sainath.subscription.entity.UserSubscription;
import com.sainath.subscription.feign.EmailClient;
import com.sainath.subscription.feign.LogClient;
import com.sainath.subscription.repository.UserSubscriptionRepository;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionScheduler {

    private final UserSubscriptionRepository repository;
    private final EmailClient emailClient;
    private final LogClient logClient;

    public SubscriptionScheduler(UserSubscriptionRepository repository,
                                 EmailClient emailClient,
                                 LogClient logClient) {
        this.repository = repository;
        this.emailClient = emailClient;
        this.logClient = logClient;
    }

    @Scheduled(cron = "0 0 9 * * ?")
    public void checkSubscriptions() {
        List<UserSubscription> subscriptions = repository.findByStatus("ACTIVE");

        for (UserSubscription sub : subscriptions) {
            long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), sub.getExpiryDate());

            if (daysLeft == 3) {
                emailClient.sendEmail(new EmailRequest(
                        sub.getEmail(),
                        "Reminder",
                        "Your subscription expires in 3 days."
                ));

                logClient.saveLog(new LogRequest(sub.getEmail(), "REMINDER"));
            }
        }
    }
}
