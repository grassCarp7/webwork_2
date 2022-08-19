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
	var obj=document.getElementById("option");//获取选择框
	var index=obj.selectedIndex;
	var value=obj.options[index].value;
	 
		location.href=encodeURI('BusinessStockSearchServlet?method=update&keyword='+ var1+'&type='+value);
	};
	
	//删除功能
	function deleteLink(){
		//获取一行的数据
		 var row = $('#dg').datagrid('getSelected');
		if (row){
			alert('确定删除以下商品吗？\n');
			location.href=encodeURI('BusinessStockDeleteServlet?method=list&GoodsID='+ row.GoodsID+'&GoodsName='+row.GoodsName);
			
		}
	};
	//增加功能
	function addcourse(){
		$("#addcourse").dialog({
			title:'增加库存记录',
			width:350,
			height:350,
			closed:false
		});
	}
	//增加用户时保存信息
	function save(){
		//"GoodsID"/GoodsName/GoodsType/Introduction/Image/SalePrice/PurchasePrice/PurchaseNum/Stock
		var var1 = document.getElementById ("GoodsID").value;//获取该text对象
		var tempfile=$("#Image");
		var value=tempfile.filebox('getValue');
		/* alert("value:"+value); */
		var var2 = document.getElementById ("GoodsName").value;
		var var3 = document.getElementById ("GoodsType").value;
		var var4 = document.getElementById("Introduction").value;
		var var5 = document.getElementById("Image").value;
		var var6 = document.getElementById("SalePrice").value;
		var var7 = document.getElementById("PurchasePrice").value;
		var var8 = document.getElementById("PurchaseNum").value;
		var var9 = document.getElementById("Stock").value;
		location.href=encodeURI('BusinessStockAddServlet?method=list&GoodsID='+var1+
				'&GoodsName='+var2+'&GoodsType='+var3+'&Introduction='+var4+'&Image='+value+
				'&SalePrice='+var6+'&PurchasePrice='+var7+'&PurchaseNum='+var8+'&Stock='+var9);
		$("#addcourse").dialog({
			closed:true
		});
	}
		//关闭对话框
	function close(){
		$("#addcourse").dialog({
			closed:true
		});
	}
	//关闭对话框
	function close1(){
		$("#updatecourse").dialog({
			closed:true
		});
	}
		//修改功能
		function update(){
			//获取一行的数据
			 var row = $('#dg').datagrid('getSelected');
			if (row){
				//"GoodsID"/GoodsName/GoodsType/Introduction/Image/SalePrice/PurchasePrice/PurchaseNum/Stock
				document.getElementById ("GoodsID1").value=row.GoodsID;
				$("#GoodsID1").attr("readOnly",true);//这个是用来设置他不能修改的
				
				document.getElementById ("GoodsName1").value=row.GoodsName;
				$("#GoodsName1").attr("readOnly",true);
				
				document.getElementById ("GoodsType1").value=row.GoodsType;
				$("#GoodsType1").attr("readOnly",true);
				
				document.getElementById ("Introduction1").value=row.Introduction;
				$("#Introduction1").attr("readOnly",true);
				
				document.getElementById ("Image1").value=row.Image;
				$("#Image1").attr("readOnly",true);
				
				document.getElementById ("SalePrice1").value=row.SalePrice;
				document.getElementById ("PurchasePrice1").value=row.PurchasePrice;
				document.getElementById ("PurchaseNum1").value=row.PurchaseNum;
				document.getElementById ("Stock1").value=row.Stock;
				
				$("#updatecourse").dialog({
					title:'修改库存信息',
					width:350,
					height:350,
					closed:false
				});
			}
		}
		
		//修改用户时保存信息
		//保存信息
	function save1(){
			//coursenum\coursename\coursepno\coursecredit
	var var1 = document.getElementById ("GoodsID1").value;//获取该text对象
		var var2 = document.getElementById ("GoodsName1").value;
		var var3 = document.getElementById ("GoodsType1").value;
		var var4 = document.getElementById("Introduction1").value;
		var var5 = document.getElementById("Image1").value;
		var var6 = document.getElementById("SalePrice1").value;
		var var7 = document.getElementById("PurchasePrice1").value;
		var var8 = document.getElementById("PurchaseNum1").value;
		var var9 = document.getElementById("Stock1").value;
		
		location.href=encodeURI('BusinessStockUpServlet?method=list&GoodsID='+var1+
				'&GoodsName='+var2+'&GoodsType='+var3+'&Introduction='+var4+'&Image='+var5+
				'&SalePrice='+var6+'&PurchasePrice='+var7+'&PurchaseNum='+var8+'&Stock='+var9);
		$("#updatecourse").dialog({
			closed:true
		});
	}
