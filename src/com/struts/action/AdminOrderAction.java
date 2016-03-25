/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.struts.action;

import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.ORM.*;
import com.base.*;
import com.service.*;

/** 
 * MyEclipse Struts
 * 
 * XDoclet definition:
 * @struts.action parameter="method" validate="true"
 */
public class AdminOrderAction extends BaseAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward browseOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		OrderService service = new OrderServiceImpl();
		Admin admin = (Admin)request.getSession().getAttribute("Admin");
		if (admin==null||(admin.getAdminType().intValue()!=2&&admin.getAdminType().intValue()!=5)){
			return mapping.findForward("sorry");
		}		
		List result = null;
		try{
			result = service.browseOrder();
			if(result!=null&&result.size()>0)request.setAttribute("orderList", result);	
		}catch(Exception ex){
			logger.info("在执行AdminOrderAction类中的browseOrder方法时出错：\n");
			ex.printStackTrace();
		}
		return mapping.findForward("browseOrder");
	}
	
	public ActionForward viewOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		OrderService service = new OrderServiceImpl();
		MerService merService = new MerServiceImpl();
		Map row = null;
		List result = null;		
		Orders order = null;
		Integer id = new Integer(0);
		if(request.getParameter("id")!=null)id = new Integer(request.getParameter("id"));
		try{
			order = service.loadOrder(id);
			if(order!=null){
				List tmp = service.browseOrderMer(order.getCart());
				if (tmp!=null && tmp.size()>0){
					result = new ArrayList();
					Iterator it = tmp.iterator();
					Cartselectedmer sel = null;
					Merchandise mer = null;
					while(it.hasNext()){
						row = new HashMap();
						sel = (Cartselectedmer)it.next();
						mer = merService.loadMer(sel.getMerchandise());
						row.put("merName", mer.getMerName().trim());
						row.put("memprice", sel.getPrice());
						row.put("price",  mer.getPrice());						
						row.put("number", sel.getNumber());
						row.put("money", sel.getMoney());
						result.add(row);
					}
					request.setAttribute("result", result);	
				}					
				request.setAttribute("order", order);	
			}
		}catch(Exception ex){
			logger.info("在执行AdminOrderAction类中的viewOrder方法时出错：\n");
			ex.printStackTrace();
		}
		return mapping.findForward("viewOrder");		
	}
	
	public ActionForward updateOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		OrderService service = new OrderServiceImpl();
		ActionMessages msgs = new ActionMessages();
		Integer id = new Integer(0);
		Integer status = new Integer(0);		
		if(request.getParameter("id")!=null)id = new Integer(request.getParameter("id"));
		if(request.getParameter("status")!=null)status = new Integer(request.getParameter("status"));		
		try{
			Orders order = service.loadOrder(id);
			if (order!=null){
				order.setOrderStatus(status);
				boolean result = service.updateOrder(order);
				if (result){
					msgs.add("modiOrderStatus",new ActionMessage(Constants.ORDER_MODI_SUC_KEY));
				}else{
					msgs.add("modiOrderStatus",new ActionMessage(Constants.ORDER_MODI_FAIL_KEY));
				}	
			}else{
				msgs.add("modiOrderStatus",new ActionMessage(Constants.ORDER_MODI_FAIL_KEY));
			}			
			saveErrors(request, msgs);	
		}catch(Exception ex){
			logger.info("在执行AdminOrderAction类中的updateOrder方法时出错：\n");
			ex.printStackTrace();
		}
		return new ActionForward("/Admin/adminOrder.do?method=browseOrder");		
	}
	
	public ActionForward delOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		OrderService service = new OrderServiceImpl();
		ActionMessages msgs = new ActionMessages();
		Integer id = new Integer(0);
		if(request.getParameter("id")!=null)id = new Integer(request.getParameter("id"));
		try{
			boolean status = service.delOrder(id);
			if (status){
				msgs.add("delOrderStatus",new ActionMessage(Constants.ORDER_DEL_SUC_KEY));
			}else{
				msgs.add("delOrderStatus",new ActionMessage(Constants.ORDER_DEL_FAIL_KEY));
			}				
			saveErrors(request, msgs);	
		}catch(Exception ex){
			logger.info("在执行AdminOrderAction类中的delOrder方法时出错：\n");
			ex.printStackTrace();
		}
		return new ActionForward("/Admin/adminOrder.do?method=browseOrder");		
	}
}