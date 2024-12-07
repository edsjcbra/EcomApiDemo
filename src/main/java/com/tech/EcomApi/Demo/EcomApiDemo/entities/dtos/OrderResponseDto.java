package com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos;

import com.tech.EcomApi.Demo.EcomApiDemo.entities.OrderEntity;
import com.tech.EcomApi.Demo.EcomApiDemo.entities.OrderItemEntity;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderResponseDto(Long orderId,
                               BigDecimal total,
                               UUID userId,
                               String username,
                               List<OrderItemResponseDto> items) {


    public static OrderResponseDto fromEntity(OrderEntity entity) {
        return new OrderResponseDto(
                entity.getOrderId(),
                entity.getTotal(),
                entity.getUser().getUserId(),
                entity.getUser().getFullName(),
                getItems(entity.getItems())
        );
    }

    private static List<OrderItemResponseDto> getItems(List<OrderItemEntity> items) {

        return items.stream()
                .map(OrderItemResponseDto::fromEntity).toList();
    }
}
