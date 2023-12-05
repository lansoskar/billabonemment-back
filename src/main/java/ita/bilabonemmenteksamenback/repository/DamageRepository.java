package ita.bilabonemmenteksamenback.repository;

import ita.bilabonemmenteksamenback.entity.DamageReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageRepository extends JpaRepository<DamageReport, Long> {
}
