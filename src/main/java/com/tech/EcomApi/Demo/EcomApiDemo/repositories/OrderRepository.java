package com.tech.EcomApi.Demo.EcomApiDemo.repositories;

import com.tech.EcomApi.Demo.EcomApiDemo.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
