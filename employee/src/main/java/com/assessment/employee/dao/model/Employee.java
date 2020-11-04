package com.assessment.employee.dao.model;


import com.assessment.employee.constants.ServiceConstants;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    @NotBlank(message = ServiceConstants.FIRST_NAME_MANDATORY_MESSAGE)
    private String firstName;
    @Column
    @NotBlank(message = ServiceConstants.LAST_NAME_MANDATORY_MESSAGE)
    private String lastName;
    @Column
    @NotBlank(message = ServiceConstants.MOBILE_NO_MANDATORY_MESSAGE)
    @Pattern(regexp="(^$|[0-9]{10})" , message = ServiceConstants.MOBILE_NO_INVALID_MESSAGE)
    private String mobile;
    @Column
    @Email
    @NotBlank(message = ServiceConstants.EMAIL_MANDATORY_MESSAGE)
    private String emailId;
    @Column
    @NotBlank(message = ServiceConstants.DESIGNATION_MANDATORY_MESSAGE)
    private String designation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "emp_id")
    private EmployeeAddress address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "EMPLOYEE_ASSET", joinColumns = {
            @JoinColumn(name = "EMP_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ASSET_ID") })
    private List<Asset> assetList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getMobile() { return mobile; }

    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public EmployeeAddress getAddress() { return address; }

    public void setAddress(EmployeeAddress address) { this.address = address; }

    public List<Asset> getAssetList() { return assetList; }

    public void setAssetList(List<Asset> assetList) { this.assetList = assetList; }
}
