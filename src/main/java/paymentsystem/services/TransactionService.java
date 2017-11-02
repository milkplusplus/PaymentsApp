package paymentsystem.services;

import java.util.List;

import paymentsystem.models.Transfer;

public interface TransactionService {
	List<Transfer> selectAll();

}
