package com.MedicalSuppliesSystem.MedicalSupplies.controller.stock;

import com.MedicalSuppliesSystem.MedicalSupplies.business.services.interfaces.IStockService;
import com.MedicalSuppliesSystem.MedicalSupplies.controller.ControllerHelper;
import com.MedicalSuppliesSystem.MedicalSupplies.controller.item.ItemController;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.ItemDto;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.StockDto;
import com.MedicalSuppliesSystem.MedicalSupplies.enums.ResponseMessageEnum;
import com.MedicalSuppliesSystem.MedicalSupplies.exception.BusinessException;
import com.MedicalSuppliesSystem.MedicalSupplies.model.ConstantStrings;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.SearchParPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ConstantStrings.SUB_STOCK_URL)
public class StockController extends ControllerHelper {

    Logger logger = LoggerFactory.getLogger(StockController.class);

    @Autowired
    private IStockService iStockService;
    @RequestMapping(value = "/addStock" , consumes = {MediaType.APPLICATION_JSON_VALUE} , method = RequestMethod.POST)
    public ResponseEntity addStock(@RequestBody StockDto stockDto)
    {
        logger.info("Start adding stock {} ... " , stockDto.toString());
        try{
            if(stockDto != null)
            {
                logger.info("receiving stock data to save");
                iStockService.addStock(stockDto);
                logger.info("stock added to database ...");
                return buildResponseEntity(true, ResponseMessageEnum.SUCCESS.getMessage(), ResponseMessageEnum.SUCCESS.getMessage(), HttpStatus.CREATED);
            }
            else
                throw new BusinessException("the stock is null");
        }
        catch (Exception exception)
        {
            logger.info("the stock has exception : {} " , exception.getMessage());
            return buildExceptionResponseEntity(exception);
        }
    }
    @RequestMapping(value = "/findStock" , consumes = {MediaType.APPLICATION_JSON_VALUE} , method = RequestMethod.POST)
    public ResponseEntity findStock(@RequestBody SearchParPojo searchParPojo)
    {
        logger.info("Start retriving stock {} ... " , searchParPojo.toString());
        try{
            if(searchParPojo != null)
            {
                logger.info("retriving stock ... ");
                Pageable pageRequest = buildPageRequest(searchParPojo);
                return buildResponseEntity(true, ResponseMessageEnum.SUCCESS.getMessage(), iStockService.findStock(searchParPojo , pageRequest), HttpStatus.CREATED);
            }
            else
                throw new BusinessException("the stock is null");
        }
        catch (Exception exception)
        {
            logger.info("the stock has exception : {} " , exception.getMessage());
            return buildExceptionResponseEntity(exception);
        }
    }
    @RequestMapping(value = "/findFinishedStock" , consumes = {MediaType.APPLICATION_JSON_VALUE} , method = RequestMethod.POST)
    public ResponseEntity findFinishedStock()
    {
        try {
                logger.info("retriving stock ... ");
                //Pageable pageRequest = buildPageRequest();
                return buildResponseEntity(true, ResponseMessageEnum.SUCCESS.getMessage(), iStockService.findFinishedStock(), HttpStatus.CREATED);
        }
        catch (Exception exception)
        {
            logger.info("the stock has exception : {} " , exception.getMessage());
            return buildExceptionResponseEntity(exception);
        }
    }
}
