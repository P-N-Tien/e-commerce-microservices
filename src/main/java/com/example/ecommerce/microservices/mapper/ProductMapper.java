package com.example.ecommerce.microservices.mapper;

import com.example.ecommerce.microservices.dto.ProductRequest;
import com.example.ecommerce.microservices.dto.ProductResponse;
import com.example.ecommerce.microservices.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductRequest productRequest);

    ProductResponse toResponse(Product product);
}
