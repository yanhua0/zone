<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>我的空间</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    *{
    	margin:0;
    	padding: 0;
    }
     #top{width:1920px;height:30px;background-color: black;position: absolute;top:0;}
     #topleft{
     	margin-left: 500px;
     	margin-top: -7px;
     }
     #topleft ul li{list-style: none;float: left;}
     #topleft ul li a{
     text-decoration: none;
    font-size: 16px;
    color: #fff;
    margin: 0 15px;
	 z-index: 999;
	 }
     #topleft ul li a:hover{text-decoration: underline;}
      #topright{margin-left:1200px;}
     #topright a{ text-decoration: none;color:#fff;font-size:15px;}
      #topright a:hover{ text-decoration:underline;}
      body{font-size:14px;
		  font-family:"微软雅黑";background:url("${pageContext.request.contextPath}/resource/image/zone/2.jpg")top no-repeat;background-attachment:fixed;z-index:-99999;background-size:cover;}
     /*内容发布区域*/
		.box .boxcenter{width:500px;height:200px;background:#fff;position:absolute;top:80px;left:180px;border:1px solid green;border-radius:6px;}
		.box .boxcenter .boxc_t{height:30px;line-height:30px;}
		.box .boxcenter .boxc_t h4{padding-left:20px;background:#3BBFB4;border-top-left-radius:6px;
				border-top-right-radius:6px;}
		.box .boxcenter .boxc_c{width:460px;height:100px;border:1px solid #A6C8FF;margin:8px auto;text-indent:10px;box-shadow:0 0 4px #A6C8FF;}
		.box .boxcenter .boxc_b{width:80px;height:30px;position:absolute;right:10px;bottom:8px;}
		.box .boxcenter .boxc_b a{font-size:14px;color:#fff;line-height:30px;background:#3bbfb4;border-radius:6px;
				display:block;text-align:center;text-decoration:none;}
		.box .boxcenter .boxc_b a:hover{background:#2C8E86;}
		.box .timeline{width:60px;height:290px;position:absolute;top:100px;left:80px;border-right:2px solid #5d7895;}/**/
		.timeline .nextbox{width:380px;height:80px;position:absolute;top:260px;left:60px;}
		.timeline_t img{width:100px;height:100px;border-radius:50%;border-radius:50%;position:relative;left: -50px;top: -40px;}
		.a{width:380px;height:130px;background:#fff;border-radius:6px;margin-top:30px;font-size:16px;line-height:20px;text-indent:20px;word-break:break-all;position:relative;left:6px;}
		.a .b{width:6px;height:6px;border-radius:50%;border:2px solid #fff;background:#9DCFE1;position:absolute;top:35px;left:-10px;}
		#time{font-size:20px;color:#7BBFC5;}
	    #zone{width:300px;position: absolute;top:100px;left:1000px;color: #2C618E;font-size: 30px;transition: all 1.6s;}
		#zone:hover{transform: rotateY(360deg);}
		.a:hover .glyphicon{
			visibility: visible;
		}
	a:focus{
		outline:none;
	}
	.glyphicon{
		position: relative;
		top: -15px;
		left: 335px;
		visibility: hidden;
		cursor: pointer;
 	}
		p{
			position: relative;
			top:-16px;
		}
    </style>
	<link rel="stylesheet" href="/resource/css/zone/myemojiPl.css">

</head>
<body id="body">
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/zone/ThreeCanvas.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/zone/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/zone//Snow.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/zone//snowFall.js"></script>
<script>
    $.snowFall({
        //创建粒子数量，密度
        particleNo: 500,
        //粒子下拉速度
        particleSpeed:30,
        //粒子在垂直（Y轴）方向运动范围
        particleY_Range:1300,
        //粒子在垂直（X轴）方向运动范围
        particleX_Range:1000,
        //是否绑定鼠标事件
        bindMouse: false,
        //相机离Z轴原点距离
        zIndex:600,
        //摄像机视野角度
        angle:55,
        wind_weight:0
    });
</script>
<canvas></canvas>
<%--雪花完--%>
	<div id="top">
	<div id="topleft">
   <ul>
<li><a href="">个人中心</a></li>
<li><a href="/album/${sessionScope.user.username}">我的相册</a></li>
<li><a href="">我的好友</a></li>
<li><a href="">装扮</a></li>
   </ul>
   </div>
   <div id="topright">
  <img src="${sessionScope.user.picture}" style="width:22px;height: 22px;" alt=""> <a href="/login">退出</a>&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/resource/image/zone/vip.gif" alt="">
   </div>
	</div>
	<div id="zone" style="">${sessionScope.user.name}的空间</div>
	<div><img src="" alt=""></div>
    <div class="box">
		<!--内容发布区域-->
			<div class="Main boxcenter">
				<div class="Input_Box">
				<div class="boxc_t"><h4>随便说点什么吧...</h4></div>
				<div class="boxc_c Input_text" contenteditable="true" id="aa"></div>
				<div class="boxc_b"><a href="javascript:void(0)">发布</a></div>
					<div class="Input_Foot">
						<a class="imgBtn" title="选择表情" href="javascript:void(0);">(^_^)
						</a><a class="postBtn">确定</a>
					</div>
				</div>

					<div class="faceDiv">
						<section class="emoji_container">
						</section>
						<section class="emoji_tab"></section>
					</div>
				</div>
		<!--时光轴线-->
			<div class="timeline">
				<div class="timeline_t">
				<img src="${sessionScope.user.picture}" alt="">
				</div>
				<div class="nextbox">
					<c:forEach items="${word}" var="word">
					<div class="a">
						<div class="b"></div>
						<span id="time"><fmt:formatDate value="${word.createTime}"   pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" />&nbsp;&nbsp;
						</span><br>
						<a class="glyphicon glyphicon-remove" role="menuitem" tabindex="-1"></a>
						<p style="padding:4px">${word.word}</p>
						<input type="hidden" class="wordid" value="${word.id}">
					</div>
					</c:forEach>
				</div>
			</div>

		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/zone/jquery-1.11.2.min.js"></script>
	<script>

			$(function(){
                $(".timeline").height(290+155*$(".a").length);
				$(".glyphicon").click(function () {
                    var id=$(this).siblings(".wordid").val();
                    $(this).parent().hide(500);
					$.post("/del",{id:parseInt(id)},function () {
					})
                });
				$(".box").find(".boxc_b").click(function() {
                    var center = $(".boxc_c").html();//.appendTo("nextbox");
                    if (center == "") {
                        alert("请输入内容喔！");
                        return;
                    }
                    $.post("/fabu", {word: center}, function () {
                        window.location.reload();
                    });
                    // 	$(".nextbox").prepend("<div class='a'>"+
                    // 		"<div class='b'></div>"+
                    // 		"<span id='time'>"+year+"-"+
                    // 		month+"-"+
                    // 		day+"&nbsp;&nbsp;"+
                    // 		"<span id='hour'>"+hour+":"+min+"</span>"+
                    // 		"</span>"+
                    // 		"<br>"+
                    // 		"<p style='padding:4px'>"+center+"</p>"+
                    // 		"</div>");
                    // 	$(".boxc_c").text("");
                    // });
                    //alert(1);
                });
				$(".boxc_c").keydown(function(event){
					var len =$(".boxc_c").text().length;
					if(len > 270){
					alert("够了，你别输入了，哪儿那么多话儿！");
					}
				});

			});
		</script>
<script src="/resource/js/zone/jquery.js"></script>
<script src="/resource/js/zone/myemojiPl.js"></script>
<script src="/resource/js/zone/add2.js"></script>
</body>
</html>