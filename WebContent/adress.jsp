<%@page import = "Dao.*,database.*,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="author" content="order by dede58.com"/>
		<title>收获地址</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
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
		<!-- header结束 -->
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
						<input type="text" class="shuru"  placeholder="javaweb从入门的精通&nbsp">
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
					<li><a href="./dingdanzhongxin.jsp" >我的订单</a></li>
					
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<%
		
				String id=(String)session.getAttribute("userid");
				String name = "";
				String tel = "";
				String address = "";
				manager_customerDao mc = new manager_customerDaoImpl();
				List<Customer> list = mc.findAll();
				for(int i = 0;i < list.size();i++)
				{
					if(list.get(i).getCustomerID().equals(id))
					{
						name = list.get(i).getCustomerName();
						tel = list.get(i).getCustomerPhone();
						address = list.get(i).getCustomerAddress();
						break;
					}
				}
			
			%>
			<div class="subddzx">
				<ul>
					<li><a href="./self_info.jsp" >我的个人中心</a></li>
					
					<li><a href="adress.jsp" style="color:#ff6700;font-weight:bold;">收货地址</a></li>
				</ul>
			</div>
		</div>
		<div class="rtcont fr">
			<div class="subgrzl ml40"><span>收货地址</span><span><%=address%></span></div>
		</div>
		<div class="clear"></div>
		</div>
	</div>
<!-- self_info -->
</body>
</html>