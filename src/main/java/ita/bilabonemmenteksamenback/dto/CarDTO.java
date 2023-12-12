package ita.bilabonemmenteksamenback.dto;

public class CarDTO {
    private Long carId;
    private String fuelType;
    private String make;
    private String model;
    private String status;

    public CarDTO(Long carId, String fuelType, String make, String model, String status) {
        this.carId = carId;
        this.fuelType = fuelType;
        this.make = make;
        this.model = model;
        this.status = status;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
