package com.example.job_service.model;

import lombok.*;
import com.example.job_service.enums.OfferStatus;
import jakarta.persistence.*;

@Entity(name = "offers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Offer extends BaseEntity {
    private String userId;
    private int offeredPrice;

    @Enumerated(EnumType.STRING)
    private OfferStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "advert_id")
    private Advert advert;
}