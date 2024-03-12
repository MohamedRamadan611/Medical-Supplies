package com.MedicalSuppliesSystem.MedicalSupplies.dto;


import java.io.Serializable;
import java.math.BigDecimal;

public class ItemDto implements Serializable {

    private String itemno;
    private BigDecimal itemPrice;
    private String details;
    private String itemName;
    private String company;

    public ItemDto() {
    }


    public ItemDto(String itemno, BigDecimal itemPrice, String details, String itemName, String company) {
        this.itemno = itemno;
        this.itemPrice = itemPrice;
        this.details = details;
        this.itemName = itemName;
        this.company = company;
    }

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
        return "itemDto{" +
                "itemno='" + itemno + '\'' +
                ", price=" + itemPrice +
                ", details='" + details + '\'' +
                ", itemName='" + itemName + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
