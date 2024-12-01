package com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderSummaryDto(Long orderId,
                              LocalDateTime orderDate,
                              String userName,
                              BigDecimal orderTotal) {
}
