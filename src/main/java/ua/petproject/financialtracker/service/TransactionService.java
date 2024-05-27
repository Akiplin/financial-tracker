package ua.petproject.financialtracker.service;

import ua.petproject.financialtracker.model.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);
    List<Transaction> findAllTransactions();
    Transaction findTransactionById(Long id);
    String updateTransaction(Transaction transaction);
    void deleteTransaction(Long id);
    Double sumOfAllIncomesInPeriod(LocalDate startDate, LocalDate endDate);
    Double sumOfAllCostsInPeriod(LocalDate startDate, LocalDate endDate);

}
