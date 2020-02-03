package com.reward.points.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.reward.points.domain.Transaction;

//We can write interface implement JPA repository by extending JpaRepository<Transaction, Long> and make use of JPA.

@Component
public class TransactionRepository {

	//We query DB with customer number and month just to get that customer transactions for that month and this method will return all transactions 
	public List<Transaction> findTransactionsByCustomerAndMonth(Long customerNumber, int month){		
		Map<Long, List<Transaction>> transactionMap = getTransactionMap();
		if(transactionMap.containsKey(customerNumber)) {			
			return transactionMap.get(customerNumber).stream().filter(t -> t.getDate().getMonthValue() == month).collect(Collectors.toList());			
		}else return  new ArrayList<Transaction>();
	} 
	
	public List<Transaction> findTransactionsByCustomer(Long customerNumber){		
		Map<Long, List<Transaction>> transactionMap = getTransactionMap();
		if(transactionMap.containsKey(customerNumber)) {			
			return transactionMap.get(customerNumber);			
		}else return  new ArrayList<Transaction>();
	} 
	
	private Map<Long, List<Transaction>> getTransactionMap(){
		Map<Long, List<Transaction>> transactionMap = new HashMap<>();
		List<Transaction> transactions = new ArrayList<Transaction>();
		//Customer 123 transactions
		transactions.add(new Transaction(1L, 123L, 46.20, LocalDate.of(2019, 12, 20)));
		transactions.add(new Transaction(2L, 123L, 120.10, LocalDate.of(2019, 12, 18)));
		transactions.add(new Transaction(3L, 123L, 226.66, LocalDate.of(2019, 12, 15)));
		transactions.add(new Transaction(4L, 123L, 98.00, LocalDate.of(2019, 11, 02)));
		transactions.add(new Transaction(5L, 123L, 99.99, LocalDate.of(2019, 11, 24)));
		transactions.add(new Transaction(6L, 123L, 146.23, LocalDate.of(2019, 11, 30)));
		transactions.add(new Transaction(7L, 123L, 999.00, LocalDate.of(2020, 01, 05)));
		transactions.add(new Transaction(8L, 123L, 20.10, LocalDate.of(2020, 01, 22)));
		transactionMap.put(123L, transactions);
		
		//Customer 245 transactions
		List<Transaction> transactions1 = new ArrayList<Transaction>();		
		transactions1.add(new Transaction(1L, 245L, 34.20, LocalDate.of(2019, 12, 21)));
		transactions1.add(new Transaction(2L, 245L, 234.10, LocalDate.of(2019, 12, 15)));
		transactions1.add(new Transaction(3L, 245L, 56.66, LocalDate.of(2019, 12, 05)));
		transactions1.add(new Transaction(4L, 245L, 88.00, LocalDate.of(2019, 11, 12)));
		transactions1.add(new Transaction(5L, 245L, 126.99, LocalDate.of(2019, 11, 04)));
		transactions1.add(new Transaction(6L, 245L, 99.23, LocalDate.of(2019, 11, 10)));
		transactions1.add(new Transaction(7L, 245L, 345.00, LocalDate.of(2020, 01, 15)));
		transactions1.add(new Transaction(8L, 245L, 10.10, LocalDate.of(2020, 01, 02)));
		transactions1.add(new Transaction(8L, 245L, 100.10, LocalDate.of(2020, 01, 24)));
		transactionMap.put(245L, transactions1);
		
		
		return transactionMap;
	}
}
