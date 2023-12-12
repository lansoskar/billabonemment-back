package ita.bilabonemmenteksamenback.repository;

import ita.bilabonemmenteksamenback.entity.DamageReport;
import ita.bilabonemmenteksamenback.entity.LendingAgreement;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DamageRepository extends JpaRepository<DamageReport, Long> {
    @EntityGraph(attributePaths = {"car", "lendingAgreement"})
    Optional<DamageReport> findById(Long id);
}
