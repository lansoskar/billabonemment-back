package ita.bilabonemmenteksamenback.repository;

import ita.bilabonemmenteksamenback.entity.LendingAgreement;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LendingAgreementRepository extends JpaRepository<LendingAgreement, Long> {
    @EntityGraph(attributePaths = {"car", "customer"})
    Optional<LendingAgreement> findById(Long id);
}
