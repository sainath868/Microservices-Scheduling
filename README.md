# Distributed Subscription Renewal & Email Automation System

This repository contains a Spring Boot microservices architecture with Eureka, Gateway, Feign communication, scheduling, and MySQL persistence.

## Services

- `discovery-server` (port `8761`)
- `api-gateway` (port `8080`)
- `subscription-service` (port `8081`)
- `email-service` (port `8082`)
- `log-service` (port `8083`)

## Databases

Create the required MySQL schemas:

```sql
CREATE DATABASE subscription_db;
CREATE DATABASE email_db;
CREATE DATABASE log_db;
```

## Build all modules

```bash
mvn clean package
```

## Run order

1. Start `discovery-server`
2. Start `api-gateway`
3. Start `email-service`
4. Start `log-service`
5. Start `subscription-service`

## Notes

- Update datasource and SMTP credentials in each `application.yml`.
- `subscription-service` runs a daily scheduler at `09:00` and sends renewal reminders for subscriptions expiring in 3 days.
