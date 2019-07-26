package com.barclays.ipfp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PaymentDetails")
@JsonIgnoreProperties(value= {"GroupId","ItemNumber"})
public class PaymentDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer GroupId;
	@Id
	@GeneratedValue
	private Integer ItemNumber;
	private BigDecimal Foreign_Amount;
	private BigDecimal Local_Amount;
	private BigDecimal Exchange_Rate;
	private String Tran_Code;
	private String Sub_Tran_Code;
	private String Narrative;
	private String Remittance_Info;
	private String Rate_Type;
	private String Tran_Type;
	private String Hold_No;
	private Date Hold_Date;
	private BigDecimal Threshold_Amount;
	private String Reprocess_Flag;
	private String GL_Split_Flag;
	private BigDecimal Net_Balance;
	private String Online_Trans_Flag;
	private String Countrparty_Account_Number;
	private String Countrparty_Branch_Number;
	private String Countrparty_Account_Currency;
	private BigDecimal Countrparty_Local_Amount;
	private String Countrparty_Tran_Code;
	private String Countrparty_Sub_Tran_Code;
	private String Countrparty_Tran_Type;

	public Integer getGroupId() {
		return GroupId;
	}

	public void setGroupId(Integer groupId) {
		GroupId = groupId;
	}

	public BigDecimal getForeign_Amount() {
		return Foreign_Amount;
	}

	public void setForeign_Amount(BigDecimal foreign_Amount) {
		Foreign_Amount = foreign_Amount;
	}

	public BigDecimal getLocal_Amount() {
		return Local_Amount;
	}

	public void setLocal_Amount(BigDecimal local_Amount) {
		Local_Amount = local_Amount;
	}

	public BigDecimal getExchange_Rate() {
		return Exchange_Rate;
	}

	public void setExchange_Rate(BigDecimal exchange_Rate) {
		Exchange_Rate = exchange_Rate;
	}

	public String getTran_Code() {
		return Tran_Code;
	}

	public void setTran_Code(String tran_Code) {
		Tran_Code = tran_Code;
	}

	public String getSub_Tran_Code() {
		return Sub_Tran_Code;
	}

	public void setSub_Tran_Code(String sub_Tran_Code) {
		Sub_Tran_Code = sub_Tran_Code;
	}

	public String getNarrative() {
		return Narrative;
	}

	public void setNarrative(String narrative) {
		Narrative = narrative;
	}

	public String getRemittance_Info() {
		return Remittance_Info;
	}

	public void setRemittance_Info(String remittance_Info) {
		Remittance_Info = remittance_Info;
	}

	public String getRate_Type() {
		return Rate_Type;
	}

	public void setRate_Type(String rate_Type) {
		Rate_Type = rate_Type;
	}

	public String getTran_Type() {
		return Tran_Type;
	}

	public void setTran_Type(String tran_Type) {
		Tran_Type = tran_Type;
	}

	public String getHold_No() {
		return Hold_No;
	}

	public void setHold_No(String hold_No) {
		Hold_No = hold_No;
	}

	public Date getHold_Date() {
		return Hold_Date;
	}

	public void setHold_Date(Date hold_Date) {
		Hold_Date = hold_Date;
	}

	public BigDecimal getThreshold_Amount() {
		return Threshold_Amount;
	}

	public void setThreshold_Amount(BigDecimal threshold_Amount) {
		Threshold_Amount = threshold_Amount;
	}

	public String getReprocess_Flag() {
		return Reprocess_Flag;
	}

	public void setReprocess_Flag(String reprocess_Flag) {
		Reprocess_Flag = reprocess_Flag;
	}

	public String getGL_Split_Flag() {
		return GL_Split_Flag;
	}

	public void setGL_Split_Flag(String gL_Split_Flag) {
		GL_Split_Flag = gL_Split_Flag;
	}

	public BigDecimal getNet_Balance() {
		return Net_Balance;
	}

	public void setNet_Balance(BigDecimal net_Balance) {
		Net_Balance = net_Balance;
	}

	public String getOnline_Trans_Flag() {
		return Online_Trans_Flag;
	}

	public void setOnline_Trans_Flag(String online_Trans_Flag) {
		Online_Trans_Flag = online_Trans_Flag;
	}

	public String getCountrparty_Account_Number() {
		return Countrparty_Account_Number;
	}

	public void setCountrparty_Account_Number(String countrparty_Account_Number) {
		Countrparty_Account_Number = countrparty_Account_Number;
	}

	public String getCountrparty_Branch_Number() {
		return Countrparty_Branch_Number;
	}

	public void setCountrparty_Branch_Number(String countrparty_Branch_Number) {
		Countrparty_Branch_Number = countrparty_Branch_Number;
	}

	public String getCountrparty_Account_Currency() {
		return Countrparty_Account_Currency;
	}

	public void setCountrparty_Account_Currency(String countrparty_Account_Currency) {
		Countrparty_Account_Currency = countrparty_Account_Currency;
	}

	public BigDecimal getCountrparty_Local_Amount() {
		return Countrparty_Local_Amount;
	}

	public void setCountrparty_Local_Amount(BigDecimal countrparty_Local_Amount) {
		Countrparty_Local_Amount = countrparty_Local_Amount;
	}

	public String getCountrparty_Tran_Code() {
		return Countrparty_Tran_Code;
	}

	public void setCountrparty_Tran_Code(String countrparty_Tran_Code) {
		Countrparty_Tran_Code = countrparty_Tran_Code;
	}

	public String getCountrparty_Sub_Tran_Code() {
		return Countrparty_Sub_Tran_Code;
	}

	public void setCountrparty_Sub_Tran_Code(String countrparty_Sub_Tran_Code) {
		Countrparty_Sub_Tran_Code = countrparty_Sub_Tran_Code;
	}

	public String getCountrparty_Tran_Type() {
		return Countrparty_Tran_Type;
	}

	public void setCountrparty_Tran_Type(String countrparty_Tran_Type) {
		Countrparty_Tran_Type = countrparty_Tran_Type;
	}

	@Override
	public String toString() {
		return "PaymentDetails [GroupId : " + GroupId + ",\n ItemNumber : " + ItemNumber + ",\n Foreign_Amount : "
				+ Foreign_Amount + ",\n Local_Amount : " + Local_Amount + ",\n Exchange_Rate : " + Exchange_Rate
				+ ",\n Tran_Code : " + Tran_Code + ",\n Sub_Tran_Code : " + Sub_Tran_Code + ",\n Narrative : "
				+ Narrative + ",\n Remittance_Info : " + Remittance_Info + ",\n Rate_Type : " + Rate_Type
				+ ",\n Tran_Type : " + Tran_Type + ",\n Hold_No : " + Hold_No + ",\n Hold_Date : " + Hold_Date
				+ ",\n Threshold_Amount : " + Threshold_Amount + ",\n Reprocess_Flag : " + Reprocess_Flag
				+ ",\n GL_Split_Flag : " + GL_Split_Flag + ",\n Net_Balance : " + Net_Balance
				+ ",\n Online_Trans_Flag : " + Online_Trans_Flag + ",\n Countrparty_Account_Number : "
				+ Countrparty_Account_Number + ",\n Countrparty_Branch_Number : " + Countrparty_Branch_Number
				+ ",\n Countrparty_Account_Currency : " + Countrparty_Account_Currency
				+ ",\n Countrparty_Local_Amount : " + Countrparty_Local_Amount + ",\n Countrparty_Tran_Code : "
				+ Countrparty_Tran_Code + ",\n Countrparty_Sub_Tran_Code : " + Countrparty_Sub_Tran_Code
				+ ",\n Countrparty_Tran_Type : " + Countrparty_Tran_Type + "]";
	}

}
