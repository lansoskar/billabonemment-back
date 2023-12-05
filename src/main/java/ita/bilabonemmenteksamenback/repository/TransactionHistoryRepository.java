package ita.bilabonemmenteksamenback.repository;

import ita.bilabonemmenteksamenback.entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {
}