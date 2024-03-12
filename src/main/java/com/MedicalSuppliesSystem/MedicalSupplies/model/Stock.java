package com.MedicalSuppliesSystem.MedicalSupplies.model;


import com.MedicalSuppliesSystem.MedicalSupplies.model.pk.StockID;
import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeDeserializer;
import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="stock")
@IdClass(StockID.class)
public class Stock implements Serializable {

    @Id
    @Column(name="stock_trans_no")
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long stockTransNo;
    @Column(name="quantity")
    private Long quantity;
    @Column(name="sold_quantity")
    private Long soldQuantity;
    @Column(name="remain_quantity")
    private Long remainQuantity;
    @Id
    @Column(name="inventory_branch")
    private int inventoryBranch;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @Column(name = "stock_creation_date")
    private Date stockCreationDate;
    @Id
    @Column(name = "itemno")
    private String itemno;
    public Long getStockTransNo() {
        return stockTransNo;
    }

    public void setStockTransNo(Long stockTransNo) {
        this.stockTransNo = stockTransNo;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Long soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Long getRemainQuantity() {
        return remainQuantity;
    }

    public void setRemainQuantity(Long remainQuantity) {
        this.remainQuantity = remainQuantity;
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
