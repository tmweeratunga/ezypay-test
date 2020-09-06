package com.ezypay.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezypay.dto.request.SubscriptionRequestDTO;
import com.ezypay.dto.response.SubscriptionResponseDTO;
import com.ezypay.enumerations.SubscriptionTypeEnum;

@SpringBootTest
class SubscriptionServiceTest {

	@InjectMocks
	private SubscriptionService subscriptionService = Mockito.spy(new SubscriptionService());

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

	@Test
	public void addNewSubscription_NullSubscriptionRequestDTO_SuccessWeekly() {
		SubscriptionRequestDTO subscriptionRequestDTO = new SubscriptionRequestDTO();
		subscriptionRequestDTO.setStartDate(new Date());
		subscriptionRequestDTO.setEndDate(new Date());
		subscriptionRequestDTO.setAmount(new BigDecimal(10));
		subscriptionRequestDTO.setType(SubscriptionTypeEnum.WEEKLY.getCode());
		SubscriptionResponseDTO response = subscriptionService.addNewSubscription(subscriptionRequestDTO);
		assertNotNull(response);
		assertEquals(SubscriptionTypeEnum.WEEKLY.getCode(), response.getType());
	}

	@Test
	public void addNewSubscription_NullSubscriptionRequestDTO_SuccessMonthly() {
		SubscriptionRequestDTO subscriptionRequestDTO = new SubscriptionRequestDTO();
		subscriptionRequestDTO.setStartDate(new Date());
		subscriptionRequestDTO.setEndDate(new Date());
		subscriptionRequestDTO.setAmount(new BigDecimal(10));
		subscriptionRequestDTO.setType(SubscriptionTypeEnum.MONTHLY.getCode());
		SubscriptionResponseDTO response = subscriptionService.addNewSubscription(subscriptionRequestDTO);
		assertNotNull(response);
		assertEquals(SubscriptionTypeEnum.MONTHLY.getCode(), response.getType());
	}
}
