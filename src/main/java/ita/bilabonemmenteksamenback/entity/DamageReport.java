package ita.bilabonemmenteksamenback.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "damage_reports")
public class DamageReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long damageReportId;

    private String typeOfDamage;
    private BigDecimal repairCost;
    @JsonProperty("repairComplete")
    private boolean repairComplete;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "carId")
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "lendingAgreementId")
    private LendingAgreement lendingAgreement;

    public DamageReport( String typeOfDamage, BigDecimal repairCost, Car car, LendingAgreement lendingAgreement, boolean repairComplete) {
        this.typeOfDamage = typeOfDamage;
        this.repairCost = repairCost;
        this.car = car;
        this.lendingAgreement = lendingAgreement;
        this.repairComplete = repairComplete;
    }
    public DamageReport() {}

    @Override
    public String toString() {
        return "DamageReport{" +
                "damageReportId=" + damageReportId +
                ", typeOfDamage='" + typeOfDamage + '\'' +
                ", repairCost=" + repairCost +
                ", repairComplete=" + repairComplete +
                ", car=" + car +
                ", lendingAgreement=" + lendingAgreement +
                '}';
    }

    public Long getDamageReportId() {
        return damageReportId;
    }

    public void setDamageReportId(Long damageReportId) {
        this.damageReportId = damageReportId;
    }

    public String getTypeOfDamage() {
        return typeOfDamage;
    }

    public void setTypeOfDamage(String typeOfDamage) {
        this.typeOfDamage = typeOfDamage;
    }

    public BigDecimal getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(BigDecimal repairCost) {
        this.repairCost = repairCost;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LendingAgreement getLendingAgreement() {
        return lendingAgreement;
    }

    public void setLendingAgreement(LendingAgreement lendingAgreement) {
        this.lendingAgreement = lendingAgreement;
    }

    public boolean isRepairComplete() {
        return repairComplete;
    }

    public void setRepairComplete(boolean repairComplete) {
        this.repairComplete = repairComplete;
    }
}
