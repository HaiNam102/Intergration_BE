package com.example.springapp.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Employment")
public class Employment {

    @Id
    @Column(name = "Employee_ID", precision = 18)
    private Long employeeId;

    @Column(name = "Employment_Status", length = 50)
    private String employmentStatus;

    @Column(name = "Hire_Date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Column(name = "Workers_Comp_Code", length = 50)
    private String workersCompCode;

    @Column(name = "Termination_Date")
    @Temporal(TemporalType.DATE)
    private Date terminationDate;

    @Column(name = "Rehire_Date")
    @Temporal(TemporalType.DATE)
    private Date rehireDate;

    @Column(name = "Last_Review_Date")
    @Temporal(TemporalType.DATE)
    private Date lastReviewDate;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "Employee_ID")
    private Personal personal;

    // Getters and Setters
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getWorkersCompCode() {
        return workersCompCode;
    }

    public void setWorkersCompCode(String workersCompCode) {
        this.workersCompCode = workersCompCode;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public Date getRehireDate() {
        return rehireDate;
    }

    public void setRehireDate(Date rehireDate) {
        this.rehireDate = rehireDate;
    }

    public Date getLastReviewDate() {
        return lastReviewDate;
    }

    public void setLastReviewDate(Date lastReviewDate) {
        this.lastReviewDate = lastReviewDate;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
} 