package com.tech.EcomApi.Demo.EcomApiDemo.entities;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_orderItem")
public class OrderItemEntity {

    @EmbeddedId
    private OrderItemId id;

    private BigDecimal salePrice;
    private Integer quantity;

    public OrderItemEntity() {
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderItemId getOrderItemId() {
        return id;
    }

    public void setOrderItemId(OrderItemId orderItemId) {
        this.id = orderItemId;
    }
}
