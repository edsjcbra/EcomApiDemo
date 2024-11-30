package com.tech.EcomApi.Demo.EcomApiDemo.services;

import com.tech.EcomApi.Demo.EcomApiDemo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
