package com.example.ecommerce.microservices.controller;

import com.example.ecommerce.microservices.dto.ProductRequest;
import com.example.ecommerce.microservices.dto.ProductResponse;
import com.example.ecommerce.microservices.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest product) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.createProduct(product));
    }
}
