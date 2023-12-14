package ita.bilabonemmenteksamenback.api;



import ita.bilabonemmenteksamenback.entity.Car;
import ita.bilabonemmenteksamenback.entity.Customer;
import ita.bilabonemmenteksamenback.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
public class CarController {

    private CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
    //gets all cars
    @GetMapping("/api/cars")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    //gets car by id
    @CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
    @GetMapping("/api/cars/getCar/{carId}")
    public ResponseEntity<Car> getCarById(@PathVariable Long carId) {
        Optional<Car> car = carRepository.findById(carId);
        if (car.isPresent()) {
            return ResponseEntity.ok(car.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //creates new car if requestbody is correct
    @CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
    @PostMapping("/api/cars/addCar")
    public Car createCar(@RequestBody Car car){
        return carRepository.save(car);
    }


    //updates car status based on maintenance repair is completed
    @CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
    @PutMapping("/api/cars/setCarAvailable/{carId}")
    public ResponseEntity<String> setCarAvailable(@PathVariable Long carId, @RequestBody Map<String, Boolean> request) {
        try {
            boolean repairComplete = request.get("repairComplete");

            // Fetch the car by ID
            Car car = carRepository.findById(carId)
                    .orElseThrow(() -> new EntityNotFoundException("Car not found"));

            // Set the car status based on repairComplete
            car.setStatus(repairComplete ? "Available" : "Maintenance");

            // Save the updated car
            carRepository.save(car);

            System.out.println("Updated car status: " + car);

            return ResponseEntity.ok("Car status updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update car status: " + e.getMessage());
        }
    }



    //updates car status after creating lending agreement
    @CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
    @PutMapping("/api/cars/updateCarStatus/{carId}")
    public ResponseEntity<String> updateCarStatus(@PathVariable Long carId) {
        Optional<Car> optionalCar = carRepository.findById(carId);

        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setStatus("Reserved");
            carRepository.save(car);
            return ResponseEntity.ok("Car status updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
        }
    }




}
