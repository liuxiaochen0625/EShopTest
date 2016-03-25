package com.service;

import java.util.*;

import com.ORM.*;
import com.base.*;
import org.hibernate.*;

public class AccountServiceImpl  extends BaseLog implements AccountService {

	public boolean addAccount(Useraccount account) throws Exception {
		
		return false;
	}

	public List browseAccount(Member member) throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		List list = null;
		try{
			Query query = session.createQuery("from Useraccount as a where a.member=:member");
			tx = session.beginTransaction();
			query.setEntity("member", member);
			list = query.list();
			if (!Hibernate.isInitialized(list))Hibernate.initialize(list);
			tx.commit();			
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("在执行OrderServiceImpl类中的browseOrder方法时出错：\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return list;
	}

	public Useraccount loadAccount(Integer member) throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		Useraccount account = null;
		try{
			tx = session.beginTransaction();
			account = (Useraccount)session.get(Useraccount.class, member);
			tx.commit();
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("在执行AccountServiceImpl类中的loadAccount方法时出错：\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return account;
	}

	public List browseAccountPay(Useraccount account) throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		List result = null;
		try{
			//浏览支付表的所有选购记录
			String hql ="from Orderpay as a where a.useraccount=:account";
			Query query = session.createQuery(hql);
			query.setEntity("account", account);
			tx = session.beginTransaction();
			result = query.list();
			if(!Hibernate.isInitialized(result)){
				Hibernate.initialize(result);
			}
			tx.commit();
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("在执行OrderServiceImpl类中的browseOrderMer方法时出错：\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return result;
	}	

	public Useraccount accountPwd(Integer member,String accountPwd) {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		Useraccount account = null;
		try{
			String hql = "select a from Useraccount as a where a.member=:member and a.accountPwd=:accountPwd";
			Query query = session.createQuery(hql);
			query.setInteger("member", member.intValue());
			query.setString("accountPwd", accountPwd);
			query.setMaxResults(1);
			tx = session.beginTransaction();
			account = (Useraccount)query.uniqueResult();
			tx.commit();
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("在执行AdminServiceImpl类中的adminLogin方法时出错：\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return account;
	}

	public boolean updateAccount(Useraccount account) throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		boolean status = false;
		try{
			tx = session.beginTransaction();
			session.update(account);
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

	public List browseAccountPays(Useraccount account) throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		List list = null;
		try{
			Query query = session.createQuery("from Orderpay as a where a.useraccount=:account");
			tx = session.beginTransaction();
			query.setEntity("account",account);
			list = query.list();
			if (!Hibernate.isInitialized(list))Hibernate.initialize(list);
			tx.commit();			
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("在执行OrderServiceImpl类中的browseOrder方法时出错：\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return list;
	}

}
