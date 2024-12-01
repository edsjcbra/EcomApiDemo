package com.tech.EcomApi.Demo.EcomApiDemo.services;

import com.tech.EcomApi.Demo.EcomApiDemo.entities.*;
import com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos.CreateOrderDto;
import com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos.CustomErrorHandling;
import com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos.OrderItemDto;
import com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos.OrderSummaryDto;
import com.tech.EcomApi.Demo.EcomApiDemo.repositories.OrderRepository;
import com.tech.EcomApi.Demo.EcomApiDemo.repositories.ProductRepository;
import com.tech.EcomApi.Demo.EcomApiDemo.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public OrderEntity createOrder(CreateOrderDto dto) {

        var order = new OrderEntity();

        // 1. Validate user
        var user = validateUser(dto.userId());
        // 2. Validate Order Items
        var saleItems = validateItems(order, dto);
        // 3. Calculate Total
        var total = calculateOrderTotal(saleItems);
        // 3. Set values and save

        order.setOrderDate(LocalDateTime.now());
        order.setUser(user);
        order.setItems(saleItems);
        order.setTotal(total);

        return orderRepository.save(order);
    }

    private BigDecimal calculateOrderTotal(List<OrderItemEntity> saleItems) {

        return saleItems.stream()
                .map(i -> i.getSalePrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private UserEntity validateUser(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new CustomErrorHandling("User not found"));
    }
    private ProductEntity validateProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new CustomErrorHandling("Product not found"));
    }


    private List<OrderItemEntity> validateItems(OrderEntity order, CreateOrderDto dto) {
        if (dto.orderItems().isEmpty()) {
            throw new CustomErrorHandling("Order items not found");
        }

        return dto.orderItems()
                .stream()
                .map(orderItemDto -> getItems(order, orderItemDto))
                .toList();
    }

    private OrderItemEntity getItems(OrderEntity order, OrderItemDto orderItemDto) {

        var orderItem = new OrderItemEntity();
        var id = new OrderItemId();

        var productId = validateProduct(orderItemDto.productId());

        id.setProduct(productId);
        id.setOrder(order);

        orderItem.setOrderItemId(id);
        orderItem.setQuantity(orderItemDto.quantity());
        orderItem.setSalePrice(productId.getProductPrice());

        return orderItem;
    }

    public Page<OrderSummaryDto> findAll(Integer page, Integer pageSize) {

        return orderRepository.findAll(PageRequest.of(page, pageSize))
                .map(entity -> new OrderSummaryDto(
                        entity.getOrderId(),
                        entity.getOrderDate(),
                        entity.getUser().getFullName(),
                        entity.getTotal()
                ) );

    }
}
