package com.tech.EcomApi.Demo.EcomApiDemo.repositories;

import com.tech.EcomApi.Demo.EcomApiDemo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
