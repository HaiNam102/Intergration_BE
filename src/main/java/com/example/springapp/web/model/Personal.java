package com.example.springapp.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Personal")
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_ID", precision = 18)
    private Long employeeId;

    @Column(name = "First_Name", length = 50)
    private String firstName;

    @Column(name = "Last_Name", length = 50)
    private String lastName;

    @Column(name = "Middle_Initial", length = 50)
    private String middleInitial;

    @Column(name = "Address1", length = 50)
    private String address1;

    @Column(name = "Address2", length = 50)
    private String address2;

    @Column(name = "City", length = 50)
    private String city;

    @Column(name = "State", length = 50)
    private String state;

    @Column(name = "Zip", precision = 18)
    private Long zip;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "Phone_Number", length = 50)
    private String phoneNumber;

    @Column(name = "Social_Security_Number", length = 50)
    private String socialSecurityNumber;

    @Column(name = "Drivers_License", length = 50)
    private String driversLicense;

    @Column(name = "Marital_Status", length = 50)
    private String maritalStatus;

    @Column(name = "Gender")
    private Boolean gender;

    @Column(name = "Shareholder_Status")
    private boolean shareholderStatus;

    @Column(name = "Benefit_Plans", precision = 18)
    private Long benefitPlans;

    @Column(name = "Ethnicity", length = 50)
    private String ethnicity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Benefit_Plans", referencedColumnName = "Benefit_Plan_ID", insertable = false, updatable = false)
    private BenefitPlans benefitPlans1;

    @OneToOne(mappedBy = "personal", cascade = CascadeType.ALL)
    @JsonIgnore
    private EmergencyContacts emergencyContacts;

    @OneToOne(mappedBy = "personal", cascade = CascadeType.ALL)
    @JsonIgnore
    private Employment employment;

    @OneToMany(mappedBy = "personal")
    @JsonIgnore
    private List<JobHistory> jobHistories;

    // Getters and Setters
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public boolean isShareholderStatus() {
        return shareholderStatus;
    }

    public void setShareholderStatus(boolean shareholderStatus) {
        this.shareholderStatus = shareholderStatus;
    }

    public Long getBenefitPlans() {
        return benefitPlans;
    }

    public void setBenefitPlans(Long benefitPlans) {
        this.benefitPlans = benefitPlans;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public BenefitPlans getBenefitPlans1() {
        return benefitPlans1;
    }

    public void setBenefitPlans1(BenefitPlans benefitPlans1) {
        this.benefitPlans1 = benefitPlans1;
    }

    public EmergencyContacts getEmergencyContacts() {
        return emergencyContacts;
    }

    public void setEmergencyContacts(EmergencyContacts emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public List<JobHistory> getJobHistories() {
        return jobHistories;
    }

    public void setJobHistories(List<JobHistory> jobHistories) {
        this.jobHistories = jobHistories;
    }
}