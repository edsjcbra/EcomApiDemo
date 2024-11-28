package com.tech.EcomApi.Demo.EcomApiDemo.controllers;

import com.tech.EcomApi.Demo.EcomApiDemo.entities.UserEntity;
import com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos.CreateUserDto;
import com.tech.EcomApi.Demo.EcomApiDemo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDto dto) {

        var user = userService.createUser(dto);

        return ResponseEntity.created(URI.create("/users/" + user.getUserId() )).build();
    }

    @GetMapping("/{userid}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("userid") UUID userId) {

        var user = userService.getUserById(userId);

        return  user.isPresent() ?
                ResponseEntity.ok(user.get()) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userid") UUID userId) {

        var deleted = userService.deleteUserById(userId);

        return  deleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
