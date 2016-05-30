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
    <title>نمایه ی شخصی</title>
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
        <a href="" class="item">اطلاعیه ها<i class="archive icon"></i></a>
        <a href="/" class="item">خانه<i class="home icon"></i></a>
    </div>


    <div class="main pusher dimmer">
        <!-- End Of Header -->
        <div class="ui grid">
            <div class="twelve wide column">
                <div class="ui piled segment grid">
                    <div class="twelve wide column">
                          <h1 class="ui blue header">${user.firstName} ${user.lastName}<div class="sub header">${user.company.name}</div></h1>
                          <h3 class="ui blue header">${user.city}<div class="sub header">${user.ostan}</div></h3>
                          <p>
                            علاقه مند به عکاسی،
                            برنامه نویس
                          </p>
                          <h2 class="ui yellow header">${user.field}<div class="sub header">${user.university}</div></h2>
                    </div>
                    <div class="four wide column">
                        <img class="ui fluid circular image" src="assets/img/image.png" />
                    </div>
                </div>
                <div class="ui piled segment">
                  <h1 class="ui dividing header">توانایی ها</h1>
                  <div class="ui list">
                    <a class="item">
                      <i class="help icon"></i>
                      <div class="content">
                        فتوشاپ
                      </div>
                    </a>
                    <a class="item">
                      <i class="help icon"></i>
                      <div class="content">
                        لایتروم
                      </div>
                    </a>
                  </div>
                </div>
                <div class="ui piled segment">
                  <h1 class="ui dividing header">سوابق کاری</h1>
                  <div class="ui large list">
                    <div class="item">
                      <img class="ui avatar image" src="assets/img/image.png"/>
                      <div class="content">
                        <div class="header">
                          شرکت کمان
                        </div>
                        <div class="description">
                          از بدو تولد
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
            </div>
            <div class="ui vertical divider"><i class=" icon"></i></div>
            <div class="four wide column">
                <div class="ui card">
                    <div class="ui card">
                        <div class="image">
                            <img src="assets/img/image.png" alt="عکس پروفایل" />
                        </div>
                        <div class="content">
                            <h3 class="header">${user.firstName} ${user.lastName}</h3>
                            <div class="meta">
                                <span class="username">${user.userName}</span>
                            </div>
                            <div class="description">
                                <div class="company">${user.company.name}</div>
                                <div class="awards" style="font-size: 70%;">هیچ دستاوردی ندارد</div>
                            </div>
                        </div>
                        <div class="extra content">
                            <i class="globe icon"></i>
                            <span>
                                ${user.city} ${user.ostan}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Begin Of Footer -->
    </div>
</body>

</html>
