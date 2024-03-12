package com.MedicalSuppliesSystem.MedicalSupplies.business.repository;

import com.MedicalSuppliesSystem.MedicalSupplies.model.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoices , Serializable> {
}
