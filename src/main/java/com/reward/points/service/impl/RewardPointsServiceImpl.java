package com.reward.points.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reward.points.domain.Transaction;
import com.reward.points.repository.TransactionRepository;
import com.reward.points.service.RewardPointsService;

@Service
public class RewardPointsServiceImpl implements RewardPointsService{

	private TransactionRepository transactionRepository;	
	
	@Autowired
	public RewardPointsServiceImpl(TransactionRepository transactionRepository) {		
		this.transactionRepository = transactionRepository;
	}
	
	@Override
	public Integer getRewardPointsForCustomerAndMonth(Long customerNumber, int month){
		List<Transaction> customerTransactions = transactionRepository.findTransactionsByCustomerAndMonth(customerNumber, month);		
		
		return calculatePoints(customerTransactions);
	}

	@Override
	public Integer getTotalRewadPointsForCustomer(Long customerNumber) {
		List<Transaction> customerTransactions = transactionRepository.findTransactionsByCustomer(customerNumber);	
		
		return calculatePoints(customerTransactions);
	}	
	
	
	private int calculatePoints(List<Transaction> customerTransactions) {
		int points = 0;
		for(Transaction t : customerTransactions) {
			if(t.getAmount() > 50) {
				int amount = (int)t.getAmount();
				points += (amount <= 100 ? amount - 50 : 50) + (amount > 100 ? Math.multiplyExact(amount-100, 2) : 0);
			}
		}		
		return points;
		
	}

}
