package com.MedicalSuppliesSystem.MedicalSupplies.model;

public abstract class ConstantStrings {

    public static final String SIGNING_KEY = "secretkey";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String PUB_SUB_PATH = "/pub-sub";
    public static final String X_FORWARDED_AUTHORIZATION = "X-Forwarded-Authorization";
    public static final String SUB_MOBILE_URL = "/mobile";

    public static final String SUB_CASHIER_URL = "/cashier";
    //public static final String DATE_FORMATE = "dd-MM-yyyy";
    public static final String DATE_FORMATE = "yyyy-MM-dd";
    public static final String UNILEVER_ROUTING_CAN_ACCESS = "UnileverRoutingService/UserManagementBE/validateUserAccess/canAccess";
    public static final String MOBILE_DATE_FORMAT = "yyyy.MM.dd-HH:mm:ss";

    public static final String DEFAULT_PAGE_NO = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    public static final String DEFAULT_SORT_BY = "invoiceNo";
    public static final String DEFAULT_SORT_DIR = "asc";

    public static final String MAIN_REPORT_PATH = "reports/";
    public static final String NEW_COLLECTION_REPORT = "new_collections";
    public static final String REJECTED_PAYMENT_REPORT = "rejected_payment";
    public static final String NEW_PAYMENT_REPORT = "new_payment";
    public static final String JASPER_EXTENSION = ".jasper";

}
