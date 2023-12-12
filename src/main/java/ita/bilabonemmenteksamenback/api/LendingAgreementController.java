package ita.bilabonemmenteksamenback.api;


import ita.bilabonemmenteksamenback.entity.Car;
import ita.bilabonemmenteksamenback.entity.Customer;
import ita.bilabonemmenteksamenback.entity.LendingAgreement;
import ita.bilabonemmenteksamenback.repository.CarRepository;
import ita.bilabonemmenteksamenback.repository.CustomerRepository;
import ita.bilabonemmenteksamenback.repository.LendingAgreementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class LendingAgreementController {

    private LendingAgreementRepository lendingAgreementRepository;
    private CarRepository carRepository;
    private CustomerRepository customerRepository;

    public LendingAgreementController(LendingAgreementRepository lendingAgreementRepository, CarRepository carRepository, CustomerRepository customerRepository) {
        this.lendingAgreementRepository = lendingAgreementRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }

    // gets all lending agreements
    @GetMapping("/api/lendingAgreements")
    public List<LendingAgreement> getAllLendingAgreements(){return lendingAgreementRepository.findAll();}


    // creates new lending agreement if the body of the request is correct
    //takes data from requestbody and sets the associated car and customer to the lendingagreement
    @PostMapping("/api/lendingAgreement/createLendingAgreement")
    public ResponseEntity<String> createLendingAgreement(@RequestBody LendingAgreement lendingAgreement) {
        try {
            Car car = carRepository.findById(lendingAgreement.getCar().getCarId()).orElseThrow(() -> new EntityNotFoundException("Car not found"));

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
