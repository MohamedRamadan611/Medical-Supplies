package com.MedicalSuppliesSystem.MedicalSupplies.model.pk;

import com.MedicalSuppliesSystem.MedicalSupplies.model.Item;

import java.io.Serializable;

public class StockID implements Serializable {
    private int inventoryBranch;
    private String itemno;


    public int getInventoryBranch() {
        return inventoryBranch;
    }

    public void setInventoryBranch(int inventoryBranch) {
        this.inventoryBranch = inventoryBranch;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }
}
