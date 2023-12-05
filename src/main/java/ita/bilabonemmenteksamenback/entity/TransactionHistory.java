package ita.bilabonemmenteksamenback.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_history")
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionHistoryId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "lending_agreement_id")
    private LendingAgreement lendingAgreement;


    private LocalDateTime transactionTime; // time of transaction
    private String transactionType; // Lease, Return, etc.
}
