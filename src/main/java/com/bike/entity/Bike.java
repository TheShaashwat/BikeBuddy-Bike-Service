package com.bike.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bikes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "registration_number", unique = true, nullable = false)
    private String registrationNumber;

    private String model;
    private String brand;

    @Column(name = "bike_type")
    private String bikeType;

    @Column(name = "year_of_manufacture")
    private Integer yearOfManufacture;

    private String color;
    private Integer cc;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "mileage_kmpl")
    private BigDecimal mileageKmpl;

    @Column(name = "hourly_rate", nullable = false)
    private BigDecimal hourlyRate;

    @Column(name = "daily_rate", nullable = false)
    private BigDecimal dailyRate;

    @Column(name = "weekly_rate")
    private BigDecimal weeklyRate;

    @Column(name = "monthly_rate")
    private BigDecimal monthlyRate;

    @Column(name = "security_deposit", nullable = false)
    private BigDecimal securityDeposit;

    @Column(name = "location_lat", nullable = false)
    private BigDecimal locationLat;

    @Column(name = "location_lng", nullable = false)
    private BigDecimal locationLng;

    private String address;
    private String city;
    private String state;

    private String status;

    @Column(name = "current_odometer")
    private Integer currentOdometer;

    @Column(name = "last_service_km")
    private Integer lastServiceKm;

    @Column(name = "next_service_km")
    private Integer nextServiceKm;

    @Column(name = "rc_number", unique = true, nullable = false)
    private String rcNumber;

    @Column(name = "rc_document_url")
    private String rcDocumentUrl;

    @Column(name = "insurance_number")
    private String insuranceNumber;

    @Column(name = "insurance_expiry")
    private LocalDate insuranceExpiry;

    @Column(name = "puc_expiry")
    private LocalDate pucExpiry;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (status == null) status = "AVAILABLE";
        if (isActive == null) isActive = true;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
