package com.MedicalSuppliesSystem.MedicalSupplies.enums;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Rawan.Ahmed
 */
public enum ResponseMessageEnum {
    SUCCESS("success"),
    FAILED("failed"),
    NOT_FOUND("Not Found"),
    DATA_LOADING_SUCCESS_MESSAGE("data loaded successfully"),
    MESSAGE("message"),
    STATUS("status");
    private String message;

    private ResponseMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
