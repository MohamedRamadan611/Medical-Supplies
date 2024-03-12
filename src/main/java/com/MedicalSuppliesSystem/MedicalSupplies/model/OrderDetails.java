package com.MedicalSuppliesSystem.MedicalSupplies.model;


import com.MedicalSuppliesSystem.MedicalSupplies.model.pk.OrderDetailsId;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="order_details")
@IdClass(OrderDetailsId.class)
public class OrderDetails implements Serializable {

    @Id
    @Column(name = "orderno")
    private Long orderno;
    @Id
    @Column(name = "itemno")
    private String itemno;
    @Column(name = "item_price")
    private BigDecimal itemPrice;
    @Column(name = "item_quantity")
    private Long itemQuantity;
    @Column(name = "inventory_branch")
    private int inventoryBranch;


    public Long getOrderno() {
        return orderno;
    }

    public void setOrderno(Long orderno) {
        this.orderno = orderno;
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

    public Long getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Long itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getInventoryBranch() {
        return inventoryBranch;
    }

    public void setInventoryBranch(int inventoryBranch) {
        this.inventoryBranch = inventoryBranch;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderno=" + orderno +
                ", itemno='" + itemno + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemQuantity=" + itemQuantity +
                ", inventoryBranch=" + inventoryBranch +
                '}';
    }
}
