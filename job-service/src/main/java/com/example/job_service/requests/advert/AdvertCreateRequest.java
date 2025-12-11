package com.example.job_service.requests.advert;


import com.example.job_service.enums.Advertiser;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class AdvertCreateRequest {
    @NotBlank(message = "Advert name is required")
    private String name;
    private String description;
    @NotNull(message = "Delivery time is required")
    private int deliveryTime;
    @NotNull(message = "Price is required")
    private int price;
    @NotNull(message = "Advertiser is required")
    @Enumerated(EnumType.STRING)
    private Advertiser advertiser;
    @NotBlank(message = "User id is required")
    private String userId;
    @NotBlank(message = "Job id is required")
    private String jobId;
}