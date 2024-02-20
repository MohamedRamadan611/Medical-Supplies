/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.MedicalSuppliesSystem.MedicalSupplies.enums;

/**
 *
 * @author Mohanad.Ehab
 */
public enum ReportsEnum {

    NEW_COLLECTION("1"),
    REJECTED_PAYMENT("2"),
    NEW_PAYMENT("3");

    private final String reportId;

    ReportsEnum(String reportId) {
        this.reportId = reportId;
    }

    public String getReportId() {
        return reportId;
    }
    
    

}
