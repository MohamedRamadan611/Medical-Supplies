package com.MedicalSuppliesSystem.MedicalSupplies.controller;


import com.MedicalSuppliesSystem.MedicalSupplies.dto.MobileListDto;
import com.MedicalSuppliesSystem.MedicalSupplies.enums.SortTypeEnum;
import com.MedicalSuppliesSystem.MedicalSupplies.exception.BusinessException;
import com.MedicalSuppliesSystem.MedicalSupplies.model.ConstantStrings;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.ResponsePojo;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.SearchParPojo;
import com.MedicalSuppliesSystem.MedicalSupplies.utils.JWTUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;

public class ControllerHelper {
    public static SimpleDateFormat formatter;
    public String errorMsg;
    protected boolean canCreate, canEdit, canDelete, canFind, canFindAll, responseByMobileDto, enableCash, isEncodeResponse, isBuiltForMockup;

    public ControllerHelper() {
        canCreate = false;
        canEdit = false;
        canDelete = false;
        canFind = false;
        isEncodeResponse = false;
        formatter = new SimpleDateFormat(ConstantStrings.DATE_FORMATE);
    }

    
    
    protected Pageable buildPageRequest(SearchParPojo searchParPojo) {
        int page = 0;
        int size = 1;
        if (searchParPojo != null && searchParPojo.getPage() != null && searchParPojo.getSize() != null) {
            page = searchParPojo.getPage();
            size = searchParPojo.getSize();
        }
        Sort sortBy = buildSortField(searchParPojo);

        return sortBy != null ? PageRequest.of(page, size, sortBy) : PageRequest.of(page, size);
    }

    private Sort buildSortField(SearchParPojo searchParPojo) {
        Sort sortBy = null;
        if (searchParPojo != null && searchParPojo.getSortObject() != null) {
            if (searchParPojo.getSortObject().getFieldName() != null && !searchParPojo.getSortObject().getFieldName().isEmpty()) {
                String sortingField = searchParPojo.getSortObject().getFieldName();

                sortBy = Sort.by(findSortDirection(searchParPojo.getSortObject().getSortDirection()), sortingField);
            }
        }
        return sortBy;

    }

    private Sort.Direction findSortDirection(String sortDir) {
        Sort.Direction direction = Sort.Direction.ASC;
        if (sortDir != null && sortDir.equalsIgnoreCase(SortTypeEnum.DESC.getSortType())) {
            direction = Sort.Direction.DESC;
        }
        return direction;
    }


    protected ResponseEntity buildExceptionResponseEntity(Exception exception, String headerAuthorization) {

        String exceptionMessage = exception.getMessage() != null ? exception.getMessage() : "";

        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            if (businessException.getParams() != null && businessException.getParams().length > 0) {
                exceptionMessage = exceptionMessage + "-" + Arrays.toString(businessException.getParams());
            }
        }
        return buildResponseEntity(false, exceptionMessage, null, HttpStatus.OK, headerAuthorization);

    }

    protected ResponseEntity buildExceptionResponseEntity(Exception exception) {

        String exceptionMessage = exception.getMessage() != null ? exception.getMessage() : "";

        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            if (businessException.getParams() != null && businessException.getParams().length > 0) {
                exceptionMessage = exceptionMessage + "-" + Arrays.toString(businessException.getParams());
            }
        }
        return buildResponseEntity(false, exceptionMessage, null, HttpStatus.OK);

    }

    protected ResponseEntity buildDecodedExceptionResponseEntity(Exception exception) {
        errorMsg = null;
        String exceptionMessage = exception.getMessage() != null ? exception.getMessage() : "";
        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            if (businessException.getParams() != null && businessException.getParams().length > 0) {
                exceptionMessage = exceptionMessage + "-" + Arrays.toString(businessException.getParams());
            }
        }
        errorMsg = exceptionMessage;
        return buildDecodedResponseEntity(false, exceptionMessage, null, HttpStatus.OK);
    }

//    protected ResponseEntity findObjectResponseEntity(T entity, String headerAuthorization) {
//        return buildResponseEntity(true, null, entity, HttpStatus.OK, headerAuthorization);
//    }

    protected ResponseEntity findObjectResponseEntity(Object object, String headerAuthorization) {
        if (responseByMobileDto) {
            MobileListDto mobileListDto = new MobileListDto(object);
            return buildResponseEntity(true, null, mobileListDto, HttpStatus.OK, headerAuthorization);
        }
        return buildResponseEntity(true, null, object, HttpStatus.OK, headerAuthorization);

    }


    protected void enableResponseCashParameter(HttpServletRequest request, HttpServletResponse response) {
        if (enableCash) {
            response.setHeader("Expires", "300");
            response.setHeader("Cache-Control", "max-age=300, must-revalidate");
            response.setHeader("Pragma", "cache");

        }
    }

    protected ResponseEntity buildResponseEntity(boolean iSuccess, String Message, Object data, HttpStatus httpStatus, String headerAuthorization) {

        ResponsePojo responsePojo = buildResponsePojo(iSuccess, Message, data);
        if (isEncodeResponse) {
            String responsePojoString = "";
            String signKey = Base64.getEncoder().encodeToString(headerAuthorization.getBytes());
            responsePojoString = JWTUtil.encodeJWT(responsePojo, signKey.getBytes());
            return new ResponseEntity<>(responsePojoString, httpStatus);
        } else {
            return new ResponseEntity<>(responsePojo, httpStatus);
        }
    }

    protected ResponseEntity buildResponseEntity(boolean iSuccess, String Message, Object data, HttpStatus httpStatus) {
        ResponsePojo responsePojo = new ResponsePojo(iSuccess, Message, data);
        return new ResponseEntity<>(responsePojo, httpStatus);
    }

    protected ResponseEntity buildDecodedResponseEntity(boolean iSuccess, String Message, Object data, HttpStatus httpStatus) {
        ResponsePojo responsePojo = buildResponsePojo(iSuccess, Message, data);
        return new ResponseEntity<>(responsePojo, httpStatus);
    }

    protected ResponsePojo buildResponsePojo(boolean iSuccess, String Message, Object data) {
        ResponsePojo responsePojo = new ResponsePojo(iSuccess, Message, data);
        return responsePojo;
    }


}
