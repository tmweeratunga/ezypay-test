package com.ezypay.service.helper;

import com.ezypay.dto.request.SubscriptionRequestDTO;
import com.ezypay.enumerations.DayOfWeeksEnum;
import com.ezypay.enumerations.ErrorMessageEnum;
import com.ezypay.enumerations.SubscriptionTypeEnum;
import com.ezypay.util.DateManager;
import com.ezypay.util.exception.EZYPayException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.Period;

@Service
public class RequestValidationHelper {

    public void validateSubscriptionRequest(SubscriptionRequestDTO request){
        if(request.getAmount() == null){
            throw new EZYPayException(ErrorMessageEnum.SUBSCRIPTION_AMOUNT_CANNOT_BE_EMPTY.getEzypayError());
        }
        if(StringUtils.isEmpty(request.getType())){
            throw new EZYPayException(ErrorMessageEnum.SUBSCRIPTION_TYPE_CANNOT_BE_EMPTY.getEzypayError());
        }
        if(StringUtils.isEmpty(request.getDayOfWeekMonth())){
            throw new EZYPayException(ErrorMessageEnum.SUBSCRIPTION_DATE_MOTH_CANNOT_BE_EMPTY.getEzypayError());
        }
        if(request.getStartDate() == null || request.getEndDate() == null){
            throw new EZYPayException(ErrorMessageEnum.SUBSCRIPTION_START_END_DATE_CANNOT_BE_EMPTY.getEzypayError());
        }

        if(DateManager.isDateAfter(request.getStartDate(),request.getEndDate(),3)){
            throw new EZYPayException(ErrorMessageEnum.INVALID_SUBSCRIPTION_PERIOD.getEzypayError());
        }
        if(!SubscriptionTypeEnum.contains(request.getType())){
            throw new EZYPayException(ErrorMessageEnum.INVALID_SUBSCRIPTION_TYPE.getEzypayError());
        }
        if(SubscriptionTypeEnum.WEEKLY.getCode().equals(request.getType()) &&
                !DayOfWeeksEnum.contains(request.getDayOfWeekMonth())){
            throw new EZYPayException(ErrorMessageEnum.INVALID_DATE_OF_WEEK.getEzypayError());
        }

    }
}
