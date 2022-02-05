package com.test.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.service.CoinsService;

@Service
public class CoinsServiceImpl implements CoinsService {

	@Value("#{'${coins}'.split(',')}")
	private double[] coins;

	private int change(float bill) {
		int quarter = (int) (bill / 0.25);
		bill -= quarter * 0.25;

		int dime = (int) (bill / 0.1);
		bill -= dime * 0.1;

		int nickel = (int) (bill / 0.05);
		bill -= nickel * 0.05;

		int penny = (int) (bill * 100);
		bill -= penny * 0.01;

		return quarter + dime + nickel + penny;
	}

	@Override
	public ResponseEntity<Map<String, Object>> getChange(Float bill) {
		Map<String, Object> response = new HashMap<>();
		if (bill == null || bill <= 0) {
			response.put("message", "Invalid bill");
			return ResponseEntity.badRequest().body(response);
		}

		int noOfCoins = change(Float.valueOf(bill));
		if (noOfCoins <= 0) {
			response.put("message", "Does not have enough coins to make change with " + bill);
			return ResponseEntity.ok().body(response);
		}

		response.put("message", "Minimum number of of coins :" + change(bill));
		return ResponseEntity.ok().body(response);

	}

	
}
