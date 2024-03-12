package com.MedicalSuppliesSystem.MedicalSupplies.model.pk;

import java.io.Serializable;

public class CustomerId implements Serializable {

    private String phone;
    private Long customerId;

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
