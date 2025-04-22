package com.example.springapp.web.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "pay_rates")
public class PayRates implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pay_rates")
    private int idPayRates;

    @Column(name = "Pay_Rate_Name", nullable = false, length = 100)
    private String payRateName;

    @Column(name = "Value", nullable = false)
    private long value;

    @Column(name = "Tax_Percentage", nullable = false)
    private long taxPercentage;

    @Column(name = "Pay_Type", nullable = false)
    private int payType;

    @Column(name = "Pay_Amount", nullable = false)
    private long payAmount;

    @Column(name = "PT_Level_C", nullable = false)
    private long ptLevelC;

    public PayRates() {
    }

    public PayRates(int idPayRates, String payRateName, long value, long taxPercentage, int payType, long payAmount, long ptLevelC) {
        this.idPayRates = idPayRates;
        this.payRateName = payRateName;
        this.value = value;
        this.taxPercentage = taxPercentage;
        this.payType = payType;
        this.payAmount = payAmount;
        this.ptLevelC = ptLevelC;
    }

    public int getIdPayRates() {
        return this.idPayRates;
    }

    public void setIdPayRates(int idPayRates) {
        this.idPayRates = idPayRates;
    }

    public String getPayRateName() {
        return this.payRateName;
    }

    public void setPayRateName(String payRateName) {
        this.payRateName = payRateName;
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getTaxPercentage() {
        return this.taxPercentage;
    }

    public void setTaxPercentage(long taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public int getPayType() {
        return this.payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public long getPayAmount() {
        return this.payAmount;
    }

    public void setPayAmount(long payAmount) {
        this.payAmount = payAmount;
    }

    public long getPtLevelC() {
        return this.ptLevelC;
    }

    public void setPtLevelC(long ptLevelC) {
        this.ptLevelC = ptLevelC;
    }

}