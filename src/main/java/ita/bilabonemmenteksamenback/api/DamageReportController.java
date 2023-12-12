package ita.bilabonemmenteksamenback.api;


import ita.bilabonemmenteksamenback.entity.Car;
import ita.bilabonemmenteksamenback.entity.Customer;
import ita.bilabonemmenteksamenback.entity.DamageReport;
import ita.bilabonemmenteksamenback.entity.LendingAgreement;
import ita.bilabonemmenteksamenback.repository.CarRepository;
import ita.bilabonemmenteksamenback.repository.DamageRepository;
import ita.bilabonemmenteksamenback.repository.LendingAgreementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class DamageReportController {
    private final DamageRepository damageRepository;
    private final CarRepository carRepository;
    private final LendingAgreementRepository lendingAgreementRepository;

    public DamageReportController(DamageRepository damageRepository, CarRepository carRepository, LendingAgreementRepository lendingAgreementRepository) {
        this.damageRepository = damageRepository;
        this.carRepository = carRepository;
        this.lendingAgreementRepository = lendingAgreementRepository;
    }

    //get all damage reports
    @GetMapping("/api/damageReports")
    public ResponseEntity<List<DamageReport>> getAllDamageReports(){
        List<DamageReport> damageReports = damageRepository.findAll();
        return ResponseEntity.ok(damageReports);
    }


    //creates Damage report if requestbody is correct, takes id of car and lendingagreement and gets full objects-
    //-to put in constructor, also sets associated car status to maintenance
    @PostMapping("/api/damageReport/createDamageReport")
    public ResponseEntity<String> createDamageReport(@RequestBody DamageReport damageReport){
        try {
            Car car = carRepository.findById(damageReport.getCar().getCarId())
                    .orElseThrow(() -> new EntityNotFoundException("Car not found"));

            LendingAgreement lendingAgreement = lendingAgreementRepository.findById(damageReport.getLendingAgreement().getLendingAgreementId())
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

            damageReport.setCar(car);
            damageReport.setLendingAgreement(lendingAgreement);
            DamageReport savedReport = damageRepository.save(damageReport);

            car.setStatus("Maintenance");
            carRepository.save(car);

            System.out.println("Received Damage report: " + savedReport);
            return ResponseEntity.ok("Damage Report created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create Damage report: " + e.getMessage());
        }
        }

        //updates status of repair complete
        @PutMapping("/api/damageReports/updateRepairComplete/{reportId}")
        public ResponseEntity<String> updateRepairComplete(@PathVariable Long reportId, @RequestBody Map<String, Boolean> request) {
            try {
                DamageReport damageReport = damageRepository.findById(reportId)
                        .orElseThrow(() -> new EntityNotFoundException("Damage report not found"));

                boolean newRepairCompleteValue = request.get("repairComplete");

                damageReport.setRepairComplete(newRepairCompleteValue);
                damageRepository.save(damageReport);


                return ResponseEntity.ok("Damage report updated successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update damage report: " + e.getMessage());
            }
        }

    }


