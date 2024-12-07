package com.tech.EcomApi.Demo.EcomApiDemo.controllers;


import com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos.*;
import com.tech.EcomApi.Demo.EcomApiDemo.services.OrderService;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderDto dto) {

        var order = orderService.createOrder(dto);

        return ResponseEntity.created(URI.create("/orders/" + order.getOrderId())).build();
    }
    @GetMapping
    public ResponseEntity<ApiPageResponse<OrderSummaryDto>> getAllOrders(@RequestParam(name = "page", defaultValue = "0")Integer page,
                                                                         @RequestParam(name = "pageSize", defaultValue = "10")Integer pageSize) {
        var response = orderService.findAll(page, pageSize);

        return ResponseEntity.ok(new ApiPageResponse<>(
                response.getContent(),
                new PaginationResponse(response.getNumber(),
                                        response.getSize(),
                                        response.getTotalElements(),
                                        response.getTotalPages())
        ));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDto> getAllOrders(@PathVariable("orderId") Long orderId) {
        var response = orderService.findOrderById(orderId);

        return response.isPresent() ?
                ResponseEntity.ok(OrderResponseDto.fromEntity(response.get())) :
                ResponseEntity.notFound().build();
    }
}
