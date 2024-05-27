package ua.petproject.financialtracker.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean profitability;
    private Double money;
    private String category;
    @Column(updatable = false)
    private LocalDate date;
    @Column(updatable = false)
    private LocalTime time;
    private String description;

    @PrePersist
    public void addDateAndTime(){
        this.date = LocalDate.now();
        this.time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    @PostPersist
    public void afterCreateTransaction(){
        if(!profitability){
            money = -money;
        }
    }






}
