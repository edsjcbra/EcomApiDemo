package com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos;

import com.tech.EcomApi.Demo.EcomApiDemo.entities.OrderItemEntity;

import java.util.List;
import java.util.UUID;

public record CreateOrderDto(UUID userId,
                             List<OrderItemDto> orderItems) {
}
