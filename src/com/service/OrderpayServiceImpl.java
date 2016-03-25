package com.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ORM.*;
import com.base.BaseLog;

public class OrderpayServiceImpl extends BaseLog implements OrderpayService {

	public Orderpay loadOrderpay(Useraccount account) throws Exception {
		
		return null;
	}

	public boolean addOrderpay(Useraccount account,Orders order) throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		boolean status = false;
		try{
			tx = session.beginTransaction();
			session.save(account,order);
			tx.commit();
			status=true;
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("在执行OrderServiceImpl类中的addOrder方法时出错：\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return status;
	}

	public boolean addOrderspay(Orderpay orderpay) throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		boolean status = false;
		try{
			tx = session.beginTransaction();
			session.save(orderpay);
			tx.commit();
			status=true;
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("在执行WordServiceImpl类中的addWord方法时出错：\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return status;
	}

}


