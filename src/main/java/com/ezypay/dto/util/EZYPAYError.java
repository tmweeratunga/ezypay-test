package com.ezypay.dto.util;

import com.ezypay.enumerations.ErrorMessageEnum;

import java.io.Serializable;

public class EZYPAYError implements Serializable{

    private static final long serialVersionUID = -1477286624084487450L;

    private String errorCode;
    private String errorMessage;
    private String customerErrorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getCustomerErrorMessage() {
        return customerErrorMessage;
    }

    public void setCustomerErrorMessage(String customerErrorMessage) {
        this.customerErrorMessage = customerErrorMessage;
    }

    public void setError(ErrorMessageEnum messageEnum) {
        this.errorCode = messageEnum.getErrorCode();
        this.errorMessage = messageEnum.getErrorMessage();
        this.customerErrorMessage = messageEnum.getCustomerErrorMessage();
    }

    public EZYPAYError(ErrorMessageEnum messageEnum) {
        this.errorCode = messageEnum.getErrorCode();
        this.errorMessage = messageEnum.getErrorMessage();
        this.customerErrorMessage = messageEnum.getCustomerErrorMessage();
    }

    public EZYPAYError() {}

    @Override
    public String toString() {
        return "EZYPAYError{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", customerErrorMessage='" + customerErrorMessage + '\'' +
                '}';
    }
}
