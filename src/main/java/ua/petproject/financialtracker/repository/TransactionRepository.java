package ua.petproject.financialtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.petproject.financialtracker.model.Transaction;

import java.time.LocalDate;


public interface TransactionRepository extends JpaRepository<Transaction, Long>, TransactionRepositoryCustom {
    Transaction findTransactionById(Long id);
    void deleteTransactionById(Long id);

}
