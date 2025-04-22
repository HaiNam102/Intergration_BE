package com.example.springapp.web.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Benefit_Plans")
public class BenefitPlans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Benefit_Plan_ID", precision = 18)
    private Long benefitPlanId;

    @Column(name = "Plan_Name", length = 50)
    private String planName;

    @Column(name = "Deductable", precision = 18)
    private Long deductable;

    @Column(name = "Percentage_CoPay", length = 50)
    private String percentageCoPay;

    @OneToMany(mappedBy = "benefitPlans1")
    private List<Personal> personals;

    // Getters and Setters
    public Long getBenefitPlanId() {
        return benefitPlanId;
    }

    public void setBenefitPlanId(Long benefitPlanId) {
        this.benefitPlanId = benefitPlanId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Long getDeductable() {
        return deductable;
    }

    public void setDeductable(Long deductable) {
        this.deductable = deductable;
    }

    public String getPercentageCoPay() {
        return percentageCoPay;
    }

    public void setPercentageCoPay(String percentageCoPay) {
        this.percentageCoPay = percentageCoPay;
    }

    public List<Personal> getPersonals() {
        return personals;
    }

    public void setPersonals(List<Personal> personals) {
        this.personals = personals;
    }
}