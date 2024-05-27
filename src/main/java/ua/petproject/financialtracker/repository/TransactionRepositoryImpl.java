package ua.petproject.financialtracker.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class TransactionRepositoryImpl implements TransactionRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Double sumOfAllIncomesInPeriod(LocalDate startDate, LocalDate endDate) {
        String jpql = "SELECT SUM(t.money) FROM Transaction t WHERE t.date BETWEEN :startDate AND :endDate AND t.profitability = true ";
        TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
        query.setParameter("startDate",startDate);
        query.setParameter("endDate", endDate);
        return query.getSingleResult();
    }

    @Override
    public Double sumOfAllCostsInPeriod(LocalDate startDate, LocalDate endDate) {
        String jpql = "SELECT SUM(t.money) FROM Transaction t WHERE t.date BETWEEN :startDate AND :endDate AND t.profitability = false ";
        TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
        query.setParameter("startDate",startDate);
        query.setParameter("endDate", endDate);
        return query.getSingleResult();
    }
}
