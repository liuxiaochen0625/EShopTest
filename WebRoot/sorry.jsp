<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<html>
<head>
<title><bean:message key="website.title"/></title>
<link href="CSS/stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="500" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="148"><img src="images/sorry.gif" width="128" height="128"></td>
    <td class="itemTitle"> 
		<span style="background-color: rgb(255, 128, 64);">对不起，您尚未登录！</span><br style="background-color: rgb(255, 128, 64);"><span style="background-color: rgb(255, 128, 64);"> 
		如果您尚未注册，请先注册后登录 
		！</span><br style="background-color: rgb(255, 128, 64);"><span style="background-color: rgb(255, 128, 64);">
		谢谢合作！</span>
<br>		<font color="#ff8080"><span style="background-color: rgb(255, 255, 255);">3秒后将返回主页登入</span></font> &nbsp;<%response.setHeader("Refresh","3;URL=mer.do?method=browseIndexMer");%>
    </td>
  </tr>
</table>
</body>
</html>
