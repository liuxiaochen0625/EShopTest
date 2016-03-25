package com.ORM;

import java.io.Serializable;
import java.util.Date;

public class Orderpay implements Serializable {
	private int id;
	private Double money;
	private Date payDate;
	private Useraccount useraccount;
	private Orders orders;
	private Integer orderid;
	
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Useraccount getUseraccount() {
		return useraccount;
	}
	public void setUseraccount(Useraccount useraccount) {
		this.useraccount = useraccount;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	
}

