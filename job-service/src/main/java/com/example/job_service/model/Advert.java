package com.example.job_service.model;


import lombok.*;

import jakarta.persistence.*;
import java.util.List;
import com.example.job_service.enums.AdvertStatus;
import com.example.job_service.enums.Advertiser;

@Entity(name = "adverts")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Advert extends BaseEntity {
    private String userId;
    private String name;
    private String description;
    private int deliveryTime;
    private int price;
    private String imageId;

    @Enumerated(EnumType.STRING)
    private AdvertStatus status;

    @Enumerated(EnumType.STRING)
    private Advertiser advertiser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id")
    private Job job;

    @OneToMany(mappedBy = "advert", cascade = CascadeType.ALL)
    private List<Offer> offers;
}