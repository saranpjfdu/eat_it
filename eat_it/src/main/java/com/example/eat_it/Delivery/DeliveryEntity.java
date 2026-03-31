package com.example.eat_it.Delivery;

import jakarta.persistence.*;
import lombok.Data;

public class DeliveryEntity {
    @Entity
    @Table(name = "deliveries")
    @Data
    public class Delivery {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String orderId; // Links to the main Order Entity
        private Long customerId;
        private Long restaurantId;
        private Long riderId;

        @Enumerated(EnumType.STRING)
        private DeliveryStatus status; // ONLINE, WAITING_FOR_PICKUP, PICKED_UP, DELIVERED

        private Double currentLat;
        private Double currentLng;
        private String otp; // For secure handoff between Owner and Rider
    }

    enum DeliveryStatus {
        ONLINE, WAITING_FOR_PICKUP, PICKED_UP, DELIVERED, OFFLINE
    }
}
