package com.MedicalSuppliesSystem.MedicalSupplies.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Order")
public class Order {

    @Id
    @Column(name="orderno")
    private String orderNo;
    @Column(name="orderType")
    private String orderType;
    @Column(name="customerno")
    private Customer customerno;
    @Column(name="order_address")
    private String orderAddress;
    @Column(name="delivery_price")
    private BigDecimal deliveryPrice;
    @Column(name="orderPrice")
    private BigDecimal orderPrice;
    @Column(name="amount")
    private BigDecimal amount;
    @Column(name="discount")
    private BigDecimal discount;

    public Order(String orderNo, String orderType, Customer customerno, String orderAddress, BigDecimal deliveryPrice, BigDecimal orderPrice, BigDecimal amount, BigDecimal discount) {
        this.orderNo = orderNo;
        this.orderType = orderType;
        this.customerno = customerno;
        this.orderAddress = orderAddress;
        this.deliveryPrice = deliveryPrice;
        this.orderPrice = orderPrice;
        this.amount = amount;
        this.discount = discount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Customer getCustomerno() {
        return customerno;
    }

    public void setCustomerno(Customer customerno) {
        this.customerno = customerno;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", orderType='" + orderType + '\'' +
                ", customerno=" + customerno +
                ", orderAddress='" + orderAddress + '\'' +
                ", deliveryPrice=" + deliveryPrice +
                ", orderPrice=" + orderPrice +
                ", amount=" + amount +
                ", discount=" + discount +
                '}';
    }
}
