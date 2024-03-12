package com.MedicalSuppliesSystem.MedicalSupplies.business.repository;

import com.MedicalSuppliesSystem.MedicalSupplies.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Serializable> {
    @Query("Select c from Customer c Where ( :phone is null or c.phone = :phone)")
    Customer findCustomerByPhone(@Param("phone") String phone);
}
