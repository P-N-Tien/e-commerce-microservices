package com.example.ecommerce.microservices.service;

import com.example.ecommerce.microservices.dto.ProductRequest;
import com.example.ecommerce.microservices.dto.ProductResponse;
import com.example.ecommerce.microservices.mapper.ProductMapper;
import com.example.ecommerce.microservices.model.Product;
import com.example.ecommerce.microservices.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductResponse createProduct(ProductRequest request) {

        // 1. Validation
        validateProductRequest(request);
//        validateDuplicateProduct(request.name());

        // 2. Map the request DTO to the Product entity
        Product product = Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();

        // 3. Save to the database
        Product savedProduct = productRepository.save(product);

        log.info("[PRODUCT][CREATE] Saved product {}", savedProduct);

        // 4. Return Response
        return productMapper.toResponse(savedProduct);
    }

    private void validateProductRequest(ProductRequest request) {
        // Corrected logic: Throw exception if the request is INVALID
        if (request == null || request.name() == null || request.name().isBlank()) {
            throw new IllegalArgumentException("Product name is required.");
        }
        if (request.price() == null || request.price().doubleValue() <= 0) {
            throw new IllegalArgumentException("Product price must be greater than zero.");
        }
    }

    private void validateDuplicateProduct(String name) {
//        if (productRepository.existsByName(name)) {
//            throw new IllegalArgumentException("Product with name '" + name + "' already exists.");
//        }
    }
}
