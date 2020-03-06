<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>散列画廊</title>

    <link rel="stylesheet" href="/resource/css/album/add.css">
    <link rel="stylesheet" href="/resource/css/album/jq22.css">
    <script src="/resource/js/album/jquery.min.js"></script>
    <script src="/resource/js/album/snow.js"></script>
    <script>createSnow('', 22260);</script>
    <style>
    </style>
</head>
<body id="introduction">
<div id="exit" ><a class="btn" href="/album/${sessionScope.user.username}">返回</a></div>
<div id="wrap" class="wrap">
    <c:set value="0" var="index" />
    <c:forEach items="${album}" var="album">
        <div class="photo  photo_front " id="photo_${index}" onclick="turn(this)">
            <div class="photo_wrap">
                <div class="side side_front">
                    <div class="image">
                        <img src="${album.picture}" alt="加载中">
                    </div>
                    <div class="capation">${album.caption}
                    </div>
                </div>
                <div class="side side_back">
                    <div class="desc">
                        ${album.infor}
                            <br>
                            <fmt:formatDate value="${album.createTime}"   pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" />
                    </div>
                </div>
            </div>
        </div>
        <c:set value="${index+1}" var="index" />
    </c:forEach>
</div>
<div id="nav"></div>
<script src="/resource/js/album/add.js"></script>
</body>
</html>