<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/semantic/semantic.rtl.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/site.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/semantic/semantic.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/site.js"></script>
    <title>جزئیات آگهی</title>

    <style type="text/css">
        body {
            background-color: #f4f8f2;
        }

        .ui.menu .item img.logo {
            margin-right: 1.5em;
        }

        .main.container {
            margin-top: 7em;
        }

        .wireframe {
            margin-top: 2em;
        }

        .ui.footer.segment {
            margin: 5em 0em 0em;
            padding: 5em 0em;
        }
    </style>
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
    <a href="#" class="item" id="logout">
        <i class="ui remove icon"></i>
        <b>خروج</b>
    </a>
</div>

<div class="ui top horizontal menu visible inverted fixed" id="topar">
    <a href="#" class="item" id="sidebar-toggler">
        <b>منو</b>
        <i class="ui icon content"></i>
    </a>
    <a href="../unsorted/login.jsp" class="item left" id="login">
        <b>ورود</b>
        <i class="user icon"></i>
    </a>
    <a class="item">
        <div class="ui icon input">
            <i class="search icon"></i>
            <input type="text" placeholder="کند و کو">
        </div>
    </a>
    <a href="" class="item">
        اطلاعیه ها
        <i class="archive icon"></i>
    </a>
    <a href="/" class="item">
        خانه
        <i class="home icon"></i>
    </a>
</div>

<div class="main pusher dimmer">

<div class = "ui grid">
    <div class="sixteen wide column">
        <h2  class = "ui header">${Advertise.title}</h2>
        <div class="four wide column"><h4>${Advertise.company.name}</h4></div>
        <div class="four wide column"><h4>${Advertise.ostan}</h4></div>
        <div class="four wide column"><h4>${Advertise.date}</h4></div>
        <h4>${Advertise.text}</h4>
    </div>
</div>
</div>
</body>

</html>
