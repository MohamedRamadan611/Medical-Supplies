package com.MedicalSuppliesSystem.MedicalSupplies.business.repository;

import com.MedicalSuppliesSystem.MedicalSupplies.model.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Serializable> {
    @Query("Select o From Order o Where " +
            " ( (:orderFilter is null or o.orderNo like concat(convert(:orderFilter,signed),'%')) " +
            " OR (:orderFilter is null or o.customerno.customerId like concat(convert(:orderFilter,signed) , '%')) " +
            " OR (:orderFilter is null or o.customerno.phone like concat(:orderFilter,'%')) " +
            " OR (:orderFilter is null or o.customerno.customerName like concat('%' , :orderFilter , '%')) )" +
            " AND (:orderType is null or o.orderType = :orderType ) " +
            " AND (COALESCE(:fromDate, '1000-01-01') <= o.orderCreationDate and COALESCE(o.orderCreationDate , '3000-01-01') <= COALESCE(:toDate , '3000-01-01') )" +
            " Order by o.orderCreationDate")
    List<Order> findOrders(@Param("orderFilter") String orderFilter ,@Param("orderType") String orderType, @Param("fromDate") String fromDate, @Param("toDate") String toDate , Pageable pageable);

}
