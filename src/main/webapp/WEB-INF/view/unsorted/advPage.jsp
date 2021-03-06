<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>آگهی ها</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/semantic/semantic.rtl.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/site.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/semantic/semantic.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/site.js"></script>

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
        <div class="fourteen wide centered column">
            <div class="main pusher dimmer">
                <div class="four wide centered column">
                    <div class="ui vertical basic accordion bordered four wide menu">
                        <a class="item">
                            <h4 class="ui blue header">بر اساس</h4>
                        </a>
                        <a class="item">
                            <div class=" title"><i class="dropdown icon"></i>
                                استان
                            </div>
                            <div class=" content">
                                <div class="item" data-value="AS">آذربایجان شرقی</div>
                                <div class="item" data-value="AQ">آذربایجان غربی</div>
                                <div class="item" data-value="Ardebil">اردبیل</div>
                                <div class="item" data-value="Esfahan">اصفهان</div>
                                <div class="item" data-value="Alborz">البرز</div>
                                <div class="item" data-value="Ilam">ایلام</div>
                                <div class="item" data-value="Bushehr">بوشهر</div>
                                <div class="item" data-value="Tehran">تهران</div>
                                <div class="item" data-value="Bakhtiari"> چهارمحال و بختیاری</div>
                                <div class="item" data-value="KhJonubi">خراسان جنوبی</div>
                                <div class="item" data-value="KhRazavi"> خراسان رضوی</div>
                                <div class="item" data-value="KhShomali">خراسان شمالی</div>
                                <div class="item" data-value="Khuzestan">خوزستان</div>
                                <div class="item" data-value="Zanjan">زنجان</div>
                                <div class="item" data-value="Semnan">سمنان</div>
                                <div class="item" data-value="Sistan">سیستان و بلوچستان</div>
                                <div class="item" data-value="Fars">فارس</div>
                                <div class="item" data-value="Ghazvin">قزوین</div>
                                <div class="item" data-value="Ghom">قم</div>
                                <div class="item" data-value="Kordestan"> کردستان</div>
                                <div class="item" data-value="Kerman">کرمان</div>
                                <div class="item" data-value="Kermanshah">کرمانشاه</div>
                                <div class="item" data-value="Kohkiluye"> کهگیلویه و بویراحمد</div>
                                <div class="item" data-value="Golestan"> گلستان</div>
                                <div class="item" data-value="Gilan">گیلان</div>
                                <div class="item" data-value="Lorestan"> لرستان</div>
                                <div class="item" data-value="Mazandaran">مازندران</div>
                                <div class="item" data-value="Markazi">مرکزی</div>
                                <div class="item" data-value="Hormozgan">هرمزگان</div>
                                <div class="item" data-value="Hamedan">همدان</div>
                                <div class="item" data-value="Yazd"> یزد</div>

                            </div>
                        </a>
                        <a class="item">
                            <div class=" title"><i class="dropdown icon"></i> تاریخ آگهی</div>
                            <div class=" content">
                                <div class="item" data-value="h">24 ساعت گذشته</div>
                                <div class="item" data-value="w">یک هفته ی گذشته</div>
                                <div class="item" data-value="m">یک ماه گذشته</div>
                            </div>
                        </a>

                        <a class="item">
                            <div class=" title"><i class="dropdown icon"></i>رشته</div>
                            <div class=" content">


                                <div class="item" data-value="a">مهندس سخت افزار</div>
                                <div class="item" data-value="b">مهندس برق</div>
                                <div class="item" data-value="c">مهندسی مواد</div>
                                <div class="item" data-value="d">مهندس مکانیک</div>
                                <div class="item" data-value="e">مهندس انرژی هسته ای</div>
                                <div class="item" data-value="f">مهندس نفت</div>
                                <div class="item" data-value="g">مهندسی بیوشیمی</div>
                                <div class="item" data-value="h">مهندس انرژی</div>
                                <div class="item" data-value="i">مهندس نرم افزار</div>
                                <div class="item" data-value="j">مهندس، سایر</div>
                            </div>
                        </a>
                        <a class="item">
                            <div class=" title"><i class="dropdown icon"></i>نوع حقوق</div>
                            <div class=" content">
                                <div class="item" data-value="a">توافقی</div>
                                <div class="item" data-value="m">حداقل حقوق</div>
                                <div class="item" data-value="r">طبق قوانین کار</div>
                            </div>
                        </a>
                        <a class="item">
                            <div class=" title"><i class="dropdown icon"></i>نوع کار</div>
                            <div class=" content">
                                <div class="item" data-value="a">تمام وقت</div>
                                <div class="item" data-value="m">نیمه وقت</div>
                                <div class="item" data-value="r">پروژه ای</div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script language='javascript'>
        $(document).ready(function () {
            $('.ui.accordion').accordion();
        });
    </script>
</body>
</html>