<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ePortal电子商务管理系统</title>
<link rel="stylesheet" href="css/bootstrap.css" />

<script type="text/javascript" src="js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">
	body{ background:#0066A8 url(img/login_bg.png) no-repeat center 0px;}
	.tit{ margin:auto; margin-top:170px; text-align:center; width:350px; padding-bottom:20px;}
	.login-wrap{ width:220px; padding:30px 50px 0 330px; height:220px; background:#fff url(img/20150212154319.jpg) no-repeat 30px 40px; margin:auto; overflow: hidden;}
	.login_input{ display:block;width:210px;}
	.login_user{ background: url(img/input_icon_1.png) no-repeat 200px center; font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif}
	.login_password{ background: url(img/input_icon_2.png) no-repeat 200px center; font-family:"Courier New", Courier, monospace}
	.btn-login{ background:#40454B; box-shadow:none; text-shadow:none; color:#fff; border:none;height:35px; line-height:26px; font-size:14px; font-family:"microsoft yahei";}
	.btn-login:hover{ background:#333; color:#fff;}
	.copyright{ margin:auto; margin-top:10px; text-align:center; width:370px; color:#CCC}
	.code{background-color: lime;font-family:Arial;font-style:italic;font-weight:bold;border:0;letter-spacing:2px;color:blue}
	@media (max-height: 700px) {.tit{ margin:auto; margin-top:100px; }}
	@media (max-height: 500px) {.tit{ margin:auto; margin-top:50px; }}
</style>
</head>

<body onload="createCode()">
<div class="tit"><h3>ePortal电子商务管理系统</h3></div>
<div class="login-wrap" style="width: 240px;height: 250px">
<script type = "text/javascript">
		var code ; //在全局定义验证码   
		//产生验证码  
		function createCode(){  
			 code = "";   
			 var codeLength = 4;//验证码的长度  
			 var checkCode = document.getElementById("code");   
			 var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',  
			 'S','T','U','V','W','X','Y','Z');//随机数  
			 for(var i = 0; i < codeLength; i++) {//循环操作  
				var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）  
				code += random[index];//根据索引取得随机数加到code上  
			}  
			checkCode.value = code;//把code值赋给验证码  
		}  
		//校验验证码  
		function validate(){  
			var inputCode = document.getElementById("rand").value.toUpperCase(); //取得输入的验证码并转化为大写        
			if(inputCode.length <= 0) { //若输入的验证码长度为0  
				alert("请输入验证码！"); //则弹出请输入验证码  
				createCode();
				return false;
			}         
			else if(inputCode == code ) { //若输入的验证码与产生的验证码不一致时  
				
				return true;
			}   
			alert("验证码不正确！");
			createCode();
			return false;   
		}  
		function winclose() { 
			//此处填写要处理的逻辑代码
			location.reload();//刷新 
		} 
		function check(){
			var name=document.getElementById("loginname").value;
			var pwd=document.getElementById("loginpwd").value;
			if(name.length == 0){
				alert("用户名不能为空！");
				return false;
			}
			if(pwd.length == 0){
				alert("密码不能为空！");
				return false;
			}
			return true;
		}
</script>
<form  onsubmit="return check();return validate()" action="loginSys.action" method="post">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="20" valign="bottom">用户名：</td>
    </tr>
    <tr>
      <td><input type="text" class="login_input login_user" value="" name="loginname" id="loginname"/></td>
    </tr>
    <tr>
      <td height="20" valign="bottom">密  码：</td>
    </tr>
    <tr>
      <td><input type="password"  class="login_input login_password" value="" name="loginpwd" id="loginpwd"/></td>
    </tr>
    <tr>
      <td height="20" valign="bottom">验证码：</td>
    </tr>
    <tr>
      <td>
      	<input type="text" style="width: 75px" id="rand" onblur="return validate()"/>
      	<div style="float: right;width: 150px">
	      	<input style="background: gray;font-size: 20px;width: 120px;color:yellow;" type="button" id="code" onclick="createCode()"/>
      	</div>
      </td>
    </tr>
      
    <tr>
      <td height="60" valign="bottom"><button onclick="submit" class="btn btn-block btn-login">登录</button></td>
    </tr>
    <tr>
    	<td id="mes" align="center" style="padding-top: 10px;font-size: 15px;color: red">
    		${message }
    		<span id="sp"></span>
    	</td>
    </tr>
  </table>
</form>

</div>
<div class="copyright">建议使用IE8以上版本或谷歌浏览器</div>
</body>
</html>
