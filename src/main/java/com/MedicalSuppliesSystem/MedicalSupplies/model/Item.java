package com.MedicalSuppliesSystem.MedicalSupplies.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="item")
public class Item implements Serializable {

    @Id
    @Column(name="itemno")
    private String itemno;
    @Column(name="item_price")
    private BigDecimal itemPrice;
    @Column(name="details")
    private String details;
    @Column(name="item_name")
    private String itemName;
    @Column(name="company")
    private String company;


    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemno=" + itemno +
                ", price=" + itemPrice +
                ", details='" + details + '\'' +
                ", itemName='" + itemName + '\'' +
                ", Company='" + company + '\'' +
                '}';
    }
}
