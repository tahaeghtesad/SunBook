<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>خورشیدکار</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/semantic/semantic.rtl.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/site.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/semantic/semantic.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/site.js"></script>
</head>

<body>
<div class="ui sidebar thin labeled menu vertical inverted fixed icon" id="sidebar">
    <a href="#" class="item">
        <i class="home icon"></i>
        <b>خانه</b>
    </a>
    <a href="#" class="item">
        <i class="archive icon"></i>
        <b>نمیدونم</b>
    </a>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="#" class="item" id="logout">
            <i class="ui remove icon"></i>
            <b>خروج</b>
        </a>
    </c:if>
</div>

<div class="ui top horizontal menu visible inverted fixed" id="topar">
    <a href="#" class="item" id="sidebar-toggler">
        <b>منو</b>
        <i class="ui icon content"></i>
    </a>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <a href="/account/login" class="item left" id="login">
            <b>ورود</b>
            <i class="user icon"></i>
        </a>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="/pProfile" class="item left" id="login">
            <b>سلام ${pageContext.request.userPrincipal.name}</b>
            <i class="user icon"></i>
        </a>
    </c:if>
    <a href="pProfile.html" class="item">
        نمایه شخصی
        <i class="archive icon"></i>
    </a>
    <a href="/newsfeed/home" class="item">
        اطلاعیه ها
        <i class="archive icon"></i>
    </a>
    <a href="adverP.html" class="item">
        جست و جو در آگهی ها
    </a>
</div>
<div class="main pusher dimmer">
    <div class="ui grid">
        <img class="ui fluid image" src="${pageContext.request.contextPath}/resources/img/sun2.png" />
    </div>
    <div class="ui inverted vertical masthead center aligned segment">

        <div class="ui text container">
            <h1 class="ui inverted header">
                خورشیدکار
            </h1>
            <div class="ui big search">
                <div class="ui icon input">
                    <input class="prompt" type="text" placeholder="آگهی استخدام">
                    <i class="search icon"></i>
                </div>
                <div class="results"></div>
            </div>
        </div>
    </div>
</div>
</body>

</html>