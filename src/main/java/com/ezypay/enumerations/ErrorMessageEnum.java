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
