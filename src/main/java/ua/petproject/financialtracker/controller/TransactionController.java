package ua.petproject.financialtracker.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.petproject.financialtracker.model.Transaction;
import ua.petproject.financialtracker.service.TransactionService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/transactions")
@AllArgsConstructor
public class TransactionController {
    private final TransactionService service;
    @GetMapping
    public List<Transaction> findAllTransactions(){
        return service.findAllTransactions();
    }

    @GetMapping("/incomes/{startDate}/{endDate}")
    public Double sumOfAllIncomesInPeriod(@PathVariable LocalDate startDate,@PathVariable LocalDate endDate) {
        return service.sumOfAllIncomesInPeriod(startDate, endDate);
    }

    @GetMapping("/costs/{startDate}/{endDate}")
    public Double sumOfAllCostsInPeriod(@PathVariable LocalDate startDate,@PathVariable LocalDate endDate) {
        return service.sumOfAllCostsInPeriod(startDate, endDate);
    }

    @GetMapping("/{id}")
    public Transaction findTransactionById(@PathVariable Long id){
        return service.findTransactionById(id);
    }

    @PostMapping("/save")
    public Transaction saveTransaction(@RequestBody Transaction transaction){
        return service.saveTransaction(transaction);
    }

    @PutMapping("/update")
    public String updateTransaction(@RequestBody Transaction transaction){
        return service.updateTransaction(transaction);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransaction(@PathVariable Long id){
        service.deleteTransaction(id);
    }


}
