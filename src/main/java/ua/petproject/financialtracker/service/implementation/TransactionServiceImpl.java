package ua.petproject.financialtracker.service.implementation;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ua.petproject.financialtracker.model.Transaction;
import ua.petproject.financialtracker.repository.TransactionRepository;
import ua.petproject.financialtracker.service.TransactionService;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
@Primary
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public List<Transaction> findAllTransactions() {
        return repository.findAll();
    }

    @Override
    public Transaction findTransactionById(Long id) {
        return repository.findTransactionById(id);
    }

    @Override
    public String updateTransaction(Transaction transaction) {
        repository.save(transaction);
        return "transaction was successfully updated";
    }

    @Override
    @Transactional
    public void deleteTransaction(Long id) {
        repository.deleteTransactionById(id);
    }

    @Override
    public Double sumOfAllIncomesInPeriod(LocalDate startDate, LocalDate endDate) {
        return repository.sumOfAllIncomesInPeriod(startDate, endDate);
    }

    @Override
    public Double sumOfAllCostsInPeriod(LocalDate startDate, LocalDate endDate) {
        return repository.sumOfAllCostsInPeriod(startDate,endDate);
    }

}
