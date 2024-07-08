package com.MedicalSuppliesSystem.MedicalSupplies.business.services.implentation;

import com.MedicalSuppliesSystem.MedicalSupplies.business.repository.InvoiceRepository;
import com.MedicalSuppliesSystem.MedicalSupplies.business.repository.OrderRepository;
import com.MedicalSuppliesSystem.MedicalSupplies.business.services.interfaces.IInvoiceService;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.InvoicesDto;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.MappingClass;
import com.MedicalSuppliesSystem.MedicalSupplies.model.Invoices;
import com.MedicalSuppliesSystem.MedicalSupplies.model.Order;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.FilterPojo;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.SearchParPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements IInvoiceService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private MappingClass mappingClass;
    @Override
    public void addInvoice(InvoicesDto invoicesDto) {
            invoiceRepository.save(mappingClass.MapToInvoice(invoicesDto));
    }

    @Override
    public List<InvoicesDto> findItem(SearchParPojo searchParPojo , Pageable pageable) {
        String invoiceFilter = null;
        String orderType = null;
        String fromDate = null;
        String toDate = null;
        FilterPojo filterPojo = new FilterPojo();
        boolean fieldNameExist = filterPojo.getFieldName() != null && !filterPojo.getFieldName().isEmpty();
        boolean filterValueExist = filterPojo.getFilter() != null && !filterPojo.getFilter().isEmpty();

        if (searchParPojo.getFiltersList() != null && !searchParPojo.getFiltersList().isEmpty()) {
            for (FilterPojo forFilterPojo : searchParPojo.getFiltersList()) {
                if (!fieldNameExist && !filterValueExist) {
                    if (forFilterPojo.getFieldName().equals("invoiceFilter")) {
                        invoiceFilter = forFilterPojo.getFilter().isEmpty() ? null : forFilterPojo.getFilter();
                    } else if (forFilterPojo.getFieldName().equals("orderType")) {
                        orderType = forFilterPojo.getFilter().isEmpty() ? null : forFilterPojo.getFilter();
                    } else if (forFilterPojo.getFieldName().equals("fromDate")) {
                        fromDate = forFilterPojo.getFilter().isEmpty() ? null : forFilterPojo.getFilter();
                    } else if (forFilterPojo.getFieldName().equals("toDate")) {
                        toDate = forFilterPojo.getFilter().isEmpty() ? null : forFilterPojo.getFilter();
                    }

                }
            }
        }
        List<Invoices> invoicesList = invoiceRepository.findInvoices(invoiceFilter , orderType, fromDate , toDate , pageable);
        return invoicesList.stream().map(invoice -> mappingClass.MapToInvoiceDto(invoice)).collect(Collectors.toList());
    }

    @Override
    public List<InvoicesDto> findAllInvoices() {
        return invoiceRepository.findAll().stream().map(invoices -> mappingClass.MapToInvoiceDto(invoices)).collect(Collectors.toList());
    }
}
