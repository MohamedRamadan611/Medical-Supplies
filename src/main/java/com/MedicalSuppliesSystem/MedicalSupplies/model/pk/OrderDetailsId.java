package com.MedicalSuppliesSystem.MedicalSupplies.model.pk;

import javax.persistence.Column;
import java.io.Serializable;

public class OrderDetailsId implements Serializable {
    private Long orderno;
    private String itemno;

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
}
