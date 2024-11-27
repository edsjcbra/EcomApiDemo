package com.tech.EcomApi.Demo.EcomApiDemo.services;

import com.tech.EcomApi.Demo.EcomApiDemo.entities.BillingAddressEntity;
import com.tech.EcomApi.Demo.EcomApiDemo.entities.UserEntity;
import com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos.CreateUserDto;
import com.tech.EcomApi.Demo.EcomApiDemo.repositories.BillingAddressRepository;
import com.tech.EcomApi.Demo.EcomApiDemo.repositories.UserRepository;
import org.springframework.stereotype.Service;

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

       var savedBillingAddress = billingAddressRepository.save(billingAddress);

        // DTO -> ENTITY
        var user = new UserEntity();
        user.setFullName(createUserDto.fullName());
        user.setBillingAddress(savedBillingAddress);

        return userRepository.save(user);
    }
}
