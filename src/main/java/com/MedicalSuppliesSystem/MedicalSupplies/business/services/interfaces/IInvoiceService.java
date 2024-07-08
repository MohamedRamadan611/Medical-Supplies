package com.MedicalSuppliesSystem.MedicalSupplies.business.services.interfaces;

import com.MedicalSuppliesSystem.MedicalSupplies.dto.InvoicesDto;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.SearchParPojo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IInvoiceService {
    void addInvoice(InvoicesDto invoicesDto);

    List<InvoicesDto> findItem(SearchParPojo searchParPojo , Pageable pageable);

    List<InvoicesDto> findAllInvoices();
}
