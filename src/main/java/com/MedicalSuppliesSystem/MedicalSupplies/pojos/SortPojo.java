/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MedicalSuppliesSystem.MedicalSupplies.pojos;

/**
 * @author Rawan.Ahmed
 */
public class SortPojo {

    private String fieldName;
    private String sortDirection;

    public SortPojo() {
    }

    public SortPojo(String fieldName, String sortDirection) {
        this.fieldName = fieldName;
        this.sortDirection = sortDirection;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    @Override
    public String toString() {
        return "SortPojo{" + "fieldName=" + fieldName + ", sortDirection=" + sortDirection + '}';
    }

}
