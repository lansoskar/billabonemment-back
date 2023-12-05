package ita.bilabonemmenteksamenback.config;

import ita.bilabonemmenteksamenback.entity.Car;
import ita.bilabonemmenteksamenback.repository.CarRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
public class DeveloperData implements ApplicationRunner {

    private final CarRepository carRepository;

    public DeveloperData(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    //dummy car list
    private static List<Car> Cars = Arrays.asList(
            new Car("Toyota", "Camry", "Petrol", "Available"),
            new Car("Honda", "Civic", "Hybrid", "Reserved"),
            new Car("Ford", "Mustang", "Diesel", "Available"));

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Controller Started");
        carRepository.saveAll(Cars);
    }
}
