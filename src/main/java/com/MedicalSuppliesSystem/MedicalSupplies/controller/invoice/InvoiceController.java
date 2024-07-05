package com.MedicalSuppliesSystem.MedicalSupplies.controller.invoice;

import com.MedicalSuppliesSystem.MedicalSupplies.business.services.interfaces.IInvoiceService;
import com.MedicalSuppliesSystem.MedicalSupplies.controller.ControllerHelper;
import com.MedicalSuppliesSystem.MedicalSupplies.controller.item.ItemController;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.InvoicesDto;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.ItemDto;
import com.MedicalSuppliesSystem.MedicalSupplies.enums.ResponseMessageEnum;
import com.MedicalSuppliesSystem.MedicalSupplies.exception.BusinessException;
import com.MedicalSuppliesSystem.MedicalSupplies.model.ConstantStrings;
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
@RequestMapping(ConstantStrings.SUB_INVOICE_URL)
public class InvoiceController extends ControllerHelper {
    Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired
    private IInvoiceService invoiceService;

    @RequestMapping(value = "/createItem" , consumes = {MediaType.APPLICATION_JSON_VALUE} , method = RequestMethod.POST)
    public ResponseEntity createItem(@RequestBody InvoicesDto invoicesDto)
    {
        logger.info("Start creating item {} ... " , invoicesDto.toString());
        try{
            if(invoicesDto != null)
            {
                logger.info("receiving item data to save");
                invoiceService.addInvoice(invoicesDto);
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
}
