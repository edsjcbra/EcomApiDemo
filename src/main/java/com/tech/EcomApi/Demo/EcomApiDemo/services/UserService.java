package com.tech.EcomApi.Demo.EcomApiDemo.services;

import com.tech.EcomApi.Demo.EcomApiDemo.entities.BillingAddressEntity;
import com.tech.EcomApi.Demo.EcomApiDemo.entities.UserEntity;
import com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos.CreateUserDto;
import com.tech.EcomApi.Demo.EcomApiDemo.repositories.BillingAddressRepository;
import com.tech.EcomApi.Demo.EcomApiDemo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository, BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.billingAddressRepository = billingAddressRepository;
    }


    public UserEntity createUser(CreateUserDto createUserDto) {

        var billingAddress = new BillingAddressEntity();
        billingAddress.setAddress(createUserDto.address());
        billingAddress.setNumber(createUserDto.number());
        billingAddress.setComplement(createUserDto.complement());

        // DTO -> ENTITY
        var user = new UserEntity();
        user.setFullName(createUserDto.fullName());
        user.setBillingAddress(billingAddress);

        return userRepository.save(user);
    }

    public Optional<UserEntity> getUserById(UUID userid) {

        return userRepository.findById(userid);
    }

    public boolean deleteUserById(UUID userId) {

        var user = userRepository.findById(userId);

        if(user.isPresent()){
            userRepository.deleteById(userId);
        }
        return user.isPresent();
    }
}