</script>
<style type="text/css">
	#stockimg{
	      
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
		 		<th field="checkbox" width="30" align="center"><input type="checkbox" class="cbox" id="chElt" onclick='checkOrCancelAll()' name="orders">全选</th>
		 		<th field="GoodsID" width="60" align="center">商品ID</th>
		 		<th field="GoodsName" width="60" align="center">商品名称</th>
		 		<th field="GoodsType" width="60" align="center">商品种类</th>
		 		<th field="Introduction" width="90" align="center">商品简介</th>
		 		<th field="Image" width="160" align="center">商品图片</th>
		 		<th field="SalePrice" width="140" align="center">售价</th>	 		
		 		<th field="PurchasePrice" width="80" align="center">进货价</th>
		 		<th field="PurchaseNum" width="50" align="center">进货数量</th>
		 		<th field="Stock" width="50" align="center">库存</th>
		 		
		 	</tr>
	        </thead>
	        <%
	      
				List<Stock> list=new ArrayList<Stock>();
				
	       	 	list=(List<Stock>)request.getAttribute("list_stock");
				for(int i=0;i<list.size();i++)
				{
				
				%>
			<tbody>
		 	<tr>
		 		<%-- <td><input  type="checkbox" value="<%=list.get(i).getBusinessID() %>'&'<%=list.get(i).getCustomerID() %>'_'<%=list.get(i).getGoodsID() %>" class="cbox" align="center"></td> --%>
		 		<td><input type="checkbox"/></td>
		 		<td><%=list.get(i).getGoodsID()%></td>
		 		<td><%=list.get(i).getGoodsName()%></td>
		 		<td><%=list.get(i).getGoodsType()%></td>
		 		<td><%=list.get(i).getIntroduction() %></td>
		 		<td><img id = 'stockimg' src = '<%=list.get(i).getImage()%>' ></td>
		 		
		 		<td><%=list.get(i).getSalePrice() %></td>	 		
		 		<td><%=list.get(i).getPurchasePrice()  %></td>
		 		<td><%=list.get(i).getPurchaseNum()%></td>
		 		<td><%=list.get(i).getStock()%></td>
		 	</tr>
		 	</tbody>
		 	<%
				}
		 	%>
	       
	    </table>
	    <div id="tb">
	        <!--plain="true"去掉边框-->
	        <div id="search">
				查找方式：<select class="easyui-combobox" style="width:80px;" panelMaxHeight="150px" id="option" name="column">
					<option value="">---请选择商品类别---</option>
			 						<option value="phone">手机</option>
						 			<option value="ipan">平板</option>
						 			<option value="tv">电视</option>
						 			<option value="ai">智能硬件</option>
						 			<option value="router">路由器</option>
						 			<option value="vidio">盒子·影音</option>
						 			<option value="book">书本</option>
						 			<option value="shoe">鞋子</option>
						 			<option value="cloth">服饰</option>
					
				</select>
		      	  关键字<input type="text" id="keyword" value=""></input>
		      	
		        <a href="javascript:jump()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
		        <br>
		        <a href="javascript:addcourse()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
		        <a href="javascript:update()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
		        <a href="javascript:deleteLink()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-print" plain="true" onclick="CreateFormPage('打印测试', $('#dg'));">打印</a>
	    	</div>
	   </div>
	   <div id="addcourse" class="easyui-dialog" data-options="iconCls:'icon-save'" closed="true">
		   	<form id=add_course method="post" action="javascript:addcourse()" enctype="multipart/form-data">
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品ID：<input type="text" id="GoodsID"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品名称：<input type="text" id="GoodsName"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品种类：<input type="text" id="GoodsType"/><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品简介：<input type="text" id="Introduction"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			
            		<input name="Image" id = "Image" class="easyui-filebox" label="商品图片：:" labelPosition="top" data-options="prompt:'Choose a file...'" style="width:100%">
      
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品售价：<input type="text" id="SalePrice"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品进货价：<input type="text" id="PurchasePrice"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品进货数量：<input type="text" id="PurchaseNum"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品库存数量：<input type="text" id="Stock"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			<a href="javascript:save()" class="easyui-linkbutton" iconCls="icon-save" plain="true">保存</a>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   			<a href="javascript:close()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">取消</a>
		   	</form>
	   
	    </div>
	   
		<div id="updatecourse" class="easyui-dialog" data-options="iconCls:'icon-save'" closed="true">
		   	<form id=update_course method="post">
		   				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品ID：<input type="text" id="GoodsID1"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品名称：<input type="text" id="GoodsName1"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品种类：<input type="text" id="GoodsType1"/><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品简介：<input type="text" id="Introduction1"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品图片：<input type="text" id="Image1"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品售价：<input type="text" id="SalePrice1"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品进货价：<input type="text" id="PurchasePrice1"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品进货数量：<input type="text" id="PurchaseNum1"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			商品库存数量：<input type="text" id="Stock1"/><br>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		   			<a href="javascript:save1()" class="easyui-linkbutton" iconCls="icon-save" plain="true">保存</a>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   			<a href="javascript:close1()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">取消</a>
		
		   	</form>
	   
	    </div>


   </form>
</body>

</html>
