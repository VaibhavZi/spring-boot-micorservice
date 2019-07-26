package com.barclays.ipfp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TransactionDetails")
public class TransactionDetails {

	@Id
	@GeneratedValue
	@Column
	private Integer GroupId;
	@ManyToOne
	@JoinColumn(name = "FileId")
	private FileHeader FileId;
	@Column
	private String Originator_Account_Number;
	@Column
	private String Account_Currency;
	@Column
	private String Branch_Number;
	@Column
	private String Product_Type;
	@Column
	private String Force_Post;
	@Column
	private String Brains_Trans_Ref_Number;
	@Column
	private Date Brains_Post_Date;
	@Column
	private String Direct_Debit_Reference_Code;
	@Column
	private String Event_Code;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "GroupId")
	private List<PaymentDetails> SubTransactions;

	public Integer getGroupId() {
		return GroupId;
	}

	public void setGroupId(Integer groupId) {
		GroupId = groupId;
	}

	public FileHeader getFileId() {
		return FileId;
	}

	public void setFileId(FileHeader fileId) {
		FileId = fileId;
	}

	public String getOriginator_Account_Number() {
		return Originator_Account_Number;
	}

	public void setOriginator_Account_Number(String originator_Account_Number) {
		Originator_Account_Number = originator_Account_Number;
	}

	public String getAccount_Currency() {
		return Account_Currency;
	}

	public void setAccount_Currency(String account_Currency) {
		Account_Currency = account_Currency;
	}

	public String getBranch_Number() {
		return Branch_Number;
	}

	public void setBranch_Number(String branch_Number) {
		Branch_Number = branch_Number;
	}

	public String getProduct_Type() {
		return Product_Type;
	}

	public void setProduct_Type(String product_Type) {
		Product_Type = product_Type;
	}

	public String getForce_Post() {
		return Force_Post;
	}

	public void setForce_Post(String force_Post) {
		Force_Post = force_Post;
	}

	public String getBrains_Trans_Ref_Number() {
		return Brains_Trans_Ref_Number;
	}

	public void setBrains_Trans_Ref_Number(String brains_Trans_Ref_Number) {
		Brains_Trans_Ref_Number = brains_Trans_Ref_Number;
	}

	public Date getBrains_Post_Date() {
		return Brains_Post_Date;
	}

	public void setBrains_Post_Date(Date brains_Post_Date) {
		Brains_Post_Date = brains_Post_Date;
	}

	public String getDirect_Debit_Reference_Code() {
		return Direct_Debit_Reference_Code;
	}

	public void setDirect_Debit_Reference_Code(String direct_Debit_Reference_Code) {
		Direct_Debit_Reference_Code = direct_Debit_Reference_Code;
	}

	public String getEvent_Code() {
		return Event_Code;
	}

	public void setEvent_Code(String event_Code) {
		Event_Code = event_Code;
	}

	public List<PaymentDetails> getSubTransactions() {
		return SubTransactions;
	}

	public void setSubTransactions(List<PaymentDetails> subTransactions) {
		SubTransactions = subTransactions;
	}

	@Override
	public String toString() {
		return "OriginatorDetails [GroupId : " + GroupId + ",\n FileId : " + FileId + ",\n Originator_Account_Number : "
				+ Originator_Account_Number + ",\n Account_Currency : " + Account_Currency + ",\n Branch_Number : "
				+ Branch_Number + ",\n Product_Type : " + Product_Type + ",\n Force_Post : " + Force_Post
				+ ",\n Brains_Trans_Ref_Number : " + Brains_Trans_Ref_Number + ",\n Brains_Post_Date : "
				+ Brains_Post_Date + ",\n Direct_Debit_Reference_Code : " + Direct_Debit_Reference_Code
				+ ",\n Event_Code : " + Event_Code + ",\n SubTransactions : " + SubTransactions + "]";
	}

}
