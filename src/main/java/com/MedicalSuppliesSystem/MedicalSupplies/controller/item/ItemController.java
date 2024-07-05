package com.MedicalSuppliesSystem.MedicalSupplies.controller.item;

import com.MedicalSuppliesSystem.MedicalSupplies.business.services.interfaces.IItemService;
import com.MedicalSuppliesSystem.MedicalSupplies.controller.ControllerHelper;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.ItemDto;
import com.MedicalSuppliesSystem.MedicalSupplies.enums.ResponseMessageEnum;
import com.MedicalSuppliesSystem.MedicalSupplies.exception.BusinessException;
import com.MedicalSuppliesSystem.MedicalSupplies.model.ConstantStrings;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.SearchParPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ConstantStrings.SUB_ITEM_URL)
public class ItemController extends ControllerHelper {

    Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private IItemService iItemService;

    @RequestMapping(value = "/createItem" , consumes = {MediaType.APPLICATION_JSON_VALUE} , method = RequestMethod.POST)
    public ResponseEntity createItem(@RequestBody ItemDto itemDto)
    {
        logger.info("Start creating item {} ... " , itemDto.toString());
        try{
            if(itemDto != null)
            {
                logger.info("receiving item data to save");
                iItemService.addItem(itemDto);
                logger.info("item saved...");
                return buildResponseEntity(true, ResponseMessageEnum.SUCCESS.getMessage(), ResponseMessageEnum.SUCCESS.getMessage(), HttpStatus.CREATED);
            }
            else
                throw new BusinessException("the item is null");
        }
        catch (Exception exception)
        {
            logger.info("the item has exception : {} " , exception.getMessage());
            return buildExceptionResponseEntity(exception);
        }
    }
    @RequestMapping(value = "/findItem" , consumes = {MediaType.APPLICATION_JSON_VALUE} , method = RequestMethod.POST)
    public ResponseEntity findItem(@RequestBody SearchParPojo searchParPojo)
    {
        logger.info("Start retriving item {} ... " , searchParPojo.toString());
        try{
            if(searchParPojo != null)
            {
                logger.info("retriving item ... ");
                return buildResponseEntity(true, ResponseMessageEnum.SUCCESS.getMessage(), iItemService.findItem(searchParPojo), HttpStatus.CREATED);
            }
            else
                throw new BusinessException("the item is null");
        }
        catch (Exception exception)
        {
            logger.info("the item has exception : {} " , exception.getMessage());
            return buildExceptionResponseEntity(exception);
        }
    }
}
