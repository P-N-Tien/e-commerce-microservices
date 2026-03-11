package com.example.ecommerce.microservices.service;

import com.example.ecommerce.microservices.dto.ProductRequest;
import com.example.ecommerce.microservices.dto.ProductResponse;

public interface ProductService {
    ProductResponse createProduct(ProductRequest product);
}
