package com.tech.EcomApi.Demo.EcomApiDemo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_billingAddresses")
public class BillingAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billingAddressId;

    private String address;
    private String number;
    private String complement;

    @OneToOne(mappedBy = "billingAddress")
    private UserEntity user;


    public BillingAddressEntity() {
    }

    public Long getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Long billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
