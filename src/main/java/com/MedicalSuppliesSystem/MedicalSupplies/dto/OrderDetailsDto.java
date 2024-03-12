package com.MedicalSuppliesSystem.MedicalSupplies.dto;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetailsDto implements Serializable {

    private String itemno;
    private Long itemQuantity;
    private int inventoryBranch;

    public OrderDetailsDto() {
    }

    public OrderDetailsDto(String itemno, Long itemQuantity, int inventoryBranch) {
        this.itemno = itemno;
        this.itemQuantity = itemQuantity;
        this.inventoryBranch = inventoryBranch;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public int getInventoryBranch() {
        return inventoryBranch;
    }

    public void setInventoryBranch(int inventoryBranch) {
        this.inventoryBranch = inventoryBranch;
    }

    public Long getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Long itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Override
    public String toString() {
        return "OrderDetailsDto{" +
                "itemno='" + itemno + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", inventoryBranch=" + inventoryBranch +
                '}';
    }
}
