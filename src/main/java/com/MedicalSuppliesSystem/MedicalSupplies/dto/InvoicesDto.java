package com.MedicalSuppliesSystem.MedicalSupplies.dto;

import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeDeserializer;
import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class InvoicesDto implements Serializable {
    private int paymentType;
    private String authCode;
    private BigDecimal deliveryPrice;
    private BigDecimal orderPrice;
    private BigDecimal amount;
    private BigDecimal discount;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private Date creationDate;
    private String orderType;
    private CustomerDto customerno;
    private List<OrderDto> orderList;
    private String orderAddress;


    public InvoicesDto(int paymentType, String authCode, BigDecimal deliveryPrice, BigDecimal orderPrice, BigDecimal amount, BigDecimal discount, Date creationDate, String orderType, CustomerDto customerno, List<OrderDto> orderList, String orderAddress) {
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
        this.orderAddress = orderAddress;
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

    public CustomerDto getCustomerno() {
        return customerno;
    }

    public void setCustomerno(CustomerDto customerno) {
        this.customerno = customerno;
    }

    public List<OrderDto> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDto> orderList) {
        this.orderList = orderList;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
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
