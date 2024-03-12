package com.MedicalSuppliesSystem.MedicalSupplies.model;

import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeDeserializer;
import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    @JoinColumn(name="customerno" , referencedColumnName = "customer_id")
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
    @OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL}, mappedBy = "orderno", fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetails;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @Column(name = "order_creation_date")
    private Date orderCreationDate;

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

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Date getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(Date orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
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
                ", orderDetails=" + orderDetails +
                ", orderCreationDate=" + orderCreationDate +
                '}';
    }
}
