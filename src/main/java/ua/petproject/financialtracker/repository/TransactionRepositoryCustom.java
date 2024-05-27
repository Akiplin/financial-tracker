package ua.petproject.financialtracker.repository;

import java.time.LocalDate;

public interface TransactionRepositoryCustom {
    Double sumOfAllIncomesInPeriod(LocalDate startDate, LocalDate endDate);
    Double sumOfAllCostsInPeriod(LocalDate startDate, LocalDate endDate);
}
