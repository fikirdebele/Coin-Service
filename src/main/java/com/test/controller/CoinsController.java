package com.test.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.CoinsService;

@RestController
@RequestMapping("/api/v1/coins")
public class CoinsController {
	
	@Autowired
	private CoinsService coinsService;
	
	@GetMapping("/makeChange/{bill}")
	public ResponseEntity<Map<String,Object>> makeChange(@PathVariable Float bill){
		return coinsService.getChange(bill);
	}

}
