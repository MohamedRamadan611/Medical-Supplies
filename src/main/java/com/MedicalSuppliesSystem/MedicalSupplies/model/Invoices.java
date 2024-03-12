package com.MedicalSuppliesSystem.MedicalSupplies.model;

import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeDeserializer;
import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoices implements Serializable {

    @Id
    @Column(name = "invoiceno")
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long invoiceno;
    @Column(name ="payment_type")
    private int paymentType;
    @Column(name = "payment_status")
    private String paymentStatus;
    @Column(name = "auth_code")
    private String authCode;
    @Column(name="order_address")
    private String orderAddress;
    @Column(name="delivery_price")
    private BigDecimal deliveryPrice;
    @Column(name="order_price")
    private BigDecimal orderPrice;
    @Column(name="amount")
    private BigDecimal amount;
    @Column(name="discount")
    private BigDecimal discount;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @Column(name = "invoice_creation_date")
    private Date invoiceCreationDate;
    @Column(name="order_type")
    private String orderType;
    @JoinColumn(name = "customerno" , referencedColumnName = "customer_id")
    @ManyToOne(optional = true , cascade = {CascadeType.ALL})
    private Customer customerno;
    @OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL}, mappedBy = "orderNo", fetch = FetchType.LAZY)
    private List<Order> orderList;


    public Long getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(Long invoiceno) {
        this.invoiceno = invoiceno;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
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

    public Date getInvoiceCreationDate() {
        return invoiceCreationDate;
    }

    public void setInvoiceCreationDate(Date invoiceCreationDate) {
        this.invoiceCreationDate = invoiceCreationDate;
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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    @Override
    public String toString() {
        return "Invoices{" +
                "invoiceno=" + invoiceno +
                ", paymentType=" + paymentType +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", authCode='" + authCode + '\'' +
                ", deliveryPrice=" + deliveryPrice +
                ", orderPrice=" + orderPrice +
                ", amount=" + amount +
                ", discount=" + discount +
                ", creationDate=" + invoiceCreationDate +
                ", orderType='" + orderType + '\'' +
                ", customerno=" + customerno +
                ", orderList=" + orderList +
                '}';
    }
}
