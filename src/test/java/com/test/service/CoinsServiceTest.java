package com.test.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.service.impl.CoinsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CoinsServiceTest {

	@InjectMocks
	CoinsServiceImpl coinsService;
	
	@Test
	public void getChangeShouldReturn4MinimunCoins() throws Exception {
		Assertions.assertThat(coinsService.getChange(1f).getBody().get("message").toString()).contains("Minimum number of of coins :4");
	}
	
	@Test
	public void getChangeShouldReturn100MinimunCoins() throws Exception {
		Assertions.assertThat(coinsService.getChange(25f).getBody().get("message").toString()).contains("Minimum number of of coins :100");
	}
	
	@Test
	public void getChangeShouldReturnInvalidBill() throws Exception {
		Assertions.assertThat(coinsService.getChange(null).getBody().get("message").toString()).contains("Invalid bill");
	}
}
