package com.example.job_service.repository;

import com.example.job_service.model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.job_service.enums.Advertiser;

import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, String> {
    List<Advert> getAdvertsByUserIdAndAdvertiser(String id, Advertiser advertiser);
}