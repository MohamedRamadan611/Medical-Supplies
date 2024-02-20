package com.MedicalSuppliesSystem.MedicalSupplies.dto;

import javax.persistence.Column;

public class CustomerDto {

    private String phone;

    private String address;

    private String customerName;

    public CustomerDto(String phone, String address, String customerName) {
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
