<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>哇哈哈哈哈商城</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
	</head>
</head>
<body>

		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="index.jsp" target="_blank">哇哈哈哈哈商城</a></li>
						<li>|</li>
						<li><a href="http://www.miui.com/">MIUI</a></li>
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
		<!-- 	<div>
				 <input type="number" name="minPrice" id="price1" min="1" max="10000">-
					 <input type="number" name="maxPrice" id="price1" min="1" max="10000"> 
				</div> -->
				
				
					<div class="text fl">
						<input type="text" class="shuru" name = "goodsName" id="sousuo" placeholder="javaweb从入门到精通">
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
		<div class="banner_y center">
			<div class="nav">				
				<ul>
					<li>
						<a href="">手机</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm6_80.png" alt=""></div>
											<span class="fl">小米6</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=11" target="_blank">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/iphone11pro.jpg" alt=""></div>
											<span class="fl">iphone11</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=12">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/Huawei_p30.jpg" alt=""></div>
											<span class="fl">华为p30</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=13">选购</a></div>
									<div class="clear"></div>
								</div>
								
							<div class="clear"></div>
						</div>
					</li>
					
					
					
					<li>
					<a href="">书籍</a>
					<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/C_book.jpg" alt=""></div>
											<span class="fl">C语言程序设计</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=14">选购</a></div>
									<div class="clear"></div>
								</div>
								
								
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/ptython_book.jpg" alt=""></div>
											<span class="fl">python书籍</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=15">选购</a></div>
									<div class="clear"></div>
								</div>
								
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/javaweb_book.jpg" alt=""></div>
											<span class="fl">javaweb书籍</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=5">选购</a></div>
									<div class="clear"></div>
								</div>
								
								
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/suanfa_book.jpg" alt=""></div>
											<span class="fl">算法设计</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=16">选购</a></div>
									<div class="clear"></div>
								</div>
								
					</li>
					
					
					
					
					<li>
						<a href="">笔记本</a>
						<a href="">平板</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/ipad_air2.jpg" alt=""></div>
											<span class="fl">ipad air2</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=17">选购</a></div>
									<div class="clear"></div>
								</div>
								
								
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/Huawei_M6.jpg" alt=""></div>
											<span class="fl">华为M6</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=18">选购</a></div>
									<div class="clear"></div>
								</div>
								
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/xiaomi-4.jpg" alt=""></div>
											<span class="fl">小米平板4</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=19">选购</a></div>
									<div class="clear"></div>
								</div>
								
								
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/weiruan.jpg" alt=""></div>
											<span class="fl">微软平板</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=20">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/surface pro 3.jpg" alt=""></div>
											<span class="fl">surface</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=21">选购</a></div>
									<div class="clear"></div>
								</div>
								
								
							</div>
							
							
							<div class="clear"></div>
						</div>
					</li>
					<li>
						<a href="">电视</a>
						<a href="">盒子</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/xiaomi_tv.jpg" alt=""></div>
											<span class="fl">小米电视</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=22">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/kangjia_tv.jpg" alt=""></div>
											<span class="fl">康佳电视</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=23">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/sanxing_tv.jpg" alt=""></div>
											<span class="fl">三星电视</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=24">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/bighead.jpg" alt=""></div>
											<span class="fl">大头机电视</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=25">选购</a></div>
									<div class="clear"></div>
								</div>
								
								
							<div class="ctn fl">
								<div>
									<div class="xuangou_left fl">
								<div>	
									<!-- <div class="xuangou_right fr"><a href="">选购</a></div> -->
									<div class="clear"></div>
								</div>
							</div>
							<div class="clear"></div>
						</div>
						
						
						
					</li>
					<li>
						<a href="">路由器</a>
						<a href="">智能硬件</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/tp-link-tl-r406.jpg" alt=""></div>
											<span class="fl">tp-link-r406</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=26">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/H3C_MSR2600.jpg" alt=""></div>
											<span class="fl">H3C路由交换机</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=27">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/tengda_w18e.jpg" alt=""></div>
											<span class="fl">腾达W18E</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=28">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/tp_link_tl_er6120.jpg" alt=""></div>
											<span class="fl">TP-LINK交换机</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=29">选购</a></div>
									<div class="clear"></div>
								</div>
								
							
								
								
							<div class="right fl">
								<div>
									<!-- <div class="xuangou_right fr"><a href="">选购</a></div> -->
									<div class="clear"></div>
								</div>
								
							</div>
							<div class="clear"></div>
						</div>
					</li>
					
					
					
					<li>
						<a href="">服饰</a>
						<a href="">鞋</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/a21.jpg" alt=""></div>
											<span class="fl">a21服饰</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=4">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/adidas.jpg" alt=""></div>
											<span class="fl">adidas服饰</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=30">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/nike.jpg" alt=""></div>
											<span class="fl">nike服饰</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=31">选购</a></div>
									<div class="clear"></div>
								</div>
							
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./images/lining.jpg" alt=""></div>
											<span class="fl">lining服饰</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="DetailServlet?store_id=123&goods_id=32">选购</a></div>
									<div class="clear"></div>
								</div>								
							</div>							
							<div class="clear"></div>
						</div>
					</li>
					
					
				</ul>
			</div>
		
		</div>	

		<div class="sub_banner center">
			
			<div class="datu fl">
					<div class="sub_mingxing"><a href="DetailServlet?store_id=123&goods_id=1"><img src="./images2/sanxing_1.jpg" alt=""></a></div>
					<div class="pinpai"><span id="sx_tv">三星电视</span></div>
					<div class="youhui"><span>12月12日-22日，下单立减500元</span></div>
					<div class="jiage"><span>4999元</span></div>
				</div>
				
				<div class="datu fl">
					<div class="sub_mingxing"><a href="DetailServlet?store_id=321&goods_id=2"><img id="wr_ipad" src="./images2/weiruan_1.jpg" alt=""></a></div>
					<div class="pinpai"><span id="wr_ipad">微软平板</span></div>
					<div class="youhui"><span>12月12日-22日，下单减300</span></div>
					<div class="jiage"><span>6999元</span></div>
				</div>
				
				<div class="datu fl">
					<div class="sub_mingxing"><a href="DetailServlet?store_id=132&goods_id=3"><img src="./images2/huawei_mate_pro.jpg" alt=""></a></div>
					<div class="pinpai"><span id="hw_ipad">华为Mate Pro</span></div>
					<div class="youhui"><span>12月12日起售，麒麟990处理器，彭拜性能，重构芯片想象</span></div>
					<div class="jiage"><span>3299元</span></div>
				</div>
				
				<div class="datu fl">
					<div class="sub_mingxing"><a href="DetailServlet?store_id=123&goods_id=4"><img id="a21_cloth" src="./images2/a21.jpg" alt=""></a></div>
					<div class="pinpai"><span id="a21_cloth">a21潮流服装</span></div>
					<div class="youhui"><span>12月12日-22日，全场8折</span></div>
					<div class="jiage"><span>99元</span></div>
				</div>
				
				<div class="datu fl">
					<div class="sub_mingxing"><a href="DetailServlet?store_id=123&goods_id=5"><img src="./images2/javaweb.jpg" alt=""></a></div>
					<div class="pinpai"><span id="jw_book">javaweb</span></div>
					<div class="youhui"><span>12月12日-22日，满99-30元</span></div>
					<div class="jiage"><span>49元</span></div>
				</div>


		</div>
	<!-- end banner -->
	<div class="tlinks">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>

	<!-- start danpin -->
		<div class="danpin center">
			
			<div class="biaoti center">促销商品</div>
			<div class="main center">
				<div class="mingxing fl">
					<div class="sub_mingxing"><a href="DetailServlet?store_id=123&goods_id=6"><img src="./images2/iphone11pro_1.jpg" alt=""></a></div>
					<div class="pinpai"><span id="ip_iphone">iphone11 pro</span></div>
					<div class="youhui"><span>12月12日-22日享花呗12期分期免息</span></div>
					<div class="jiage"><span>8499元起</span></div>
				</div>
				<div class="mingxing fl">
					<div class="sub_mingxing"><a href="DetailServlet?store_id=123&goods_id=7"><img src="./images2/huaweip30_1.jpg" alt=""></a></div>
					<div class="pinpai"><span id="hw_p30">华为P30</span></div>
					<div class="youhui"><span>12月12日-22日，下单立减200元</span></div>
					<div class="jiage"><span>3999元</span></div>
				</div>
				<div class="mingxing fl">
					<div class="sub_mingxing"><a href="DetailServlet?store_id=123&goods_id=8"><img src="./images2/vivop20.jpg" alt=""></a></div>
					<div class="pinpai"><span id="vv_p20">vivo p20 超清摄像头</span></div>
					<div class="youhui"><span>12月12日-22日，下单送八重好礼</span></div>
					<div class="jiage"><span>2999元</span></div>
				</div>
				<div class="mingxing fl"> 	
					<div class="sub_mingxing"><a href="DetailServlet?store_id=123&goods_id=9"><img src="./image/pinpai4.png" alt=""></a></div>
					<div class="pinpai"><span id="xm_tv">小米电视3s 55英寸</span></div>
					<div class="youhui"><span>5月9日，下单立减200元</span></div>
					<div class="jiage"><span>3999元</span></div>
				</div>
				<div class="mingxing fl">
					<div class="sub_mingxing"><a href="DetailServlet?store_id=123&goods_id=10"><img id="xm_book" src="./image/pinpai5.png" alt=""></a></div>
					<div class="pinpai"><span id="xm_book">小米笔记本</span></div>
					<div class="youhui"><span>更轻更薄，像杂志一样随身携带</span></div>
					<div class="jiage"><span>3599元起</span></div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	
			
		
</body>
</html>