/**
 * 
 */
//验证表单
function checkForm(){
	//判断用户名格式是否正确
	if(document.getElementById("user").value.length<6||document.getElementById("user").value.length>18)
			{
		document.getElementById("user_tips").innerHTML="<em style='color:#ff6700'>用户名有6-18位字符组成</em>";
		document.getElementById("user").focus();
		return false;
			}
	else {
		document.getElementById("user_tips").innerHTML="<em style='color:#ff6700'>OK</em>";
	}
	//判断密码格式是否正确
	if(document.getElementById("password").value.length<6||document.getElementById("password").value.length>18)
	{
       document.getElementById("pw_tips").innerHTML="<em style='color:#ff6700'>密码由6-18位字符组成</em>";
       /*document.getElementById("password").focus();*/
        return false;
	}else {
        document.getElementById("pw_tips").innerHTML="<em style='color:#ff6700'>OK</em>";
}
	
	//判断两次密码是否正确
	if(document.getElementById("repassword").value!=document.getElementById("password").value){
		document.getElementById("repw_tips").innerHTML="<em style='color:#ff6700'>密码错误</em>";
		document.getElementById("repassword").focus();
		return flase;
	}else{
		document.getElementById("repw_tips").innerHTML="<em style='color:#ff6700'>OK</em>";
	}
	//判断手机号码格式是否都是纯数字
	var reg=/^[0-9]\d*$/;
	if(reg.test(document.getElementById("tel").value)){
		document.getElementById("tel_tips").innerHTML="<em style='color:#ff6700'>OK</em>";
	}else{
		document.getElementById("tel_tips").innerHTML="<em style='color:#ff6700'>手机号码由纯数字组成</em>";
	}
	
	
	
}