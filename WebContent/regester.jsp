<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>用户注册</title>
		<link rel="stylesheet" type="text/css" href="./css/login.css">
		
		
 		<script type="text/javascript" src="./js/regester.js"></script>

 </head>
<body>
<form  method="post" action="RegistServlet">
		<div class="regist">
			<div class="regist_center">
				<div class="regist_top">
					<div class="left fl">会员注册</div>
					<div class="right fr"><a href="./index.jsp" target="_self">哇哈哈哈哈商城</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="regist_main center">
					<div class="username" >用&nbsp;&nbsp;户&nbsp;&nbsp;ID:&nbsp;&nbsp;<input class="shurukuang" type="text" name="userid" id="userid"  placeholder="请输入你的id"/><span id="userid" maxlength = "18">最长为18个字符</span></div>
					<div class="username" >用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input class="shurukuang" type="text" name="username" id="user" onBlur="return checkForm()" placeholder="请输入你的用户名"/><span id="user_tips">请输入6-18个字符</span></div>
					<div class="username" >密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="password" id="password" onBlur="return checkForm()" placeholder="请输入你的密码"/><span id="pw_tips">请输入6位以上字符</span></div>
					
					<div class="username" >确认密码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="repassword" id="repassword" onBlur="return checkForm()" placeholder="请确认你的密码"/><span id="repw_tips">两次密码要输入一致哦</span></div>
					<div class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input class="shurukuang" type="text" name="tel" id="tel" onBlur="return checkForm()" placeholder="请填写正确的手机号"/><span id="tel_tips">填写下手机号吧，方便我们联系您！</span></div>
                    <div class="username">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:&nbsp;&nbsp;<input class="shurukuang" type="text" name="adress" id="adress" placeholder="请填写你的地址"/></div>					
                    <div class="username">类&nbsp;&nbsp;&nbsp;&nbsp;型:&nbsp;<select name="type" class="select">
					<option value="1">普通用户</option>
					<option value="2">商家</option>
					
					</select></div>
					
					<div class="username">
					
					
						<div class="clear"></div>
					</div>
                     <div class="regist_submit">
					<input class="submit" type="submit" name="submit" value="立即注册" >
				</div>
				
				
			</div>
		</div>
		</form>
</body>
</html>