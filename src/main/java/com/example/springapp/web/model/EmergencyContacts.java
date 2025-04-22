package com.example.springapp.web.model;

import javax.persistence.*;

@Entity
@Table(name = "Emergency_Contacts")
public class EmergencyContacts {

    @Id
    @Column(name = "Employee_ID", precision = 18)
    private Long employeeId;

    @Column(name = "Emergency_Contact_Name", length = 50)
    private String emergencyContactName;

    @Column(name = "Phone_Number", length = 50)
    private String phoneNumber;

    @Column(name = "Relationship", length = 50)
    private String relationship;

    @OneToOne
    @JoinColumn(name = "Employee_ID")
    private Personal personal;

    // Getters and Setters
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
} 