package com.reward.points.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.reward.points.repository.TransactionRepository;
import com.reward.points.service.RewardPointsService;

@RunWith(SpringRunner.class)
public class RewardPointsServiceImplTest {

	
    
    private RewardPointsService rewardPointsService;
 
    @MockBean
    private TransactionRepository transactionRepository;
    
    @Before
    public void init() {
    	MockitoAnnotations.initMocks(this);
    	rewardPointsService = new RewardPointsServiceImpl(transactionRepository);
    }
    
    @Test
    public void testGetRewardPointsForCustomerAndMonth() {
    	when(transactionRepository.findTransactionsByCustomerAndMonth(123L, 12)).thenCallRealMethod();
    	int points = rewardPointsService.getRewardPointsForCustomerAndMonth(123L, 12);    	
    	assertEquals(392, points);
    }
    
    @Test
    public void testGetTotalRewadPointsForCustomer() {
    	when(transactionRepository.findTransactionsByCustomer(245L)).thenCallRealMethod();
    	int points = rewardPointsService.getTotalRewadPointsForCustomer(245L);    	
    	assertEquals(1103, points);
    }
}
