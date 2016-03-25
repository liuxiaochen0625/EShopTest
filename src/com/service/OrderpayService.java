package com.service;

import com.ORM.*;

public interface OrderpayService {
	/** 装载指定账户的付款 */	
	public Orderpay loadOrderpay(Useraccount account) throws Exception;
	/** 添加账户付款记录*/	
	public boolean addOrderpay(Useraccount account,Orders order) throws Exception;
	/**直接添加付款记录*/
	public boolean addOrderspay(Orderpay orderpay) throws Exception;
}

