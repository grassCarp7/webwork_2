<%@page import = "java.util.*,Dao.*,database.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>商品列表</title>
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
							%>							<li>|</li>
							<li><a href="./register.jsp" target="_blank" >注册</a></li>
							<li>|</li>
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
			<a href="./index.html" target="_blank"><div class="logo fl"></div></a>
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

	<!-- start banner_y -->
	<!-- end banner -->

	<!-- start danpin -->
		<div class="danpin center">
			<%
			List<Stock> list = new ArrayList<Stock>();
			list = (List<Stock>)request.getAttribute("list");
			String type=(String)request.getAttribute("GoodsType");
			
			
			%>
			<div class="biaoti center"><span><%=type%></span></div>
			<div class="main center">
			
			 <%
			 for(int i = 0;i < list.size();i++)
			{
				 
			%>	
			
			 	<!-- 想办法遍历list即可获得所有想显示的值 -->
			 	
				<div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing"><a href="DetailServlet?store_id=<%=list.get(i).getBusinessID() %>&goods_id=<%=list.get(i).getGoodsID()%>" target="_blank"><img src='<%=list.get(i).getImage()%>' alt=""></a></div>
					<div class="pinpai"><a href="DetailServlet?store_id=<%=list.get(i).getBusinessID() %>&goods_id=<%=list.get(i).getGoodsID()%>" target="_blank"><%=list.get(i).getGoodsName()%></a></div>
					<div class="youhui"><%=list.get(i).getIntroduction()%></div> 
					<div class="jiage"><%=list.get(i).getSalePrice()%></div>
				</div>
			
			<%
			
			}
			 
			 %>
				
				<div class="clear"></div>
			</div>
		</div>
</body>
</html>