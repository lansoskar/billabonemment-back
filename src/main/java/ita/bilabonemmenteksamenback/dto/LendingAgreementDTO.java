package ita.bilabonemmenteksamenback.dto;

import ita.bilabonemmenteksamenback.entity.LendingAgreement;

import java.time.LocalDate;

public class LendingAgreementDTO {
    private Long lendingAgreementId;
    private CarDTO car;
    private CustomerDTO customer;
    private LocalDate startDate;
    private LocalDate endDate;

    public LendingAgreementDTO(Long lendingAgreementId, CarDTO car, CustomerDTO customer, LocalDate startDate, LocalDate endDate) {
        this.lendingAgreementId = lendingAgreementId;
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getLendingAgreementId() {
        return lendingAgreementId;
    }

    public void setLendingAgreementId(Long lendingAgreementId) {
        this.lendingAgreementId = lendingAgreementId;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
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
}
