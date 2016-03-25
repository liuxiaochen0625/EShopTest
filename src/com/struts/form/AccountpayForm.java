package com.struts.form;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


public class AccountpayForm  extends ValidatorForm {
	/*
	 * Generated fields
	 */

	/** loginPwd property */
	private Double money;
	private Date payDate;
	private Integer Account;
	private Integer Orders ;


	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Integer getAccount() {
		return Account;
	}

	public void setAccount(Integer account) {
		Account = account;
	}

	public Integer getOrders() {
		return Orders;
	}

	public void setOrders(Integer orders) {
		Orders = orders;
	}

	/** 
	 * Returns the loginPwd.
	 * @return String
	 */
	
	/** 
	 * Set the loginPwd.
	 * @param loginPwd The loginPwd to set
	 */

}
