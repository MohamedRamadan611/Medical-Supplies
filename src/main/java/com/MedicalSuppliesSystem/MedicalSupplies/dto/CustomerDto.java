package com.MedicalSuppliesSystem.MedicalSupplies.dto;

import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeDeserializer;
import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class CustomerDto implements Serializable {

    private String phone;
    private String address;
    private String customerName;

    public CustomerDto() {
    }

    public CustomerDto(String phone, String address, String customerName, Date customerCreationDate) {
        this.phone = phone;
        this.address = address;
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
