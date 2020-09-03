package com.ezypay.controller;

import com.ezypay.dto.request.SubscriptionRequestDTO;
import com.ezypay.dto.response.SubscriptionResponseDTO;
import com.ezypay.dto.util.EZYPAYResponse;
import com.ezypay.service.SubscriptionService;
import com.ezypay.util.logs.LogHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class SubscriptionController {

    @Autowired
    private LogHandler logHandler;

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping(value = "add-subscription")
    public EZYPAYResponse findByName(@RequestBody SubscriptionRequestDTO request) {
        logHandler.logInfo("ADD SUBSCRIPTION REQUEST ",request,SubscriptionRequestDTO.class);
        SubscriptionResponseDTO subscriptionResponse = subscriptionService.addNewSubscription(request);
        EZYPAYResponse response = new EZYPAYResponse();
        response.setData(subscriptionResponse);
        logHandler.logInfo("ADD SUBSCRIPTION RESPONSE ",response,EZYPAYResponse.class);
        return response;
    }
}
