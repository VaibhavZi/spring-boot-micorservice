package com.vz.bankservice.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Branch")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"dateCreated", "dateUpdated"})
public class Branch {
    @Id
    @Column(name = "branch_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String branchId;
    @Column(name = "bank_code")
    private int bank_code;
    @Column(name = "branch_name")
    private String branchName;
    @Column(name = "IFSC_CODE")
    private String ifscCode;

    @Type(type="org.hibernate.type.NumericBooleanType")
    @Column(name = "branch_status")
    private boolean branchStatus;

    @Column(name = "address_line_1")
    private String addressLine1;
    @Column(name = "address_line_2")
    private String addressLine2;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "zip")
    private String zip;
    @Column(name = "date_created")
    private LocalDateTime dateCreated;
    @Column(name = "date_modified")
    private LocalDateTime dateModified;

    public Branch() {
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public int getBank_code() {
        return bank_code;
    }

    public void setBank_code(int bank_code) {
        this.bank_code = bank_code;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public Boolean getBranchStatus() {
        return branchStatus;
    }

    public void setBranchStatus(Boolean branchStatus) {
        this.branchStatus = branchStatus;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Branch objBranch =(Branch)obj;
        if(objBranch.getBranchId().equalsIgnoreCase(this.branchId) && objBranch.getBranchName().equalsIgnoreCase(this.branchName))
            return true;
        else
            return false;
    }
}
