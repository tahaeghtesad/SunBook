<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/semantic/semantic.rtl.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/site.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/semantic/semantic.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/site.js"></script>
    <title>نمایه شرکت</title>
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
    <c:otherwise>
        <a href="/pProfile" class="item left" id="login">
            <b>سلام ${pageContext.request.userPrincipal.name}</b>
            <i class="user icon"></i>
        </a>
    </c:otherwise>
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
    <!-- End Of Header -->
    <div class="ui grid">
        <div class="twelve wide column">
            <div class="ui piled segment grid">
                <div class="twelve wide column">
                    <h1 class="ui blue header">${company.name}
                        <div class="sub header">${company.type}</div>
                    </h1>
                    <h3 class="ui blue header">${company.city}
                        <div class="sub header">${company.ostan}</div>
                    </h3>
                    <p>${company.exp}</p>
                    <div class="ui icon header">
                        <i class="user icon"></i>
                        <!-- <img src="assets/img/image.png" class="ui circular image" /> -->
                        <a href="#">${company.manager} </a>
                    </div>
                </div>
                <div class="four wide column">
                    <img class="ui fluid circular image" src="${pageContext.request.contextPath}/resources/img/image.png"/>
                </div>
            </div>
            <div class="ui piled segment">
                <h1 class="ui dividing header">پروژه های اجرا شده</h1>
                <div class="ui horizontal list">
                    <c:forEach items="${company.projects}" var="element">
                        <a class="item">
                            <img class="ui avatar image" src="${pageContext.request.contextPath}/resources/img/image.png"/>
                            <div class="content">
                                <div class="header">
                                        ${element.name}
                                </div>
                                    ${element.exp}</div>
                        </a>
                    </c:forEach>
                </div>
            </div>
            <div class="ui piled segment">
                <h1 class="ui dividing header">برخی از کارمندان</h1>
                <div class="ui horizontal list">
                    <c:forEach items="${company.employee}" var="element">

                        <div class="item">
                            <img class="ui avatar image" src="${pageContext.request.contextPath}/resources/img/image.png"/>
                            <div class="content">
                                <div class="header">
                                        ${element.firstName} ${element.lastName}                           </div>
                                    ${element.naghsh}
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
        <div class="ui vertical divider"><i class="spinner icon"></i></div>
        <div class="four wide column">
            <div class="ui card">
                <div class="ui card">
                    <div class="image">
                        <img src="${pageContext.request.contextPath}/resources/img/image.png" alt="عکس پروفایل"/>
                    </div>
                    <div class="content">
                        <h3 class="header">${company.name}</h3>
                        <div class="meta">
                            <span class="username">${company.manager}</span>
                        </div>
                        <div class="description">
                            <div class="company">${company.name}</div>
                            <div class="awards" style="font-size: 70%;">${company.exp}</div>
                        </div>
                    </div>
                    <div class="extra content">
                        <i class="globe icon"></i>
    <span>
        ${company.city} ${company.ostan}    </span>
                    </div>
                    <div class="extra content">
    <span>
        <a href="<c:url value='/profile/create/${company.id}' />">
تغییر نمایه        </a>    </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Begin Of Footer -->
</div>
</body>

</html>
