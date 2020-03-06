<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>分享生活，留住感动</title>
	 <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/login/bg.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/login/login.css">
	<script src="${pageContext.request.contextPath}/resource/js/common/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resource/js/common/plug-in.js"></script>
	<script type="text/javascript">
		$(document).ready(function (e) {
            $(this).keydown(function (e){
              if(e.which == "13"){
				  $("#log").click();//触发该事件
                }
            });
			$("#log").click(function () {
                    var username = $("#username").val();
                    var password = $("#password").val();
                    if (username.length == 0 && password.length == 0) {
                        $.Pop('账户或密码不能为空！', {Animation: 'layer-rollIn'});
                    }
                    else {
                        window.document.f.submit();
                    }
                });

	 })
	</script>
</head>
<body>
<div id="theme"><p>分享生活&nbsp;&nbsp;留住感动</p></div>
<div class="slideshow">
	<div class="slideshow-image" style="background-image: url('${pageContext.request.contextPath}/resource/image/login/bg1.jpg')"></div>
	<div class="slideshow-image" style="background-image: url('${pageContext.request.contextPath}/resource/image/login/bg2.jpg')"></div>
	<div class="slideshow-image" style="background-image: url('${pageContext.request.contextPath}/resource/image/login/bg3.jpg')"></div>
	<div class="slideshow-image" style="background-image: url('${pageContext.request.contextPath}/resource/image/login/bg4.jpg')"></div>
</div>
<div id="container">
<div class="panel panel-info">
	<div class="panel-heading text-center">
		<h3 class="panel-title">
			账户登录
		</h3>
	</div>
	<div class="panel-body">
		<h3 style="color:red">${error}</h3>
		<form action="/check" method="post" name="f">
		<div class="lab"><label for="">账&nbsp;号:</label><input class="text" id="username" type="text" name="username" placeholder="用户名/手机号"></div>
		<div class="lab"><label for="">密&nbsp;码:</label><input class="text" id="password" type="password" name="password" placeholder="请输入密码"><a href="">
		忘记密码？</a></div>
		<br>
		<input type="button"  id="log" value="登录" class="btn btn-primary">
		</form>
		<div class="corner"><a href="">注册新账号</a>&nbsp;&nbsp;<a href="">意见反馈</a></div>
	</div>
</div>
</div>
<audio src="${pageContext.request.contextPath}/resource/image/login/fire.mp3" loop autoplay></audio>
</body>
</html>