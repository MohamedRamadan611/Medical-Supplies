package com.MedicalSuppliesSystem.MedicalSupplies.business.services.interfaces;

import com.MedicalSuppliesSystem.MedicalSupplies.dto.StockDto;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.SearchParPojo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStockService {
    void addStock(StockDto stockDto);

    StockDto findStock(SearchParPojo searchParPojo, Pageable pageRequest);

    List<StockDto> findFinishedStock();
}
