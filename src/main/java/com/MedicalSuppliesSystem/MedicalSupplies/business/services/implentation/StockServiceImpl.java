package com.MedicalSuppliesSystem.MedicalSupplies.business.services.implentation;

import com.MedicalSuppliesSystem.MedicalSupplies.business.repository.ItemRepository;
import com.MedicalSuppliesSystem.MedicalSupplies.business.repository.StockRepository;
import com.MedicalSuppliesSystem.MedicalSupplies.business.services.interfaces.IStockService;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.MappingClass;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.StockDto;
import com.MedicalSuppliesSystem.MedicalSupplies.exception.BusinessException;
import com.MedicalSuppliesSystem.MedicalSupplies.model.Item;
import com.MedicalSuppliesSystem.MedicalSupplies.model.Stock;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.FilterPojo;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.SearchParPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements IStockService {

    Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private MappingClass mappingClass;

    @Override
    @Transactional
    public void addStock(StockDto stockDto) {

        try {
            Stock stock = stockRepository.findStock(stockDto.getInventoryBranch(), stockDto.getItemno());
            if (stock == null) {
                Stock newStock = new Stock();
                logger.info("we didn't find stock for this item ...");
                newStock.setStockCreationDate(new Date());
                newStock.setQuantity(stockDto.getQuantity());
                newStock.setInventoryBranch(stockDto.getInventoryBranch());
                newStock.setSoldQuantity(0L);
                newStock.setRemainQuantity(stockDto.getQuantity());
                Item item = itemRepository.findById(stockDto.getItemno()).orElseThrow(() -> new BusinessException("this item didn't found"));
                newStock.setItemno(stockDto.getItemno());
                logger.info("new stock added to database");
                stockRepository.save(newStock);
            } else {
                logger.info("this item has stock before ", stock.toString());
                stock.setStockCreationDate(new Date());
                stock.setQuantity(stock.getQuantity() + stockDto.getQuantity());
                stock.setRemainQuantity(stock.getQuantity() - stock.getSoldQuantity());
                stockRepository.save(stock);
                logger.info("we updated item with this stock {} ", stock.toString());
            }
        } catch (Exception exception) {
            logger.error(Arrays.toString(exception.getStackTrace()));
            throw exception;
        }
    }

    @Override
    public StockDto findStock(SearchParPojo searchParPojo, Pageable pageRequest) {
        String itemno = null;
        String inventoryBranch = null;
        FilterPojo filterPojo = new FilterPojo();

        boolean filterValueExist = filterPojo.getFilterValues() != null && !filterPojo.getFilterValues().isEmpty();
        boolean filterFieldName = filterPojo.getFieldName() != null && !filterPojo.getFieldName().isEmpty();
        logger.info("start finding item by itemFilter .. ");
        if (searchParPojo != null && !searchParPojo.getFiltersList().isEmpty()) {
            for (FilterPojo forFilterPojo : searchParPojo.getFiltersList()) {
                if (filterFieldName && filterValueExist) {
                    if (forFilterPojo.getFieldName().equals("itemno")) {
                        itemno = forFilterPojo.getFilter().isEmpty() ? null : forFilterPojo.getFilter();
                    } else if (forFilterPojo.getFieldName().equals("inventoryBranch")) {
                        inventoryBranch = forFilterPojo.getFilter().isEmpty() ? null : forFilterPojo.getFilter();
                    }
                }
            }
        }
        Stock stock = stockRepository.findStock(Integer.parseInt(inventoryBranch),itemno);
        logger.info("stock is {} ", stock.toString());
        return mappingClass.MapToStockDto(stock);
    }

    @Override
    public List<StockDto> findFinishedStock() {
        List<Stock> stocks = stockRepository.findFinishedStocks();
        return stocks.stream().map(stock -> mappingClass.MapToStockDto(stock)).collect(Collectors.toList());
    }
}
