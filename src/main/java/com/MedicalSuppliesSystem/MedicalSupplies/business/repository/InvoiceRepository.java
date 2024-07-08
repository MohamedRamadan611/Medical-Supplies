package com.MedicalSuppliesSystem.MedicalSupplies.business.repository;

import com.MedicalSuppliesSystem.MedicalSupplies.model.Invoices;
import com.MedicalSuppliesSystem.MedicalSupplies.model.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoices , Serializable> {
    @Query("Select i From Invoices i Where " +
            " ( (:invoiceFilter is null or i.invoiceno like concat(convert(:invoiceFilter,signed),'%')) " +
            " OR (:invoiceFilter is null or i.customerno.customerId like concat(convert(:invoiceFilter,signed) , '%')) " +
            " OR (:invoiceFilter is null or i.customerno.phone like concat(:invoiceFilter,'%')) " +
            " OR (:invoiceFilter is null or i.customerno.customerName like concat('%' , :invoiceFilter , '%')) )" +
            " AND (:orderType is null or i.orderType = :orderType ) " +
            " AND (COALESCE(:fromDate, '1000-01-01') <= i.invoiceCreationDate and COALESCE(i.invoiceCreationDate , '3000-01-01') <= COALESCE(:toDate , '3000-01-01') )" +
            " Order by i.invoiceCreationDate")
    List<Invoices> findInvoices(@Param("invoiceFilter") String invoiceFilter, @Param("orderType") String orderType, @Param("fromDate") String fromDate, @Param("toDate") String toDate, Pageable pageable);
}
