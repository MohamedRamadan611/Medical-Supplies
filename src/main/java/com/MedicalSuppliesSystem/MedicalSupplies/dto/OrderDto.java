package com.MedicalSuppliesSystem.MedicalSupplies.dto;

import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeDeserializer;
import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDto implements Serializable {

    private String orderType;
    private CustomerDto customerno;
    private String orderAddress;
    private BigDecimal deliveryPrice;
    private BigDecimal discount;
    private List<OrderDetailsDto> orderDetails;


    public OrderDto() {
    }

    public OrderDto(String orderType, CustomerDto customerno, String orderAddress, BigDecimal deliveryPrice, BigDecimal discount, int inventoryBranch, List<OrderDetailsDto> orderDetails) {
        this.orderType = orderType;
        this.customerno = customerno;
        this.orderAddress = orderAddress;
        this.deliveryPrice = deliveryPrice;
        this.discount = discount;
        this.orderDetails = orderDetails;
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

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }


    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public List<OrderDetailsDto> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsDto> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderType='" + orderType + '\'' +
                ", customerno=" + customerno +
                ", orderAddress='" + orderAddress + '\'' +
                ", deliveryPrice=" + deliveryPrice +
                ", discount=" + discount +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
