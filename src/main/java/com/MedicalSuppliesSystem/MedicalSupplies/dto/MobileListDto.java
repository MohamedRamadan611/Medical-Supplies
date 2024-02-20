/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MedicalSuppliesSystem.MedicalSupplies.dto;

import java.io.Serializable;

/**
 * @author Rawan.Ahmed
 */
public class MobileListDto implements Serializable {

    private Object listData;

    public MobileListDto() {
    }

    public MobileListDto(Object listData) {
        this.listData = listData;
    }

    public Object getListData() {
        return listData;
    }

    public void setListData(Object listData) {
        this.listData = listData;
    }

}
