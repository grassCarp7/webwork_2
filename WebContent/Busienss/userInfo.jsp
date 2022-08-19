<%@page import = "java.util.*,Dao.*,database.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/jquery-easyui-1.7.0/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/jquery-easyui-1.7.0/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>/easyui/jquery-easyui-1.7.0/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/easyui/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/easyui/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>

	<style type="text/css">
		th{
			text-align: right;
			background-color: #EFEFEF;
		}
		.table tr{
			height:40px;
		}
	</style>
</head>
<body style="margin:1px;">
<center>
<!-- 获取商家信息 -->
 <%
            String BusinessID = (String)session.getAttribute("userid");
	        String BusinessName = (String)session.getAttribute("username");
            String BusinessPhone = (String)request.getAttribute("BusinessPhone");
            String BusinessAdress = (String)request.getAttribute("BusinessAddress");
	        
            
	        
 %> 
<div style="padding-left: 30px;padding-top: 20px;">
	<div id="p" class="easyui-panel" title="个人详细信息" style="width:900px;height: 400px;">
		<div class="table" style="padding-left:23px;padding-top:40px;">
		  <table width="840" border="1" bordercolor="#CBCBCB" cellpadding="5" cellspacing="1">
	        <col width="110" />
	        <col width="140" />
	        <col width="110" />
	        <col width="140" />
	        
	        <tr>
	          <th>用户ID：</th>
	          <td>&nbsp;&nbsp;<%=BusinessID%></td>
	        </tr>    
	        <tr>
	          <th>真实姓名：</th>
	          <td colspan="3">&nbsp;&nbsp;<%=BusinessName%></td>
	        </tr>
	        <tr>
	          <th>联系电话：</th>
	          <td>&nbsp;&nbsp;<%=BusinessPhone%></td>
	        </tr>
	        <tr>
	         <th>联系地址：</th>
	          <td>&nbsp;&nbsp;<%=BusinessAdress%></td>
	       </tr>  
	   </table>
	   </div>
	
	</div>
</div>
</center>
 
</body>
</html>