package com.ezypay.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import com.ezypay.enumerations.DayOfWeeksEnum;
import com.ezypay.enumerations.SubscriptionTypeEnum;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.ezypay.dto.request.SubscriptionRequestDTO;
import com.ezypay.enumerations.ErrorMessageEnum;
import com.ezypay.service.helper.RequestValidationHelper;
import com.ezypay.util.exception.EZYPayException;

class RequestValidationHelperTest {

	
	@InjectMocks
	private RequestValidationHelper requestValidationHelper= new RequestValidationHelper();

	@Test
	void validateSubscriptionRequest_NullAmount_Fail() {
		EZYPayException expected = null;
		SubscriptionRequestDTO request = new SubscriptionRequestDTO();
		request.setStartDate(new Date());
		request.setEndDate(new Date());
		request.setType(SubscriptionTypeEnum.DAILY.getCode());
		request.setDayOfWeekMonth(DayOfWeeksEnum.FRIDAY.getCode());
		try {
			requestValidationHelper.validateSubscriptionRequest(request);
		} catch (EZYPayException e){
			expected = e;
		}
		assertEquals(ErrorMessageEnum.SUBSCRIPTION_AMOUNT_CANNOT_BE_EMPTY.getErrorCode(),expected.getEzypayError().getErrorCode());
		assertEquals(ErrorMessageEnum.SUBSCRIPTION_AMOUNT_CANNOT_BE_EMPTY.getErrorMessage(),expected.getEzypayError().getErrorMessage());
	}
	
	@Test
	void validateSubscriptionRequest_NullType_Fail() {
		EZYPayException expected = null;
		SubscriptionRequestDTO request = new SubscriptionRequestDTO();
		request.setAmount(new BigDecimal(10));
		request.setStartDate(new Date());
		request.setEndDate(new Date());
		request.setDayOfWeekMonth(DayOfWeeksEnum.FRIDAY.getCode());

		try {
			requestValidationHelper.validateSubscriptionRequest(request);
		} catch (EZYPayException e){
			expected = e;
		}
		assertEquals(ErrorMessageEnum.SUBSCRIPTION_TYPE_CANNOT_BE_EMPTY.getErrorCode(),expected.getEzypayError().getErrorCode());
		assertEquals(ErrorMessageEnum.SUBSCRIPTION_TYPE_CANNOT_BE_EMPTY.getErrorMessage(),expected.getEzypayError().getErrorMessage());
	}

	@Test
	void validateSubscriptionRequest_NullStartDate_Fail() {
		EZYPayException expected = null;
		SubscriptionRequestDTO request = new SubscriptionRequestDTO();
		request.setAmount(new BigDecimal(10));
		//request.setStartDate(new Date());
		request.setEndDate(new Date());
		request.setType(SubscriptionTypeEnum.DAILY.getCode());
		request.setDayOfWeekMonth(DayOfWeeksEnum.FRIDAY.getCode());

		try {
			requestValidationHelper.validateSubscriptionRequest(request);
		} catch (EZYPayException e){
			expected = e;
		}
		assertEquals(ErrorMessageEnum.SUBSCRIPTION_START_END_DATE_CANNOT_BE_EMPTY.getErrorCode(),expected.getEzypayError().getErrorCode());
		assertEquals(ErrorMessageEnum.SUBSCRIPTION_START_END_DATE_CANNOT_BE_EMPTY.getErrorMessage(),expected.getEzypayError().getErrorMessage());
	}

}
