<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@page import = "Dao.*,database.*,java.util.*" %>
        <%
  String path=request.getContextPath();
  String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  request.setAttribute("path", basePath);
  %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>Basic CRUD Application - jQuery EasyUI CRUD Demo</title>
	 <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/jquery-easyui-1.7.0/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/jquery-easyui-1.7.0/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>/easyui/jquery-easyui-1.7.0/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/easyui/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/easyui/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
	//条件查询功能
	function jump(){
	var var1 = document.getElementById ("keyword").value;//获取该text对象
	if (document.getElementById ("keyword").value=="")
	var1=null;
	var obj=document.getElementById("type");//获取选择框
	var index=obj.selectedIndex;
	var value=obj.options[index].value;
	 
		location.href=encodeURI('BusinessOrdersSearchServlet?method=update&keyword='+ var1+'&type='+value);
	};
	
</script>
<style type="text/css">
	#ordersimg{
	      
	      width:50px;
	      height:50px;
	      
	      }
</style>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
   <form>
	<table id="dg"class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true" toolbar="#tb">
	
       <thead>
	 	<tr>
	 		
	 		<th field="CustomerID" width="50" align="center">顾客ID</th>
	 		<th field="CustomerName" width="50" align="center">顾客名字</th>
	 		<th field="GoodsID" width="50" align="center">商品ID</th>
	 		<th field="GoodsName" width="50" align="center">商品名字</th>
	 		<th field="GoodsType" width="80" align="center">商品类型</th>
	 		<th field="Image" width="80" align="center">图像</th>
	 		<th field="Introduction" width="50" align="center">商品简介</th>
	 		<th field="SalePrice" width="60" align="center">售价</th>
	 		<th field="Number" width="60" align="center">数量</th>
	 		<th field="Sum" width="60" align="center">总额</th>
	 	    <th field="Date" width="60" align="center">交易日期</th>
	 		<th field="id" width="60" align="center">订单号</th>
	 	
	 	
	 	</tr>
	 	</thead>
	 	
			<%
			
			List<Orders> list=(List<Orders>)request.getAttribute("list_orders");
			for(int i=0;i<list.size();i++)
			{
			
			%>
		<tbody>
	 	<tr>
	 		<%-- <td><input  type="checkbox" value="<%=list.get(i).getBusinessID() %>'&'<%=list.get(i).getCustomerID() %>'_'<%=list.get(i).getGoodsID() %>" class="cbox" align="center"></td> --%>
	 		
	 		<td><%=list.get(i).getCustomerID()%></td>
	 		<td><%=list.get(i).getCustomerName()%></td>
	 		<td><%=list.get(i).getGoodsID()%></td>
	 		<td><%=list.get(i).getGoodsName()%></td>
	 		<td><%=list.get(i).getGoodsType()%></td>
	 		<td><img id = 'ordersimg' src = '<%=list.get(i).getImage()%>' ></td>
	 		<td><%=list.get(i).getIntroduction() %></td>
	 		<td><%=list.get(i).getSalePrice() %></td>	 		
	 		<td><%=list.get(i).getNumber()  %></td>
	 		<td><%=list.get(i).getSum()%></td>
	 		<td><%=list.get(i).getDate()%></td>
	 		<td><%=list.get(i).getId()%></td>
	 	</tr>
	 	</tbody>
	 	<%
			}
	 	%>
	 	
	 
	</table>
	<div id="tb" style="padding-bottom:5px; padding-top:5px; ">
		<div style="padding-left:10px;margin-top:0px;">
		<input type="text" id="keyword" style="width:200px;" size="20"  placeholder="请输入下单人的真实姓名" value=""/>
			<select class="easyui-combobox" id="type" name="typeId" style="width: 143px; margin-left:40px;"  editable="false" panelHeight="auto">
	 			<option value="*">---请选择商品类别---</option>
	 			<option value="phone">手机</option>
	 			<option value="ipan">平板-笔记本</option>
	 			<option value="tv">电视</option>
	 			<option value="vidio">盒子·影音</option>
	 			<option value="router">路由器</option>
	 			<option value="ai">智能硬件</option>
	 			<option value="shoe">鞋子</option>
	 			<option value="cloth">衣服</option>
	 		</select>
	 		 <a href="javascript:jump()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
		</div>
	</div>
    
  
   

   </form>
    </body>

</html>
