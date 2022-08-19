<%@page import = "Dao.*,database.*,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>我的购物车--哇哈哈哈哈商城</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script type="text/javascript">
	function checkOrCancelAll(){
		//1.获取checkbo的元素对象
		var chElt=document.getElementById("chElt");
		//2.获取选中状态
		var checkedElt=chElt.checked;
		console.log(checkedElt)
		//3.若checked=true,将所有的复选框选中,checked=false,将所有的复选框取消
		var allCheck=document.getElementsByName("orders");
		//4.循环遍历取出每一个复选框中的元素
		//var mySpan=document.getElementById("mySpan");
		if(checkedElt){
		//全选
			for(var i=0;i<allCheck.length;i++){
				//设置复选框的选中状态
				allCheck[i].checked=true;
			}
		//mySpan.innerHTML="取消全选";
		}else{
		//取消全选
			for(var i=0;i<allCheck.length;i++){
				allCheck[i].checked=false;
			}
		//mySpan.innerHTML="全选";
		}
	}
	
</script>
<script type="text/javascript">
	function delall(){
		if(!confirm("确认购买？")) {
			window.event.returnValue = false;
		}
		else{
			var userID = [];
			var BusinessID = [];
			var GoodsID = [];
			if($("input[type='checkbox']:checked").length > 0)
			{
				
				$("input[type='checkbox']:checked").each(function(i){
					
					var str = $(this).val();
					
					if(!(str == "quanxuan"))
					{
						
						userID[i] = str.match(/(\S*)&/)[1];					
						BusinessID[i] = str.match(/&(\S*)_/)[1];
						GoodsID[i] = str.match(/_(\S*)/)[1];
						
						
					}
					
				})
				
				window.location.href="DealServlet?userID="+userID + "&BusinessID=" + BusinessID + "&GoodsID=" + GoodsID;
				alert("购买成功！");
			}
			else
			{
				alert("请选择你要购买的商品");
			}
		}
	}


</script>
<style type="text/css">
	#gwimg{
	      
	      width:100px;
	      height:100px;
	      
	      }
</style>
</head>
<body>
<div class="banner_x center">
			<a href="./index.jsp" target="_blank"><div class="logo fl"></div></a>
			
			<div class="wdgwc fl ml40">我的购物车</div>
			<div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
			<div class="dlzc fr">
				<ul>
					<%
						String username = (String)session.getAttribute("username");
						String userid = (String)session.getAttribute("userid");
						if(username==null){
							out.print("<li><a href='./login.jsp' target='_blank'>登录</a></li>");
						}
						else{
							out.print("<li><a href='self_info.jsp?userid =" + userid + "'>" + username + "</a></li>");//登录后变为个人中心
						}
					%>
					<li>|</li>
					<li><a href="./regester.jsp" target="_blank" >注册</a></li>	
				</ul>
				
			</div>
			<div class="clear"></div>
		</div>
		<div class="xiantiao"></div>
		<%
					List<Orders> list = new ArrayList<Orders>();
					list = (List<Orders>)request.getAttribute("list_purchase");
					double sumValue = 0;
					
		%>
		
		<div class="gwcxqbj">
			<div class="gwcxd center">
				<div class="top2 center">
					<div class="sub_top fl">
						<input type="checkbox" id = "chElt" onclick='checkOrCancelAll();' value="quanxuan" class="quanxuan" />全选
					</div>
					<div class="sub_top fl">商品名称</div>
					<div class="sub_top fl">单价</div>
					<div class="sub_top fl">数量</div>
					<div class="sub_top fl">小计</div>
					<div class="sub_top fr">操作</div>
					<div class="clear"></div>
				</div>
			
				
				
				<%
					for(int i = 0;i < list.size();i++)
					{
				%>
				<div class="content2 center">
					<div class="sub_content fl ">
						<input type="checkbox" value='<%=userid + "&" + list.get(i).getBusinessID() + "_" + list.get(i).getGoodsID() %>' name = "orders"  class="quanxuan" />
					</div>
					<div class="sub_content fl"><img id = "gwimg" src="<%=list.get(i).getImage() %>"></div>
					<div class="sub_content fl ft20"><%=list.get(i).getGoodsName() %></div>
					<div class="sub_content fl "><%=list.get(i).getSalePrice() %></div>
					<div class="sub_content fl">
						<span><%=list.get(i).getNumber() %> </span>
					</div>
					<div class="sub_content fl"><span><%=list.get(i).getSum() %></span></div>
					<!-- x跳转到servlet进行删除再刷新显示页面 -->
					<div class="sub_content fl"><a href="PurDeleteServlet?CustomerID=<%=userid %>&BusinessID=<%=list.get(i).getBusinessID() %>&GoodsID=<%=list.get(i).getGoodsID() %>">×</a></div>
					<div class="clear"></div>
				</div>
				
				<%
					sumValue += Double.valueOf(list.get(i).getSum());
					}
				%>
				
			</div>
			
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li><a href="./index.jsp">继续购物</a></li>
						<li>|</li>
						
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
					<div class="jiesuanjiage fl">合计（不含运费）：<span id="sum"><%=String.valueOf(sumValue) %>元</span></div>
					<div class="jsanniu fr"><button type="button" class="jsan" accessKey = "z" onclick = "javascript:return delall()">去结算</button></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			
		</div>
		
</body>
</html>