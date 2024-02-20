/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MedicalSuppliesSystem.MedicalSupplies.pojos;

import java.util.List;

/**
 * @author Rawan.Ahmed
 */
public class FilterPojo {

    private String fieldName;
    private String filter;
    private List<String> filterValues;
    private String type;

    public FilterPojo() {
        this.type = type;
    }

    public FilterPojo(String fieldName, String filter, String type) {
        this.fieldName = fieldName;
        this.filter = filter;
        this.type = type;
    }

    public FilterPojo(String fieldName, List<String> filterValues, String type) {
        this.fieldName = fieldName;
        this.filterValues = filterValues;
        this.type = type;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public List<String> getFilterValues() {
        return filterValues;
    }

    public void setFilterValues(List<String> filterValues) {
        this.filterValues = filterValues;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FilterPojo{" + "fieldName=" + fieldName + ", filter=" + filter + ", type=" + type + '}';
    }

}
