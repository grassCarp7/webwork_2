<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>购买界面-哇哈哈哈商城</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<link rel="stylesheet" type="text/css" href="./css/xiangqing.css">
        <script type="text/javascript" src="js/xiangqing.js"></script>
        
        <style type="text/css">
	        #ddimg{
		        width:560px;
		        height:560px;
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
						<input type="text" class="shuru" id="sousuo" placeholder="Javaweb从入门到精通">
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

	
	<!-- xiangqing -->
	
	<!-- 获取商品信息 -->
	<%
		request.setCharacterEncoding("UTF-8");
		String BusinessName=(String)request.getAttribute("BusinessName");
		String GoodsName=(String)request.getAttribute("GoodsName");
		String Introduction=(String)request.getAttribute("Introduction");
		String SalePrice=(String)request.getAttribute("SalePrice");
		String Image = (String)request.getAttribute("Image");
		String GoodsID = (String)request.getAttribute("GoodsID");
		String BusinessID = (String)request.getAttribute("BusinessID");
		
		int Stock = Integer.valueOf((String)request.getAttribute("Stock"));
		System.out.println("Stock = " + Stock);
	%>
	<form action="PurchaseServlet?BusinessID=<%=BusinessID %>&GoodsID=<%=GoodsID %>&userid=<%=userid %>" method="post">
	<div class="xiangqing">
		<div class="neirong w">
			<div class="xiaomi6 fl"><span><%=BusinessName%></span></div>
			<nav class="fr">
				<li><a href="">用户评价</a></li>
				<div class="clear"></div>
			</nav>
			<div class="clear"></div>
		</div>	
	</div>
	
	<div class="jieshao mt20 w">
		<div class="left fl"><img id = "ddimg" src="<%=Image%>"></div>
		<div class="right fr">
			<div class="h3 ml20 mt20" id=""><%=GoodsName%></div>
			<div class="jianjie mr40 ml20 mt10"><span><%=Introduction%></span></div>
			<div class="jiage ml20 mt10">单价：<span id="price"><%=SalePrice%></span>元</div>
			
			<div class="xzbb ml20 mt10">
			
			<div class="number"><span>数量</span>
			<input type="button" id="num_jian" onclick="jian()"value="-">
			<input type="text" placeholder="1" id="count" name = "number" value="1" min="1" max="<%=Stock %>">
			<input type="button" id="num_jia"  onclick="jia(<%=Stock %>)"value="+">
			</div>
			
				
			</div>
			 
				<div class="bot mt20 ft20 ftbc">总计：<span class="sum" id="sum"><%=SalePrice%></span>元</div>
	           
			<div class="xiadan ml20 mt20">
				<!-- 	<input class="jrgwc"  type="button" name="jrgwc" value="立即选购" /> -->
					<input class="jrgwc" type="submit" name="jrgwc" value="加入购物车" />
				
			</div>
		</div>
		<div class="clear"></div>
	</div>
	</form>
</body>
</html>