package com.ezypay.dto.util;


import com.ezypay.enumerations.ErrorMessageEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * UpayResponse
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EZYPAYResponse implements Serializable{

    private static final long serialVersionUID = -4995625849970553650L;

    private boolean success;
    private Object data;
    private EZYPAYError error;

    public EZYPAYResponse() {

        EZYPAYError error = new EZYPAYError();
        error.setErrorCode(ErrorMessageEnum.NO_ERROR.getErrorCode());
        error.setErrorMessage(ErrorMessageEnum.NO_ERROR.getErrorMessage());
        this.success = true;
        this.error = error;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public EZYPAYError getError() {
        return error;
    }

    public void setError(EZYPAYError error) {
        if(!ErrorMessageEnum.NO_ERROR.getErrorCode().equals(error.getErrorCode())){
            this.success= false;
        }
        this.error = error;
    }

    @Override
    public String toString() {
        return "EZYPAYResponse{" +
                "success=" + success +
                ", data=" + data +
                ", error=" + error +
                '}';
    }
}
