<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>我的相册</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		.panel{
			width:320px;
			height:640px;
			border: 1px solid #ddd;
		}
		.infor{
			width:290px;
			height:180px;
			border:1px solid #ddd;
		}
		.img{
			width:220px;
			height:240px;
		}
	</style>
	<script src="/resource/js/common/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resource/js/common/plug-in.js"></script>
</head>
<body>
<div><a href="/albumsl/${sessionScope.user.username}">我的散列画廊</a></div>
<div><a href="">管理相册</a></div>
<div><a href="/zone/${sessionScope.user.username}">返回上一级</a></div>
<br>
<div class="panel"><form action="/upload" method="post" enctype="multipart/form-data">
	<span id="permitSpan">选择一张照片(建议220*240)：<input type="file" class="a" name="file"></span><br>
	<div ><img src=""  class="img" alt=""></div>
	<br>
	写下相片的描述：<textarea class="infor" name="infor" contenteditable="true"></textarea><br><br>
	图片标题：<input type="text" name="caption">
	<br>
	<br>
	<input type="submit" value="上传图片到画廊" class="btn btn-info"></form></div>
</body>
<script>
    function checkLast(str){
        var flag=false;
        var ext=str.split('.')[str.split('.').length-1];
        if(ext=='png'||ext=='jpg'||ext=='bmp'||ext=='jpeg'||ext=='gif'){
            flag=true;
        }
        return flag;
    }
    $('.a').change(function(e) {
        if(!checkLast(this.value.toLowerCase())){
            $.Pop('请选择图片!!!',{Animation:'layer-shake'});
            $(this).val("");
            $('.img').attr('src', "");
        }
       else{
            var _URL = window.URL || window.webkitURL;
            var file, img;
            if ((file = this.files[0])) {
                console.log(this.files[0]);
                img = new Image();
                img.onload = function() {
                    $('.img').attr('src', this.src);
                    console.log(this.width)
                };
                img.src = _URL.createObjectURL(file);
            }
		}

    })
</script>
</html>