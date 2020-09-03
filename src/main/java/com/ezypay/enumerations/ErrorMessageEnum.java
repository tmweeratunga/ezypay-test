package com.ezypay.enumerations;

import com.ezypay.dto.util.EZYPAYError;

/**
 * ErrorMessageEnum
 */
public enum ErrorMessageEnum {

    //Error message can generate from IPG portal
    NO_ERROR("0-0000", "No Error", "No Error")
    ,SOMETHING_WENT_WRONG("0-0001", "Something went wrong", "Something went wrong.")
    ,NULL_POINTER_EXCEPTION("0-0002", "NullPointer Exception","Something went wrong.")
    ,RUNTIME_EXCEPTION("0-0003", "Runtime Exception","Runtime Exception")
    ,SUBSCRIPTION_AMOUNT_CANNOT_BE_EMPTY("1-0001","Subscription amount can not be empty","Subscription amount can not be empty")
    ,SUBSCRIPTION_TYPE_CANNOT_BE_EMPTY("1-0002","Subscription type can not be empty","Subscription type can not be empty")
    ,SUBSCRIPTION_DATE_MOTH_CANNOT_BE_EMPTY("1-0003","Subscription Date Month can not be empty","Subscription Date Month can not be empty")
    ,SUBSCRIPTION_START_END_DATE_CANNOT_BE_EMPTY("1-0004","Subscription Star / End Date can not be empty","Subscription  Star / End Date can not be empty")
    ,INVALID_SUBSCRIPTION_TYPE("1-0005","Invalid subscription type","Invalid subscription type")
    ,INVALID_DATE_OF_WEEK("1-0006","Invalid  date of week","Invalid  date of week")
    ,INVALID_SUBSCRIPTION_PERIOD("1-0007","Invalid subscription period","subscription period")
    ;
        /**
     * The error code.
     */
    private String errorCode;

    /**
     * The error message.
     */
    private String errorMessage;

    private String customerErrorMessage;

    /**
     * The IPG error.
     */
    private EZYPAYError ezypayError = new EZYPAYError();

    /**
     * Instantiates a new error message enum.
     *
     * @param errorCode    the error code
     * @param errorMessage the error message
     */
    private ErrorMessageEnum(String errorCode, String errorMessage, String customerErrorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.customerErrorMessage = customerErrorMessage;
        this.ezypayError.setErrorCode(errorCode);
        this.ezypayError.setErrorMessage(errorMessage);
        this.ezypayError.setCustomerErrorMessage(customerErrorMessage);
    }

    public static String getActionByStatusCode(String statusCode){
        for (ErrorMessageEnum errorMessageEnum : ErrorMessageEnum.values()) {
            if (errorMessageEnum.errorCode.equals(statusCode)) {
                return errorMessageEnum.customerErrorMessage;
            }
        }
        return SOMETHING_WENT_WRONG.customerErrorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public EZYPAYError getEzypayError() {
        return ezypayError;
    }

    public String getCustomerErrorMessage() {
        return customerErrorMessage;
    }

}
