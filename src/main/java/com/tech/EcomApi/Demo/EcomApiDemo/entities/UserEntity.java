package com.tech.EcomApi.Demo.EcomApiDemo.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String fullName;

    @OneToOne
    @JoinColumn(name = "billingAddress_Id")
    private BillingAddressEntity billingAddress;

    public UserEntity() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BillingAddressEntity getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddressEntity billingAddress) {
        this.billingAddress = billingAddress;
    }
}
