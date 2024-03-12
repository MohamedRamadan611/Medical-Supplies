package com.MedicalSuppliesSystem.MedicalSupplies.enums;

public enum OrderTypes {
    STORE("Store"),
    DELIVERY("Delivery");

    private final String orderType;

    OrderTypes(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderType() {
        return orderType;
    }
}
