package ita.bilabonemmenteksamenback.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carId;

    private String make;
    private String model;
    private String fuelType;
    private String status; // reserved, Available, Maintenance

    public Car(Long carId, String make, String model, String fuelType, String status) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.fuelType = fuelType;
        this.status = status;
    }

    public Car() {}


    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
