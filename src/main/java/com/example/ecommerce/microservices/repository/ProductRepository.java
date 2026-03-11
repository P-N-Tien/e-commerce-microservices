package com.example.ecommerce.microservices.repository;

import com.example.ecommerce.microservices.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
//    boolean existsByName(String name);
}
