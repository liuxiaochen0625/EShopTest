package com.struts.action;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.ORM.*;
import com.base.BaseAction;
import com.base.Constants;

import com.service.*;
import com.struts.form.AccountpayForm;
import com.struts.form.MemLoginForm;

public class OrderpayAction extends BaseAction {

	public ActionForward addOrderpay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		OrderpayService Service =  new OrderpayServiceImpl();
		AccountService accountService = new AccountServiceImpl();
		OrderService orderService=new OrderServiceImpl();
		ActionMessages msgs = new ActionMessages();
		Integer id = null;
		Integer paystatus =Integer.valueOf(2) ;		
		if (request.getParameter("id")!=null){
			id = new Integer(request.getParameter("id"));
		}
		try{
			//判断会员是否已成功登录
			Member mem = (Member)request.getSession().getAttribute("member");
			boolean status = false;
			boolean orderstatus = false;
			boolean accountstatus = false;
			Useraccount account=null;
			Orders order = null;
			account = accountService.accountPwd(mem.getId(),request.getParameter("accountPwd").trim());
			if(mem==null){
				forward = mapping.findForward("memSorry");
			   }
			if (account==null){
				forward = mapping.findForward("useraccount");
//				forward = mapping.getInputForward();
//				msgs.add("addOrderpayStatus",new ActionMessage(Constants.ORDER_PAY_FAIL_KEY));
//				saveErrors(request, msgs);
				return forward;
			}
			else{	
				if (id!=null){	
					order = orderService.loadOrder(id);
					if (account!=null){
						Double p=order.getCart().getMoney();
						Double f=account.getAccountMoney();
						 BigDecimal b1 = new BigDecimal(p.toString());
					        BigDecimal b2 = new BigDecimal(f.toString());
					     double n=b2.subtract(b1).doubleValue();
						Orderpay pay=new Orderpay();
						pay.setMoney(order.getCart().getMoney());
						pay.setUseraccount(account);
						pay.setPayDate(new Date());
						pay.setOrders(order);
			        	account.setAccountMoney(Double.valueOf(n));
						order.setOrderPayStatus(paystatus);
						status = Service.addOrderspay(pay);
						accountstatus=accountService.updateAccount(account);
						orderstatus=orderService.updateOrder(order);
					}
				}
				if (status){
					forward = mapping.findForward("paySuccess");
				}else{
					forward = mapping.getInputForward();
					msgs.add("addOrderpayStatus",new ActionMessage(Constants.PAY_FAIL_KEY));
					saveErrors(request, msgs);
				}	
				
			}			
		}catch(Exception ex){
			logger.info("在执行OrderpayAction类中的addOrderpay方法时出错：\n");
			ex.printStackTrace();
		}
		return forward;		
	}
	
}
