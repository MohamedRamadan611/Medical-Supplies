package com.MedicalSuppliesSystem.MedicalSupplies.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {

    @Id
    @Column(name="stockTransNo")
    private String stockTransNo;
    @Column(name="quantity")
    private int quantity;
    @Column(name="sold_quantity")
    private int soldQuantity;
    @Column(name="remain_quantity")
    private int remainQuantity;
    @Column(name="inventory_branch")
    private int inventoryBranch;
    @Column(name="item_no")
    private Item itemno;

    public Stock(String stockTransNo, int quantity, int soldQuantity, int remainQuantity, int inventoryBranch, Item itemno) {
        this.stockTransNo = stockTransNo;
        this.quantity = quantity;
        this.soldQuantity = soldQuantity;
        this.remainQuantity = remainQuantity;
        this.inventoryBranch = inventoryBranch;
        this.itemno = itemno;
    }
    public String getStockTransNo() {
        return stockTransNo;
    }

    public void setStockTransNo(String stockTransNo) {
        this.stockTransNo = stockTransNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public int getRemainQuantity() {
        return remainQuantity;
    }

    public void setRemainQuantity(int remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    public int getInventoryBranch() {
        return inventoryBranch;
    }

    public void setInventoryBranch(int inventoryBranch) {
        this.inventoryBranch = inventoryBranch;
    }

    public Item getItemno() {
        return itemno;
    }

    public void setItemno(Item itemno) {
        this.itemno = itemno;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockTransNo='" + stockTransNo + '\'' +
                ", quantity=" + quantity +
                ", soldQuantity=" + soldQuantity +
                ", remainQuantity=" + remainQuantity +
                ", inventoryBranch=" + inventoryBranch +
                ", itemno=" + itemno +
                '}';
    }
}
