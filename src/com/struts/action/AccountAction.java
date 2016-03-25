package com.struts.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ORM.*;
import com.base.BaseAction;
import com.service.*;;

public class AccountAction extends BaseAction  {
	public ActionForward browseAccount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		AccountService service = new AccountServiceImpl();
		List result = null;
		try{
			//判断会员是否已成功登录
			Member mem = (Member)request.getSession().getAttribute("member");			
			if(mem==null){
				forward = mapping.findForward("memSorry");
			}else{
				result = service.browseAccount(mem);
				if(result!=null&&result.size()>0)request.setAttribute("result", result);	
				forward = mapping.findForward("browseAccount");
			}			
		}catch(Exception ex){
			logger.info("在执行AccountAction类中的browseAccount方法时出错：\n");
			ex.printStackTrace();
		}
		return forward;
	}
	
	public ActionForward viewAccountpay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		AccountService accService=new AccountServiceImpl();
		OrderService service = new OrderServiceImpl();
		Map row = null;
		Useraccount account=null;
		List result = null;		
		Orders order = null;
		try{
			//判断会员是否已成功登录
			Member mem = (Member)request.getSession().getAttribute("member");			
			if(mem==null){
				forward = mapping.findForward("memSorry");
			}else{
				account = accService.accountPwd(mem.getId(),request.getParameter("accountPwd").trim());
				if(account!=null){
					List tmp=accService.browseAccountPay(account);
					if (tmp!=null && tmp.size()>0){
						result = new ArrayList();
						Iterator it = tmp.iterator();
						Orderpay pay=null;
      
						while(it.hasNext()){
							row = new HashMap();
							pay=(Orderpay)it.next();
					  	    row.put("orderid", pay.getOrderid());
							row.put("money", pay.getMoney());						
							row.put("paydate", pay.getPayDate());
							
							result.add(row);
						}
						request.setAttribute("result", result);	
					}					
					request.setAttribute("account", account);	
				}
				forward = mapping.findForward("useraccount");
			}			
		}catch(Exception ex){
			logger.info("在执行AccountAction类中的viewAccountpay方法时出错：\n");
			ex.printStackTrace();
		}
		return forward;		
	}
	
}
