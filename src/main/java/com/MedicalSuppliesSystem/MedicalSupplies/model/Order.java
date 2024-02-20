package com.MedicalSuppliesSystem.MedicalSupplies.model;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order implements Serializable {

    @Id
    @Column(name = "orderno")
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long orderNo;
    @Column(name="order_type")
    private String orderType;
    @Column(name="customerno")
    @ManyToOne(optional = true , cascade = {CascadeType.ALL})
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
    @OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL}, mappedBy = "itemno", fetch = FetchType.LAZY)
    private List<Item> itemList;

    public Order(Long orderNo, String orderType, Customer customerno, String orderAddress, BigDecimal deliveryPrice, BigDecimal orderPrice, BigDecimal amount, BigDecimal discount, List<Item> itemList) {
        this.orderNo = orderNo;
        this.orderType = orderType;
        this.customerno = customerno;
        this.orderAddress = orderAddress;
        this.deliveryPrice = deliveryPrice;
        this.orderPrice = orderPrice;
        this.amount = amount;
        this.discount = discount;
        this.itemList = itemList;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
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

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo=" + orderNo +
                ", orderType='" + orderType + '\'' +
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
