package com.MedicalSuppliesSystem.MedicalSupplies.business.repository;

import com.MedicalSuppliesSystem.MedicalSupplies.model.Stock;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock , Serializable> {
    @Query("Select s from Stock s where " +
            ":inventoryBranch is null or s.inventoryBranch = :inventoryBranch " +
            "AND (:itemno is null or s.itemno = :itemno)")
    Stock findStock(@Param("inventoryBranch") int inventoryBranch, @Param("itemno") String itemno);

    @Query("Select s from Stock s where " +
            "s.remainQuantity = 0")
    List<Stock> findFinishedStocks();
}
