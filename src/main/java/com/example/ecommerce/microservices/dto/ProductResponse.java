package com.example.ecommerce.microservices.dto;

public record ProductResponse(
        String id,
        String name,
        String description,
        String price) {
}
