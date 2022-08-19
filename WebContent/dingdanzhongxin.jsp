<%@page import = "Dao.*,database.*,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>小米商城-个人中心</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		
		<style type="text/css">
		#ddimg{
		      
		      width:80px;
		      height:80px;
		      
		      }
</style>
</head>
<body>
<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="index.jsp" target="_blank">哇哈哈哈哈商城</a></li>
						<li>|</li>
						<li><a href="http://www.miui.com/">MIUI</a></li>
						<li>|</li>
						<li><a href="">商城移动版</a></li>
						<li>|</li>
						<li><a href="">问题反馈</a></li>
						<li>|</li>
						<li><a href="">Select Region</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="ThroughPurServlet">购物车</a></div>
					<div class="fr">
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
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->
	<!-- start banner_x -->
		<div class="banner_x center">
			<a href="./index.jsp" target="_blank"><div class="logo fl"></div></a>
			<a href=""><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
					<li><a href="DisplayServlet?type=phone" target="_blank"><span id="phone">手机</span></a></li>
					<li><a href="DisplayServlet?type=book" target="_blank"><span id="book">书籍</span></a></li>
					<li><a href="DisplayServlet?type=ipan"  target="_blank"><span id="ipan">平板-笔记本</span></a>
					<li><a href="DisplayServlet?type=tv"    target="_blank"><span id="tv">电视</span></a></li>
					<li><a href="DisplayServlet?type=vidio" target="_blank"><span id="vidio">盒子·影音</span></a></li>
					<li><a href="DisplayServlet?type=router"target="_blank"><span id="router">路由器</span></a></li>
					<li><a href="DisplayServlet?type=ai"    target="_blank"><span id="ai">智能硬件</span></a></li>
					<li><a href="DisplayServlet?type=shoe"   target="_blank"><span id="shoe">鞋子</span></a></li>
					<li><a href="DisplayServlet?type=cloth"  target="_blank"><span id="colth">衣服</span></a></li>
				</ul>
			</div>
			<div class="search fr">
				<form action="SearchServlet" method="post">
					<div class="text fl">
						<input type="text" class="shuru" id="sousuo" placeholder="javaweb从入门到精通">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="number" name="price1" id="price1" min="0" max="10000" style="width:50px;height:50px;">
					到
					<input type="number" name="price2" id="price2"    min="0"  max="10000"style="width:50px;height:50px;">
					<div class="clear"></div>
				</form>
				<div class="clear"></div>
			</div>
		</div>
<!-- end banner_x -->
<!-- self_info -->
	<div class="grzxbj">
		<div class="selfinfo center">
		<div class="lfnav fl">
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="" style="color:#ff6700;font-weight:bold;">我的订单</a></li>
				
					
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="./self_info.jsp">我的个人中心</a></li>
					
					<li><a href="adress.jsp">收货地址</a></li>
				</ul>
			</div>
		</div>
		<div class="rtcont fr">
			<div class="ddzxbt">交易订单</div>
			
				<%
					List<Orders> list = new ArrayList<Orders>();
					if(userid == null)
					{
						out.print("<script language='JavaScript'>alert('请先登录！');window.location.href='login.jsp'</script>");
					}
					customer_ordersDao cd = new customer_ordersDaoImpl();
					list = cd.findOrders(userid);
					
					Goods gd = new Goods();
					List<Goods> list_gd = new ArrayList<Goods>();
					manager_goodsDao md = new manager_goodsDaoImpl();
					
					
					for(int i = 0;i < list.size();i++)
					{
						String imgAddress;
						Orders od = list.get(i);
						list_gd = md.findGoodsID(od.getGoodsID());
						if(od.getDate() != null)
						{
							gd = list_gd.get(0);
							out.print("<div class='ddxq'>");
							out.print("<div class='ddspt fl'><img  id = 'ddimg' src='" + gd.getImage() + "' alt=''></div>");
							out.print("<div class='ztxx fr'>");
							out.print("<ul>");
							out.print("<li>" + od.getGoodsName() +"</li>");
							out.print("<li>￥" + od.getSalePrice() +"</li>");
							out.print("<li>x" + od.getNumber() +"</li>");
							out.print("<li>￥" + od.getSum() +"</li>");
							out.print("<li>" + od.getDate() + "</li>");
							out.print("<li><a href=''>订单详情></a></li>");
							out.print("<div class='clear'></div>");
							out.print("</ul>");
							out.print("</div>");
							out.print("<div class='clear'></div>");
							out.print("</div>");
						}
					}
				%>
				
			
		</div>
		<div class="clear"></div>
		</div>
	</div>
</body>
</html>