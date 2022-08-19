<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
       <meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>会员登录</title>
		<link rel="stylesheet" type="text/css" href="./css/login.css">
</head>
<body>
<!-- login -->
	
		<form  method="post" action="LoginServlet" class="form center">
		<div class="login">
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">会员登录</div>
					<div class="right fr">您还不是我们的会员？<a href="./regester.jsp" target="_self">立即注册</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">用户ID:&nbsp;<input class="shurukuang" type="text" name="username" placeholder="请输入你的ID"/></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input class="shurukuang" type="password" name="password" placeholder="请输入你的密码"/></div>
					<div class="username">类&nbsp;&nbsp;&nbsp;&nbsp;型:&nbsp;<select name="type" class="select">
					<option value="1">普通用户</option>
					<option value="2">商家</option>
					
					
					</select></div>
					<div class="username">
					
						<div class="login_submit">
					<input class="submit" type="submit" name="submit" value="立即登录" >
				</div>
					</div>
				</div>
				
				
			</div>
		</div>
		</form>
		
</body>
</html>