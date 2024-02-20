package com.MedicalSuppliesSystem.MedicalSupplies.dto;

import com.MedicalSuppliesSystem.MedicalSupplies.model.Customer;
import com.MedicalSuppliesSystem.MedicalSupplies.model.Item;
import java.math.BigDecimal;
import java.util.List;

public class OrderDto {

    private String orderType;
    private Customer customerno;
    private String orderAddress;
    private BigDecimal deliveryPrice;
    private BigDecimal orderPrice;
    private BigDecimal amount;
    private BigDecimal discount;
    private List<Item> itemList;

    public OrderDto(String orderType, Customer customerno, String orderAddress, BigDecimal deliveryPrice, BigDecimal orderPrice, BigDecimal amount, BigDecimal discount, List<Item> itemList) {
        this.orderType = orderType;
        this.customerno = customerno;
        this.orderAddress = orderAddress;
        this.deliveryPrice = deliveryPrice;
        this.orderPrice = orderPrice;
        this.amount = amount;
        this.discount = discount;
        this.itemList = itemList;
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

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderType='" + orderType + '\'' +
                ", customerno=" + customerno +
                ", orderAddress='" + orderAddress + '\'' +
                ", deliveryPrice=" + deliveryPrice +
                ", orderPrice=" + orderPrice +
                ", amount=" + amount +
                ", discount=" + discount +
                ", itemList=" + itemList +
                '}';
    }
}
