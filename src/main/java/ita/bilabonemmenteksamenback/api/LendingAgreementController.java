package ita.bilabonemmenteksamenback.api;


import ita.bilabonemmenteksamenback.entity.Car;
import ita.bilabonemmenteksamenback.entity.Customer;
import ita.bilabonemmenteksamenback.entity.LendingAgreement;
import ita.bilabonemmenteksamenback.repository.CarRepository;
import ita.bilabonemmenteksamenback.repository.CustomerRepository;
import ita.bilabonemmenteksamenback.repository.LendingAgreementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class LendingAgreementController {

    private final LendingAgreementRepository lendingAgreementRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;

    public LendingAgreementController(
            LendingAgreementRepository lendingAgreementRepository,
            CarRepository carRepository,
            CustomerRepository customerRepository) {
        this.lendingAgreementRepository = lendingAgreementRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }

    //lendingAgreementService.getAllLendingAgreements();
    //gets all lending agreements
    @GetMapping("/api/lendingAgreements")
    public ResponseEntity<List<LendingAgreement>> getAllLendingAgreements() {
        List<LendingAgreement> lendingAgreements = lendingAgreementRepository.findAll();
        return ResponseEntity.ok(lendingAgreements);
    }

    //get lendingagreement by id
    @GetMapping("/api/lendingAgreements/getLendingAgreement/{lendingAgreementId}")
    public ResponseEntity<LendingAgreement> getLendingAgreementById(@PathVariable Long lendingAgreementId){
        Optional<LendingAgreement> lendingAgreement = lendingAgreementRepository.findById(lendingAgreementId);
        if (lendingAgreement.isPresent()) {
            return ResponseEntity.ok(lendingAgreement.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //creates lendingagreement if requestbody is correct, takes id of car and customer to get full class for constructor
    @PostMapping("/api/lendingAgreements/createLendingAgreement")
    public ResponseEntity<String> createLendingAgreement(@RequestBody LendingAgreement lendingAgreement) {
        try {
            Car car = carRepository.findById(lendingAgreement.getCar().getCarId())
                    .orElseThrow(() -> new EntityNotFoundException("Car not found"));

            Customer customer = customerRepository.findById(lendingAgreement.getCustomer().getCustomerId())
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

            lendingAgreement.setCustomer(customer);
            lendingAgreement.setCar(car);
            LendingAgreement savedAgreement = lendingAgreementRepository.save(lendingAgreement);

            System.out.println("Received lending agreement: " + lendingAgreement);
            return ResponseEntity.ok("Lending agreement created successfully! ID: " + savedAgreement.getLendingAgreementId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create lending agreement: " + e.getMessage());
        }
    }
}
