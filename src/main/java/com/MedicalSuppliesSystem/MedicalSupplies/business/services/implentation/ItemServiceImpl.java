package com.MedicalSuppliesSystem.MedicalSupplies.business.services.implentation;

import com.MedicalSuppliesSystem.MedicalSupplies.business.repository.InvoiceRepository;
import com.MedicalSuppliesSystem.MedicalSupplies.business.repository.ItemRepository;
import com.MedicalSuppliesSystem.MedicalSupplies.business.services.interfaces.IItemService;
import com.MedicalSuppliesSystem.MedicalSupplies.controller.item.ItemController;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.ItemDto;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.MappingClass;
import com.MedicalSuppliesSystem.MedicalSupplies.model.Item;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.FilterPojo;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.SearchParPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Arrays;


@Service
public class ItemServiceImpl implements IItemService {

    Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private MappingClass mappingClass;
    @Override
    @Transactional
    public void addItem(ItemDto itemDto) {
        try {
            logger.info("start saving to DB");
            itemRepository.save(mappingClass.MapToItem(itemDto));
        }
        catch (Exception exception)
        {
            logger.error(Arrays.toString(exception.getStackTrace()));
            throw  exception;
        }
    }

    @Override
    public ItemDto findItem(SearchParPojo searchParPojo) {
        String itemFilter = null;
        FilterPojo filterPojo = new FilterPojo();

        boolean filterValueExist = filterPojo.getFilterValues() != null && !filterPojo.getFilterValues().isEmpty();
        boolean filterFieldName = filterPojo.getFieldName() != null && !filterPojo.getFieldName().isEmpty();
        logger.info("start finding item by itemFilter .. ");
        if(searchParPojo != null && !searchParPojo.getFiltersList().isEmpty())
        {
            for(FilterPojo forFilterPojo : searchParPojo.getFiltersList())
            {
                if(filterFieldName && filterValueExist)
                {
                    if(forFilterPojo.getFieldName().equals("itemFilter"))
                    {
                        itemFilter = forFilterPojo.getFilter().isEmpty() ? null : forFilterPojo.getFilter();
                    }
                }
            }
        }
        Item item = itemRepository.findItem(itemFilter);
        logger.info("Item is {} " , item.toString());
        return mappingClass.MapToItemDto(item);
    }
}
