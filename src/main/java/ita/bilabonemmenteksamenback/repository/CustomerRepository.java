package ita.bilabonemmenteksamenback.repository;

import ita.bilabonemmenteksamenback.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}