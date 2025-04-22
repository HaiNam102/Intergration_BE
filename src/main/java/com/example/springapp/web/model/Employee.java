package com.example.springapp.web.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Basic;

@Entity
@Table(name = "employee")
public class Employee implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_Number", nullable = false)
    private int employeeNumber;

    @Column(name = "idEmployee", nullable = false)
    private int idEmployee;

    @Column(name = "Last_Name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "First_Name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "SSN", nullable = false)
    private long ssn;

    @Column(name = "Pay_Rate", length = 50)
    private String payRate;

    @Column(name = "PayRates_id")
    private Integer payRatesId;

    @Column(name = "Vacation_Days")
    private Integer vacationDays;

    @Basic
    @Column(name = "Paid_To_Date")
    private Byte paidToDate;

    @Basic
    @Column(name = "Paid_Last_Year")
    private Byte paidLastYear;

    public Employee() {
    }

    public Employee(int employeeNumber, int idEmployee, String lastName, String firstName, long ssn) {
        this.employeeNumber = employeeNumber;
        this.idEmployee = idEmployee;
        this.lastName = lastName;
        this.firstName = firstName;
        this.ssn = ssn;
    }

    public Employee(int employeeNumber, int idEmployee, String lastName, String firstName, long ssn, String payRate,
                    Integer payRatesId, Integer vacationDays, Byte paidToDate, Byte paidLastYear) {
        this.employeeNumber = employeeNumber;
        this.idEmployee = idEmployee;
        this.lastName = lastName;
        this.firstName = firstName;
        this.ssn = ssn;
        this.payRate = payRate;
        this.payRatesId = payRatesId;
        this.vacationDays = vacationDays;
        this.paidToDate = paidToDate;
        this.paidLastYear = paidLastYear;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public String getPayRate() {
        return payRate;
    }

    public void setPayRate(String payRate) {
        this.payRate = payRate;
    }

    public Integer getPayRatesId() {
        return payRatesId;
    }

    public void setPayRatesId(Integer payRatesId) {
        this.payRatesId = payRatesId;
    }

    public Integer getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(Integer vacationDays) {
        this.vacationDays = vacationDays;
    }

    public Byte getPaidToDate() {
        return paidToDate;
    }

    public void setPaidToDate(Byte paidToDate) {
        this.paidToDate = paidToDate;
    }

    public Byte getPaidLastYear() {
        return paidLastYear;
    }

    public void setPaidLastYear(Byte paidLastYear) {
        this.paidLastYear = paidLastYear;
    }
}
