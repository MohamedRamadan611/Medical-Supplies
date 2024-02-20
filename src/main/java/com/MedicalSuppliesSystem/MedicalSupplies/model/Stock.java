package com.MedicalSuppliesSystem.MedicalSupplies.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="stock")
public class Stock implements Serializable {

    @Id
    @Column(name="stockTransNo")
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long stockTransNo;
    @Column(name="quantity")
    private int quantity;
    @Column(name="sold_quantity")
    private int soldQuantity;
    @Column(name="remain_quantity")
    private int remainQuantity;
    @Column(name="inventory_branch")
    private int inventoryBranch;
    @Column(name="itemno")
    @OneToOne
    private Item itemno;

    public Stock(Long stockTransNo, int quantity, int soldQuantity, int remainQuantity, int inventoryBranch, Item itemno) {
        this.stockTransNo = stockTransNo;
        this.quantity = quantity;
        this.soldQuantity = soldQuantity;
        this.remainQuantity = remainQuantity;
        this.inventoryBranch = inventoryBranch;
        this.itemno = itemno;
    }
    public Long getStockTransNo() {
        return stockTransNo;
    }

    public void setStockTransNo(Long stockTransNo) {
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
