package com.tech.EcomApi.Demo.EcomApiDemo.repositories;

import com.tech.EcomApi.Demo.EcomApiDemo.entities.BillingAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingAddressRepository extends JpaRepository<BillingAddressEntity, Long> {
}
