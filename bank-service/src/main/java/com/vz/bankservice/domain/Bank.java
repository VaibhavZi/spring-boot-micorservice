package com.vz.bankservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "Bank")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"dateCreated", "dateUpdated"})
public class Bank implements Serializable {

    @Id
    @Column(name = "bank_code")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int bankCode;

    @Column(name = "bank_name")
    @NotBlank
    private String bankName;

    @Column(name = "bank_long_name")
    @NotBlank
    private String bankLongName;

    @Column(name = "country")
    @NotBlank
    private String country;

    @Column(name = "bank_sector")
    @NotBlank
    private String bankSector;

    @Column(name="date_created")
    private LocalDateTime dateCreated;

    @Column(name="date_modified")
    private LocalDateTime dateModified;

    public Bank() {
    }

    public Bank(int bankCode, String bankName, String country, String bankLongName, String bankSector) {
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.country = country;
        this.bankLongName = bankLongName;
        this.bankSector = bankSector;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBankLongName() {
        return bankLongName;
    }

    public void setBankLongName(String bankLongName) {
        this.bankLongName = bankLongName;
    }

    public String getBankSector() {
        return bankSector;
    }

    public void setBankSector(String bankSector) {
        this.bankSector = bankSector;
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
}
