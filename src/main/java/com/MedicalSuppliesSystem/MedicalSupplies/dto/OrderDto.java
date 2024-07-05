package com.MedicalSuppliesSystem.MedicalSupplies.dto;

import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeDeserializer;
import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDto extends BaseOrderDto {

    private Long orderNo;
    private BigDecimal orderPrice;
    private BigDecimal amount;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private Date orderCreationDate;

    public OrderDto() {
    }

    public OrderDto(String orderType, CustomerDto customerno, String orderAddress, BigDecimal deliveryPrice, BigDecimal discount, int inventoryBranch, List<OrderDetailsDto> orderDetails, Long orderNo, BigDecimal orderPrice, BigDecimal amount, Date orderCreationDate) {
        super(orderType, customerno, orderAddress, deliveryPrice, discount, inventoryBranch, orderDetails);
        this.orderNo = orderNo;
        this.orderPrice = orderPrice;
        this.amount = amount;
        this.orderCreationDate = orderCreationDate;
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

    public Date getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(Date orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderNo=" + orderNo +
                ", orderPrice=" + orderPrice +
                ", amount=" + amount +
                ", orderCreationDate=" + orderCreationDate +
                '}';
    }
}
