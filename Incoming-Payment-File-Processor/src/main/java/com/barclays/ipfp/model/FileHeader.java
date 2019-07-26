package com.barclays.ipfp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FileHeader")
public class FileHeader {

	@Id
	@GeneratedValue
	private int FileId;
	private String Source_System;
	private String File_Date;
	private String Country;
	private String Sequence_Number;
	private String File_Name;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "FileId")
	private List<TransactionDetails> Originator_Details;

	public int getFileId() {
		return FileId;
	}

	public void setFileId(int fileId) {
		FileId = fileId;
	}

	public String getSource_System() {
		return Source_System;
	}

	public void setSource_System(String source_System) {
		Source_System = source_System;
	}

	public String getFile_Date() {
		return File_Date;
	}

	public void setFile_Date(String file_Date) {
		File_Date = file_Date;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getSequence_Number() {
		return Sequence_Number;
	}

	public void setSequence_Number(String sequence_Number) {
		Sequence_Number = sequence_Number;
	}

	public String getFile_Name() {
		return File_Name;
	}

	public void setFile_Name(String file_Name) {
		File_Name = file_Name;
	}

	public List<TransactionDetails> getOriginator_Details() {
		return Originator_Details;
	}

	public void setOriginator_Details(List<TransactionDetails> originator_Details) {
		Originator_Details = originator_Details;
	}

	public FileHeader() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FileHeader [FileId=" + FileId + ", Source_System=" + Source_System + ", File_Date=" + File_Date
				+ ", Country=" + Country + ", Sequence_Number=" + Sequence_Number + ", File_Name=" + File_Name
				+ ", Originator_Details=" + Originator_Details + "]";
	}

}