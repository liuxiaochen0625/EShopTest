<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-bean" prefix="bean"%> 
<%@ taglib uri="/struts-html" prefix="html"%> 
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html> 
	<head>
		<title><bean:message key="admin.pageTitle"/></title>
		<link rel="stylesheet" type="text/css" href="../CSS/stylesheet.css">
		<link rel="stylesheet" type="text/css" href="../CSS/displaytag.css" />		
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<style type="text/css">
		<!--
		body {
			background-color: lightgrey;
		}
		-->
	</style>
	</head>  
  <body>
	<c:set var="label1"><bean:message key="mer.name"/></c:set>
	<c:set var="label2"><bean:message key="mer.model"/></c:set>
	<c:set var="label3"><bean:message key="mer.picture"/></c:set>
	<c:set var="label4"><bean:message key="mer.price"/></c:set>
	<c:set var="label5"><bean:message key="mer.sprice"/></c:set>	
	<c:set var="label6"><bean:message key="mer.edit.text"/></c:set>	  	  
	<table border="0" align="center" cellpadding="0" cellspacing="0" style="background-color:lightgrey; border:0px;">
	  <tr>
		<td height="40" class="itemTitle" align="center"><bean:message key="smer.title.text"/></td>
	  </tr>
	  <tr>
		<td height="30" class="blueText" align="center">
			<html:link forward="addSMer">
					 <span class="blueText"><bean:message key="smer.add.text"/></span>			
			</html:link>
		</td>
	  </tr>
	  <tr>
	    <td height="30" align="center">		
			<display:table name="merList" id="row" pagesize="15" export="true" class="displaytag" requestURI="/Admin/adminMer.do?method=browseSMer" >
				<display:column property="merName" title="${label1}" sortable="true" headerClass="sortable" style="text-align:center;"/>
				<display:column property="merModel" title="${label2}" style="text-align:center;"/>
				<display:column title="${label3}" media="html" style="text-align:center;">
					<div onmouseover = "over('${row.picture}')" onmouseout = "out()" style="cursor:hand;">
						<bean:message key="mer.picture.show"/>
					</div>					
				</display:column>				
				<display:column property="price" title="${label4}" sortable="true" headerClass="sortable" style="text-align:center;"/>				
				<display:column property="sprice" title="${label5}" sortable="true" headerClass="sortable" style="text-align:center;"/>								
				<display:column title="${label6}" media="html" style="text-align:center;">
					<html:link page="/Admin/adminMer.do?method=showSMer" 
							   paramId="id" 
							   paramName="row" 
							   paramProperty="id">
						<bean:message key="mer.info.text"/>
					</html:link>					
					<html:link page="/Admin/adminMer.do?method=loadSMer" 
							   paramId="id" 
							   paramName="row" 
							   paramProperty="id">
						<bean:message key="mer.modify.text"/>
					</html:link>
					<html:link page="/Admin/adminMer.do?method=delSMer" 
							   paramId="id" 
							   paramName="row" 
							   paramProperty="id">
						<bean:message key="mer.delete.text"/>
					</html:link>
				</display:column>
				<display:setProperty name="export.csv.filename" value="smer.csv"/>
				<display:setProperty name="export.excel.filename" value="smer.xls"/>
			</display:table>		
		</td>
      </tr>
      <tr>
	    <td height="30" align="center" class="redText"><html:errors property="delSMerStatus"/></td>
      </tr>
  </table>
	<div id="tip" style="position:absolute;display:none;border:0px;width:80px; height:80px;">
		<TABLE id="tipTable" border="0" bgcolor="#ffffee">
			<TR align="center">
				<TD><img id="photo" src="" height="80" width="80"></TD>
			</TR>
		</TABLE>
	</div>
	<script language="javascript">
		function over(picPath){
			x = event.clientX;
			y = event.clientY;      
			document.all.tip.style.display = "block";
			document.all.tip.style.top = y;
			document.all.tip.style.left = x+10;
			document.all.photo.src = ".."+picPath; 
		}
		function out(){
			document.all.tip.style.display = "none";
		}		
	</script>    
  </body>
</html>