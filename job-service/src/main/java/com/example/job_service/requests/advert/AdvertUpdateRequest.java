package com.example.job_service.requests.advert;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import com.example.job_service.enums.AdvertStatus;

@Data
public class AdvertUpdateRequest {
    @NotBlank(message = "Advert id is required")
    private String id;
    private String name;
    private String description;
    private int deliveryTime;
    private int price;
    private AdvertStatus status;
}