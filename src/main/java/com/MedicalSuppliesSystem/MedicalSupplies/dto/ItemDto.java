package com.MedicalSuppliesSystem.MedicalSupplies.dto;


import java.math.BigDecimal;

public class ItemDto {

    private String itemno;
    private BigDecimal price;
    private String details;
    private String itemName;
    private String company;

    public ItemDto(String itemno, BigDecimal price, String details, String itemName, String company) {
        this.itemno = itemno;
        this.price = price;
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
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "itemDto{" +
                "itemno='" + itemno + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", itemName='" + itemName + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
