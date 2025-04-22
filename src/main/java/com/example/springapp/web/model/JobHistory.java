package com.example.springapp.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Job_History")
public class JobHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", precision = 18)
    private Long id;

    @Column(name = "Employee_ID", precision = 18)
    private Long employeeId;

    @Column(name = "Department", length = 50)
    private String department;

    @Column(name = "Division", length = 50)
    private String division;

    @Column(name = "Start_Date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "End_Date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "Job_Title", length = 50)
    private String jobTitle;

    @Column(name = "Supervisor", precision = 18)
    private Long supervisor;

    @Column(name = "Job_Code", length = 50)
    private String jobCode;

    @Column(name = "Location", length = 50)
    private String location;

    @Column(name = "Departmen_Code", precision = 18)
    private Long departmenCode;

    @Column(name = "Salary_Type", precision = 18)
    private Long salaryType;

    @Column(name = "Pay_Period", length = 50)
    private String payPeriod;

    @Column(name = "Hours_per_Week", precision = 18)
    private Long hoursPerWeek;

    @Column(name = "Hazardous_Training")
    private Boolean hazardousTraining;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Employee_ID", insertable = false, updatable = false)
    private Personal personal;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Long supervisor) {
        this.supervisor = supervisor;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getDepartmenCode() {
        return departmenCode;
    }

    public void setDepartmenCode(Long departmenCode) {
        this.departmenCode = departmenCode;
    }

    public Long getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(Long salaryType) {
        this.salaryType = salaryType;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public Long getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(Long hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public Boolean getHazardousTraining() {
        return hazardousTraining;
    }

    public void setHazardousTraining(Boolean hazardousTraining) {
        this.hazardousTraining = hazardousTraining;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
} 