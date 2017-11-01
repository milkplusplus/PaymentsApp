package paymentsystem.services;

import java.util.List;

import paymentsystem.models.Transaction;

public interface TransactionService {
	List<Transaction> selectAll();

}
