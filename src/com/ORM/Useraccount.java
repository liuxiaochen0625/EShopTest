package com.ORM;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Useraccount implements Serializable {
private int id;
private Member member;
private String accountNum;
private Double accountMoney;
private Date accountDate;
private String accountPwd;
 private Set orderpay = new HashSet();  //支付集合

public String getAccountNum() {
	return accountNum;
}
public void setAccountNum(String accountNum) {
	this.accountNum = accountNum;
}
public Double getAccountMoney() {
	return accountMoney;
}
public void setAccountMoney(Double accountMoney) {
	this.accountMoney = accountMoney;
}

public String getAccountPwd() {
	return accountPwd;
}
public void setAccountPwd(String accountPwd) {
	this.accountPwd = accountPwd;
}

public Set getOrderpay() {
	return orderpay;
}
public void setOrderpay(Set orderpay) {
	this.orderpay = orderpay;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getAccountDate() {
	return accountDate;
}
public void setAccountDate(Date accountDate) {
	this.accountDate = accountDate;
}
public Member getMember() {
	return member;
}
public void setMember(Member member) {
	this.member = member;
}

}

