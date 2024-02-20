package com.MedicalSuppliesSystem.MedicalSupplies.dto;

import com.MedicalSuppliesSystem.MedicalSupplies.model.Customer;
import com.MedicalSuppliesSystem.MedicalSupplies.model.Order;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class InvoicesDto {
    private int paymentType;
    private String authCode;
    private BigDecimal deliveryPrice;
    private BigDecimal orderPrice;
    private BigDecimal amount;
    private BigDecimal discount;
    private Date creationDate;
    private String orderType;
    private Customer customerno;
    private List<Order> orderList;

    public InvoicesDto(int paymentType, String authCode, BigDecimal deliveryPrice, BigDecimal orderPrice, BigDecimal amount, BigDecimal discount, Date creationDate, String orderType, Customer customerno, List<Order> orderList) {
        this.paymentType = paymentType;
        this.authCode = authCode;
        this.deliveryPrice = deliveryPrice;
        this.orderPrice = orderPrice;
        this.amount = amount;
        this.discount = discount;
        this.creationDate = creationDate;
        this.orderType = orderType;
        this.customerno = customerno;
        this.orderList = orderList;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "InvoicesDto{" +
                "paymentType=" + paymentType +
                ", authCode='" + authCode + '\'' +
                ", deliveryPrice=" + deliveryPrice +
                ", orderPrice=" + orderPrice +
                ", amount=" + amount +
                ", discount=" + discount +
                ", creationDate=" + creationDate +
                ", orderType='" + orderType + '\'' +
                ", customerno=" + customerno +
                ", orderList=" + orderList +
                '}';
    }
}
