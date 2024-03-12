package com.MedicalSuppliesSystem.MedicalSupplies.business.services.interfaces;

import com.MedicalSuppliesSystem.MedicalSupplies.dto.ItemDto;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.SearchParPojo;
import org.springframework.data.domain.Pageable;

public interface IItemService {
    void addItem(ItemDto itemDto);

    ItemDto findItem(SearchParPojo searchParPojo );
}
