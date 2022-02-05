package com.test.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface CoinsService {

	
	ResponseEntity<Map<String, Object>> getChange(Float bill);

}
