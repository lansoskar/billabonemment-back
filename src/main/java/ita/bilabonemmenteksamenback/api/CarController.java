package ita.bilabonemmenteksamenback.api;



import ita.bilabonemmenteksamenback.entity.Car;
import ita.bilabonemmenteksamenback.repository.CarRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CarController {

    private CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    //gets all cars
    @GetMapping("/api/cars")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
