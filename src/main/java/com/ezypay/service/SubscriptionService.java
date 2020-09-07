package com.ezypay.service;

import com.ezypay.dto.request.SubscriptionRequestDTO;
import com.ezypay.dto.response.SubscriptionResponseDTO;
import com.ezypay.enumerations.DayOfWeeksEnum;
import com.ezypay.enumerations.SubscriptionTypeEnum;
import com.ezypay.service.helper.RequestValidationHelper;
import com.ezypay.util.DateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class SubscriptionService {

    @Autowired
    private RequestValidationHelper requestValidationHelper;

    public SubscriptionResponseDTO addNewSubscription(SubscriptionRequestDTO request){
        requestValidationHelper.validateSubscriptionRequest(request);

        SubscriptionResponseDTO response = new SubscriptionResponseDTO();
        response.setAmount(request.getAmount());
        response.setType(request.getType());
        if (SubscriptionTypeEnum.WEEKLY.getCode().equals(request.getType())) {
            Date startDate = DateManager.nextDateOfWeek(request.getStartDate(), DayOfWeeksEnum.getDayOfWeek(request.getDayOfWeekMonth()));
            response.setInvoiceDate(getInvoiceDateList(startDate,request.getEndDate(),7));
        } else if (SubscriptionTypeEnum.MONTHLY.getCode().equals(request.getType())) {
            Date startDate = DateManager.nextDateOfMonth(request.getStartDate(),Integer.parseInt(request.getDayOfWeekMonth()));
            response.setInvoiceDate(getInvoiceDateList(startDate,request.getEndDate(),30));
        } else if (SubscriptionTypeEnum.DAILY.getCode().equals(request.getType())) {
            response.setInvoiceDate(getInvoiceDateList(request.getStartDate(),request.getEndDate(),1));
        }

        return response;
    }

    private ArrayList<String> getInvoiceDateList(Date startDate,Date endDate,int numberOfDays){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        ArrayList<String> invoiceDate = new ArrayList<>();
        invoiceDate.add(dateFormat.format(startDate));
        Date nextSubDate = startDate;
        while (true) {
             nextSubDate = DateManager.addDate(nextSubDate, 0, 0, numberOfDays);
            if (nextSubDate.compareTo(endDate) < 0) {

                invoiceDate.add(dateFormat.format(nextSubDate));
            } else {
                break;
            }
        }
        return invoiceDate;
    }
}
