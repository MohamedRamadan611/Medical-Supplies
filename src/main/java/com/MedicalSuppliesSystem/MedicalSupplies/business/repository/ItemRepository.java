package com.MedicalSuppliesSystem.MedicalSupplies.business.repository;

import com.MedicalSuppliesSystem.MedicalSupplies.model.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface ItemRepository extends JpaRepository<Item , Serializable> {

    @Query("Select i from Item i where" +
            "(:itemFilter is null or i.itemno like (:itemFiler , '%')) " +
            "OR (:itemFilter is null or i.itemName like('%' , :itemFiler , '&'))")
    Item findItem(@Param("itemFilter") String itemFilter);
}
