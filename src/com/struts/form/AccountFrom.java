package com.struts.form;

import java.util.Date;

import org.apache.struts.validator.ValidatorForm;

public class AccountFrom extends ValidatorForm {
	private int id;
	private String accountNum;
	private float accountMoney;
	private Date accountDate;
	private String accountPwd;
	
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public float getAccountMoney() {
		return accountMoney;
	}
	public void setAccountMoney(float accountMoney) {
		this.accountMoney = accountMoney;
	}
	
	public String getAccountPwd() {
		return accountPwd;
	}
	public void setAccountPwd(String accountPwd) {
		this.accountPwd = accountPwd;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

