package com.test.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CoinsControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void makeChangeShouldReturn4MinimunCoins() throws Exception {
		Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/coins/makeChange/1",
				String.class)).contains("Minimum number of of coins :4");
	}
	
	@Test
	public void makeChangeShouldReturn100MinimunCoins() throws Exception {
		Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/coins/makeChange/25",
				String.class)).contains("Minimum number of of coins :100");
	}
	
	@Test
	public void makeChangeShouldReturnBadRequest() throws Exception {
		Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/coins/makeChange/dfgdff",
				String.class)).contains("Bad Request");
	}
}
