package com.tech.EcomApi.Demo.EcomApiDemo.repositories;

import com.tech.EcomApi.Demo.EcomApiDemo.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
