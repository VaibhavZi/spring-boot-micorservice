package com.vz.bankcustomerservice.domain;

import java.time.LocalDateTime;

public class Bank {

	private int bankCode;

	private String bankName;
	
	private String bankLongName;

	private String country;

	private String bankSector;

	private LocalDateTime dateCreated;

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
