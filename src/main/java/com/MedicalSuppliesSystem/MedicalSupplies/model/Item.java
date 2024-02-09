package com.MedicalSuppliesSystem.MedicalSupplies.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="item")

public class Item {

    @Id
    @Column(name="itemno")
    private String itemno;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="details")
    private String details;
    @Column(name="itemName")
    private String itemName;
    @Column(name="company")
    private String Company;

    public Item(String itemno, BigDecimal price, String details, String itemName, String company) {
        this.itemno = itemno;
        this.price = price;
        this.details = details;
        this.itemName = itemName;
        Company = company;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemno=" + itemno +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", itemName='" + itemName + '\'' +
                ", Company='" + Company + '\'' +
                '}';
    }
}
