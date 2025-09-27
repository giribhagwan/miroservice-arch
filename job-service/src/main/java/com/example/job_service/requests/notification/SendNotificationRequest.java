package com.example.job_service.requests.notification;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendNotificationRequest {
    private String userId;
    private String offerId;
    private String message;
}