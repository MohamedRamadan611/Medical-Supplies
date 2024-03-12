package com.MedicalSuppliesSystem.MedicalSupplies.dto;

import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeDeserializer;
import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class StockDto implements Serializable {

    private Long quantity;
    private int inventoryBranch;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private Date stockCreationDate;
    private String itemno;

    public StockDto() {
    }

    public StockDto(Long quantity, int inventoryBranch, Date stockCreationDate, String itemno) {
        this.quantity = quantity;
        this.inventoryBranch = inventoryBranch;
        this.stockCreationDate = stockCreationDate;
        this.itemno = itemno;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

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

    public Date getStockCreationDate() {
        return stockCreationDate;
    }

    public void setStockCreationDate(Date stockCreationDate) {
        this.stockCreationDate = stockCreationDate;
    }
}
