package com.MedicalSuppliesSystem.MedicalSupplies.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MappingClass {

    @Autowired
    private ModelMapper model;

    // convert Entity into SDTO for create/update
  /*  public SAccInvoiceDto mapToSDTO(AccInvoice newAccInvoice) {
        SAccInvoiceDto accinvoiceResponse = model.map(newAccInvoice, SAccInvoiceDto.class);
        return accinvoiceResponse;

    }*/


}
