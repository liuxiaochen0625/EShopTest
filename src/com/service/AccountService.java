package com.service;

import com.ORM.*;

import java.util.*;
public interface AccountService {
	/** 新增账户 */	
	public boolean addAccount(Useraccount account) throws Exception;
	/** 浏览某会员的账户 */
	public List browseAccount(Member member) throws Exception;
	/** 装载某会员的账户 */
	public Useraccount loadAccount(Integer member) throws Exception;
	/** 浏览某会员的账户的交易记录 */
	public List browseAccountPay(Useraccount account) throws Exception;
	/** 浏览某会员的账户的交易记录 */
	public List browseAccountPays(Useraccount account) throws Exception;
	/**确认支付密码*/
	public Useraccount accountPwd(Integer member,String accountPwd);	
	/**账户金额（支付） */
	public boolean updateAccount(Useraccount account) throws Exception;
}

