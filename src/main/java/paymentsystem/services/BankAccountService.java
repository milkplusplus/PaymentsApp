package paymentsystem.services;

import paymentsystem.models.BankAccount;

import java.util.List;


public interface BankAccountService {
    List<BankAccount> selectAll();
    void changeStatusById(long id);
}