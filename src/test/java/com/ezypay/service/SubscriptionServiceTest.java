package com.ezypay.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;

import com.ezypay.util.exception.EZYPayException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezypay.dto.request.SubscriptionRequestDTO;
import com.ezypay.dto.response.SubscriptionResponseDTO;
import com.ezypay.enumerations.SubscriptionTypeEnum;
import com.ezypay.service.helper.RequestValidationHelper;

@SpringBootTest
class SubscriptionServiceTest {

	@InjectMocks
	private SubscriptionService subscriptionService = Mockito.spy(new SubscriptionService());

	@Mock
	private RequestValidationHelper requestValidationHelper;

	@Before
	public void initializeMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addNewSubscription_NullSubscriptionRequestDTO_SuccessDaily() {
		SubscriptionRequestDTO subscriptionRequestDTO = new SubscriptionRequestDTO();
		subscriptionRequestDTO.setStartDate(new Date());
		subscriptionRequestDTO.setEndDate(new Date());
		subscriptionRequestDTO.setAmount(new BigDecimal(10));
		subscriptionRequestDTO.setType(SubscriptionTypeEnum.DAILY.getCode());

		SubscriptionResponseDTO response = subscriptionService.addNewSubscription(subscriptionRequestDTO);

		assertNotNull(response);
		assertEquals(SubscriptionTypeEnum.DAILY.getCode(), response.getType());
	}


}
