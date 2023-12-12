package ita.bilabonemmenteksamenback.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "lending_agreements")
public class LendingAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lendingAgreementId;

    //join customer and car id's to the lending agreement and a start date and end date
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    private LocalDate startDate;
    private LocalDate endDate;
    private String pickupLocation;

    public LendingAgreement( Customer customer, Car car, LocalDate startDate, LocalDate endDate, String pickupLocation) {
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickupLocation = pickupLocation;
    }
    public LendingAgreement() {}

    @Override
    public String toString() {
        return "LendingAgreement{" +
                "lendingAgreementId=" + lendingAgreementId +
                ", customer=" + (customer != null ? customer.getCustomerId() : "null") +
                ", car=" + (car != null ? car.getCarId() : "null") +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }


    public Long getLendingAgreementId() {
        return lendingAgreementId;
    }

    public void setLendingAgreementId(Long lendingAgreementId) {
        this.lendingAgreementId = lendingAgreementId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
}
