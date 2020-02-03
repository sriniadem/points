package com.reward.points.service;

public interface RewardPointsService {

	public Integer getRewardPointsForCustomerAndMonth(Long customer, int month);
	
	public Integer getTotalRewadPointsForCustomer(Long customer);
}
