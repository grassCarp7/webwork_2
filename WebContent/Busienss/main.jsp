<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	

<%-- <%
          String username = (String)session.getAttribute("username");
		  String userid = (String)session.getAttribute("userid");


%> --%>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>哇哈哈哈哈后台管理</title>
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

<!-- <style type="text/css">
	a button{
		outline:none;
	}
</style>
 -->
<script type="text/javascript">
	var url;
	
	function openTab(text,url,iconCls){
		if($("#center_tabs").tabs("exists",text)){
			$("#center_tabs").tabs("select",text);
		}else{
			var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='"+url+"'></iframe>";
			$("#center_tabs").tabs("add",{
				title:text,
				iconCls:iconCls,
				closable:true,
				content:content
			});
		}
	}
	
	function openPasswordModifyDialog(){
		$("#dlg").dialog("open").dialog("setTitle","修改密码");
		url="${pageContext.request.contextPath }/user/modifypwd.html?id=${currentUser.id}"; 
	}
	
	<!--关闭修改密码的模态框-->	
	function closePasswordModifyDialog(){
		$("#dlg").dialog("close");
		$("#oldPassword").val("");
		$("#newPassword").val("");
		$("#newPassword2").val("");
	}
	
	function modifyPassword(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				var oldPassword=$("#oldPassword").val();
				var newPassword=$("#newPassword").val();
				var newPassword2=$("#newPassword2").val();
				if(!$(this).form("validate")){
					return false;
				}
				if(oldPassword!='${currentUser.passWord}'){
					$.messager.alert("系统提示","<font size='3' color='green'>用户原密码输入错误 !<font>");
					return false;
				}
				if(newPassword!=newPassword2){
					$.messager.alert("系统提示","<font size='3' color='green'>确认密码输入错误!<font>");
					return false;
				}
				return true;
			},
			success:function(result){
				var result = eval('('+result+')');
				if(result.success){
					closePasswordModifyDialog();
 					$.messager.show({
						title:'系统提示',
						msg:"<font size='3' color='green'>密码修改成功，下一次登录生效！</font>",
						timeout:2000,
						showType:'slide',
						width:300,
						height:150,
						style:{
							top:'',
							left:'',
							right:0,
							bottom:document.body.scrollTop+document.documentElement.scrollTop
						}
					}); 
				}else{
					$.messager.show({
						title:'系统提示',
						msg:"<font size='3' color='green'>密码修改失败！</font>",
						timeout:2000,
						showType:'slide',
						width:300,
						height:150,
						style:{
							top:'',
							left:'',
							right:0,
							bottom:document.body.scrollTop+document.documentElement.scrollTop
						}
					});
					return;
				}
			}
		});
	}
	
	function logout(){
		$.messager.confirm("系统提示","您确定要退出系统吗",function(r){
			if(r){
				window.location.href="${pageContext.request.contextPath }/login.jsp"; 
			}
		});
	}
	
</script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:67px;background:#E0EDFF;">
		<div style="height:35px;">
			<div style="padding-left:15px;padding-top:5px;">
				<div style="padding-top:5px;; padding-left:550px;margin-top:-1px; ">
					<font size="8" style="font-family: cursive;">哇哈哈哈哈后台管理</font>
				</div>
			</div>
			<div style="margin-top: -35px;padding-left: 1200px;">
			
			
			<!-- //获取商家名字输出 -->
				<font size="6" style="font-family: cursive;">欢迎您：<%-- <%=username%> --%><font color="red">${currentUser.userName }</font></font>
			</div>
		</div>
    </div>   
    
    <div data-options="region:'south',title:'<center></center>',split:true" style="height:35px;"></div> 
      
	 <div region="west" style="width: 210px" title="导航菜单" split="true">
		<div class="easyui-accordion" data-options="fit:true,border:false">
		
		<!-- 商家个人信息 -->
			<div title="用户管理" data-options="iconCls:'icon-user'" style="padding: 10px">
				<a href="javascript:openTab('个人信息','BusinessInfoServlet','icon-c-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-c-user'" style="width: 150px;">个人信息</a>
			</div>
			
			<!-- 库存管理 -->
			
			<div title="库存管理" data-options="iconCls:'icon-pill'" style="padding: 10px">
				<a href="javascript:openTab('库存信息','BusinessStockServlet','icon-pill-add')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-pill-add'" style="width: 150px;">库存信息</a>
			</div>
			
			<!-- 订单管理 -->
			<div title="订单管理" data-options="iconCls:'icon-product'" style="padding: 10px">
				<a href="javascript:openTab('订单信息','BusinessOrdersServlet','icon-wrench')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-wrench'" style="width: 150px;">订单信息</a> 
			</div>
			
			<!-- 系统管理 -->
	 		<div title="系统管理"  data-options="iconCls:'icon-item'" style="padding:10px">
				<!-- <a href="javascript:openPasswordModifyDialog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a> -->
				<a href="javascript:logout()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">安全退出</a>
			</div>
			
			<!-- 显示当前日期 -->
			
			 <div title="当前日期"  data-options="selected:true,iconCls:'icon-safe-log'" style="padding:10px">
				<div class="easyui-calendar" style="width:180px;height:180px;"></div>
			</div> 
		</div>
	</div>
    
    <div data-options="region:'center',title:' &nbsp;功能主界面'" style="padding:2px;background:white;">
    	<div id="center_tabs" class="easyui-tabs" fit="true">
    		<div title="首页" data-options="iconCls:'icon-home'" align="center" style="margin-top: 150px">
    			<font style="font-family: cursive;font-size: 100px;">欢迎使用哇哈哈哈哈后台</font>
    		</div>
    	</div>
    </div>  
    
    <div id="dlg" class="easyui-dialog" style="width: 400px;height:230px;padding: 10px 20px"
  		closed="true" closeable="false" buttons="#dlg-buttons">
	 	<form  action="" id="fm" method="post">
	 		<table cellspacing="8px">
	 			<tr>
	 				<td>用户ID：</td>
	 				<%-- 输出商家id--%>
	 				<td><input type="text" id="BusinessID" name="BusinessID" value="<%-- <%=userID%> --%>" readonly="readonly" style="width: 200px"/></td>
	 			</tr>
	 			<tr>
	 				<td>原密码：</td>
	 				<td><input type="password" id="oldPassword" class="easyui-validatebox" required="true" style="width: 200px"/></td>
	 			</tr>
	 			<tr>
	 				<td>新密码：</td>
	 				<td><input type="password" id="newPassword" name="newPassWord" class="easyui-validatebox" required="true" style="width: 200px"/></td>
	 			</tr>
	 			<tr>
	 				<td>确认新密码：</td>
	 				<td><input type="password" id="newPassword2"  class="easyui-validatebox" required="true" style="width: 200px"/></td>
	 			</tr>
	 		</table>
	 	</form>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:modifyPassword()" class="easyui-linkbutton" iconCls="icon-ok" style="outline: none">保存</a>
		<a href="javascript:closePasswordModifyDialog()" class="easyui-linkbutton" iconCls="icon-cancel" style="outline: none">关闭</a>
	</div> 
</body> 
</html>