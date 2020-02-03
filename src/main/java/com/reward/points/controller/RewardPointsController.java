package com.reward.points.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reward.points.service.RewardPointsService;

@RestController
@RequestMapping("reward")
public class RewardPointsController {
	
	
	private RewardPointsService rewardPointsService;
	
	@Autowired
	public RewardPointsController(RewardPointsService rewardPointsService) {		
		this.rewardPointsService = rewardPointsService;
	}

	@GetMapping(value = "/points/{customer}/{month}", produces="application/json")
	public ResponseEntity<Integer> getRewardPointsPerMonth(@PathVariable(required = true) Long customer, @PathVariable(required = true) int month) {
		
		if(customer == null || customer <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}			
		int points = rewardPointsService.getRewardPointsForCustomerAndMonth(customer, month);		
		if(points == 0) {
			return new ResponseEntity("No Reward points for the month provided", HttpStatus.OK);
		}		
		return new ResponseEntity<Integer>(points, HttpStatus.OK);
	}
	
	@GetMapping(value="/points/{customer}/total", produces="application/json")
	public ResponseEntity<Integer> getTotalRewardPoints(@PathVariable(required = true) Long customer){
		if(customer == null || customer <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		int points = rewardPointsService.getTotalRewadPointsForCustomer(customer);		
		
		return new ResponseEntity<Integer>(points, HttpStatus.OK);
	}
}
