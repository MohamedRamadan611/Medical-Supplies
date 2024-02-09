package com.MedicalSuppliesSystem.MedicalSupplies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @Column(name="customerId")
    private BigInteger customerId;

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;

    @Column(name="customer_name")
    private String customerName;

    public Customer(BigInteger customerId, String phone, String address, String customerName) {
        this.customerId = customerId;
        this.phone = phone;
        this.address = address;
        this.customerName = customerName;
    }

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customerId +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", customer='" + customerName + '\'' +
                '}';
    }
}
