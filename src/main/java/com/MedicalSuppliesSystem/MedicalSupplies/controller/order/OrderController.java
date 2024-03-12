package com.MedicalSuppliesSystem.MedicalSupplies.controller.order;

import com.MedicalSuppliesSystem.MedicalSupplies.business.services.interfaces.IOrderService;
import com.MedicalSuppliesSystem.MedicalSupplies.controller.ControllerHelper;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.OrderDto;
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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ConstantStrings.SUB_ORDER_URL)
public class OrderController extends ControllerHelper {

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IOrderService iOrderService;

    @RequestMapping(value = "/createOrder" , consumes = {MediaType.APPLICATION_JSON_VALUE} , method = RequestMethod.POST)
    public ResponseEntity createOrder(@RequestBody OrderDto orderDto)
    {
        logger.info("Start creating order {} ... " , orderDto.toString());
        try{
            if(orderDto != null)
            {
                logger.info("receiving order data to save");
                iOrderService.createOrder(orderDto);
                logger.info("Order saved...");
                return buildResponseEntity(true, ResponseMessageEnum.SUCCESS.getMessage(), ResponseMessageEnum.SUCCESS.getMessage(), HttpStatus.CREATED);
            }
            else
                throw new BusinessException("the order is null");
        }
        catch (Exception exception)
        {
            logger.info("the order has exception : {} " , exception.getMessage());
            return buildExceptionResponseEntity(exception);
        }
    }
    @RequestMapping(value = "/findOrders" , consumes = {MediaType.APPLICATION_JSON_VALUE} , method = RequestMethod.POST)
    public ResponseEntity findOrders(@RequestBody SearchParPojo searchParPojo)
    {
        logger.info("Start creating order {} ... " , searchParPojo.toString());
        try{
            if(searchParPojo != null)
            {
                logger.info("receiving order data to save");
                Pageable pageRequest = buildPageRequest(searchParPojo);
                logger.info("Order saved...");
                return buildResponseEntity(true, ResponseMessageEnum.SUCCESS.getMessage(), iOrderService.findOrders(searchParPojo,pageRequest), HttpStatus.OK);
            }
            else
                throw new BusinessException("the order is null");
        }
        catch (Exception exception)
        {
            logger.info("the order has exception : {} " , exception.getMessage());
            return buildExceptionResponseEntity(exception);
        }
    }
    @RequestMapping(value = "/findAllOrders" , consumes = {MediaType.APPLICATION_JSON_VALUE} , method = RequestMethod.POST)
    public ResponseEntity findAllOrders(@RequestBody SearchParPojo searchParPojo)
    {
        logger.info("Start creating order {} ... " , searchParPojo.toString());
        try{
            if(searchParPojo != null)
            {
                logger.info("receiving order data to save");

                logger.info("Order saved...");
                return buildResponseEntity(true, ResponseMessageEnum.SUCCESS.getMessage(), iOrderService.findAllOrders(), HttpStatus.OK);
            }
            else
                throw new BusinessException("the order is null");
        }
        catch (Exception exception)
        {
            logger.info("the order has exception : {} " , exception.getMessage());
            return buildExceptionResponseEntity(exception);
        }
    }
}
