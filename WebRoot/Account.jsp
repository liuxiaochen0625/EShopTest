<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/struts-html" prefix="html" %>
<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="JSONRPCBridge" scope="session" class="com.metaparadigm.jsonrpc.JSONRPCBridge"/>
<jsp:useBean id="ajax" class="com.base.AjaxBean"></jsp:useBean>
<%
	JSONRPCBridge.registerObject("ajax",ajax);
%>
<html>
<head>
<title><bean:message key="website.title"/></title>
<link href="CSS/stylesheet.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="JS/jsonrpc.js"></script>
</head>
<body class="body">
<table width="780" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" style="border:1px; border-style:solid; border-color:#888888">
  <tr>
    <td width="20">&nbsp;</td>
    <TD height="50" align="right" valign="bottom">
		<IMG src="images/icon_login.gif" align=absMiddle> 
		<INPUT id="qKey" name="qKey" value="商品关键字" onClick="this.value=''"> 
		<SELECT id="category" name="category">
			<option value="0">所有商品</option>
		</SELECT>
		<A href="javascript:QuickSearch()"><IMG src="images/icon_search.gif" align="absMiddle" border="0"></A>    </TD>
    <td width="20">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
	<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TR align="center">
          <TD valign="top" width="9"><IMG src="images/icon02.gif"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="mer.do?method=browseIndexMer"><span class="whiteTitle"><bean:message key="menu.item1"/></span></A>		  </TD>
          <TD background="images/Bule_06.gif" width="2"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="cart.do?method=browseCart"><span class="whiteTitle"><bean:message key="menu.item2"/></span></A>		  </TD>
          <TD background="images/Bule_06.gif" width="2"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="order.do?method=browseOrder"><span class="whiteTitle"><bean:message key="menu.item3"/></span></A>		  </TD>
          <TD background="images/Bule_06.gif" width="2"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="mem.do?method=browseWord"><span class="whiteTitle"><bean:message key="menu.item4"/></span></A>		  </TD>
          <TD background="images/Bule_06.gif" width="2"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="mem.do?method=loadMember"><span class="whiteTitle"><bean:message key="menu.item5"/></span></A>		  </TD>
         <TD class="header_menu" align="middle">
		  	<A href="/AccountLogin.jsp"><span class="whiteTitle"><bean:message key="menu.item6"/></span></A>
		  </TD>
         <TD vAlign=top width=7><IMG src="images/icon07.gif"></TD>
        </TR>
    </TABLE></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="60"><img src="images/account_detail.jpg" width="150" height="29" /></td>
      </tr>
      
      <tr>
        <td align="center">
			<table width="94%" border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
			<logic:notPresent name="account">
              <tr align="center" bgcolor="#F7F3F7">
                <td colspan="2" height="26" class="redText"><bean:message key="account.notExist"/></td>
              </tr>				
			</logic:notPresent>
			<logic:present name="account">		  
              <tr bgcolor="#F7F3F7" class="text">
                <td width="220" height="26" align="right"><bean:message key="account.num"/>：</td>
                <td>&nbsp;${account.accountNum}</td>
              </tr>
              <tr bgcolor="#F7F3F7" class="text">
                <td width="220" height="26" align="right"><bean:message key="account.money"/>：</td>
                <td>&nbsp;￥${account.accountMoney}</td>
              </tr>
			  
              <tr bgcolor="#F7F3F7" class="text">
                <td height="26" colspan="2" align="center" bgcolor="#FFFFFF" class="itemTitle"><bean:message key="pay.list"/></td>
                </tr>
              <tr bgcolor="#F7F3F7" class="text">
                <td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
				 <table cellspacing="1" cellpadding="0" width="100%" border="0" bgcolor="#F7F3F7">
                  <tr height="26">
                    <td class="blackTitle" align="center"><bean:message key="pay.date"/></td>
                    <td class="blackTitle" align="center"><bean:message key="pay.money"/></td>
                    <td class="blackTitle" align="center"><bean:message key="pay.view"/></td>
                    </tr>
                    <logic:iterate id="row" name="result" type="java.util.Map">
                      <tr class="text" align="center" bgcolor="#FFFFFF">
                        <td>&nbsp;${row.paydate}</td>
                        <td>￥${row.money}</td>
                        <td><html:link page="/order.do?method=viewOrder&id=${row.orderid}">
							<span class="blueText"><bean:message key="view.pay"/></span>
						</html:link>&nbsp;</td>
                      </tr>
                    </logic:iterate>
				    <tr height="10" bgcolor="#F7F3F7"><td colspan="5"></td></tr>					
                </table>
				</td>
              </tr>
			</logic:present>						
            </table>
		  </td>
      </tr>
	  <tr height="20"><td colspan="5"></td></tr>      
      <tr align="right">
        <td height="20">&nbsp;</td>
      </tr>
    </table>
	</td>
    <td>&nbsp;</td>
  </tr>  
  <tr>
    <td>&nbsp;</td>
    <td height="30" bgcolor="#4282CE" class="whiteText" align="center">
		<bean:message key="website.foot"/>	</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td height="20">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
<script language="javascript">
	//构造商品分类下拉列表
	jsonrpc = new JSONRpcClient("JSON-RPC");
	var result = jsonrpc.ajax.getCategory();
	for (var i=0;i<result.length;i++){
		option =document.createElement("OPTION");
		option.value = result[i][0];
		option.text = result[i][1];
		document.all.category.options.add(option);
	}
	
	//搜索商品
	function QuickSearch(){
		var url = "mer.do?method=searchMer&cateid="+document.all.category.value;
		var key = document.all.qKey.value;
		if (key !=null && key!="商品关键字" && key.length>0)url = url+"&key="+key;
		window.location = url;
	}
</script>
</body>
</html>