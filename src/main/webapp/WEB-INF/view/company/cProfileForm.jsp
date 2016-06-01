<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>فرم نمایه شرکت</title>


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
    <div class="ui grid">
        <div class="eight wide centered column">
            <form:form method="post" modelAttribute="company" class="ui small form">
                <h2 class="ui dividing blue header">تغییر نمایه</h2>
                <div class="two fields">
                    <div class="required field">
                        <label>نام</label>
                        <form:input path="name" placeholder="نام"/>
                    </div>
                    <div class=" field">
                        <label>وب سایت</label>
                        <form:input path="site" placeholder="وب سایت" type="text"/>
                    </div>
                </div>
                <div class="three fields">
                    <div class="field">
                        <label>E-mail</label>
                        <form:input path="mail" placeholder="E-mail" type="text"/>

                    </div>
                    <div class="required field">
                        <label>تلفن</label>
                        <form:input path="phone" placeholder="تلفن" type="text"/>

                    </div>
                    <div class=" field">
                        <label>فکس</label>
                        <form:input path="fax" placeholder="فکس" type="text"/>

                    </div>
                </div>
                <div class="three fields">
                    <div class="four wide required field">
                        <label>استان</label>
                        <div class="ui fluid selection dropdown">

                            <form:input path="ostan" type="hidden" name="ostan"/>
                            <i class="dropdown icon"></i>
                            <div class="default text">استان</div>
                            <div class="menu">
                                <div class="item" data-value="آذربایجان شرقی">آذربایجان شرقی</div>
                                <div class="item" data-value="آذربایجان غربی">آذربایجان غربی</div>
                                <div class="item" data-value="اردبیل">اردبیل</div>
                                <div class="item" data-value="اصفهان">اصفهان</div>
                                <div class="item" data-value="البرز">البرز</div>
                                <div class="item" data-value="ایلام">ایلام</div>
                                <div class="item" data-value="بوشهر">بوشهر</div>
                                <div class="item" data-value="تهران">تهران</div>
                                <div class="item" data-value="چهارمحال و بختیاری"> چهارمحال و بختیاری</div>
                                <div class="item" data-value="خراسان جنوبی">خراسان جنوبی</div>
                                <div class="item" data-value="خراسان رضوی"> خراسان رضوی</div>
                                <div class="item" data-value="خراسان شمالی">خراسان شمالی</div>
                                <div class="item" data-value="خوزستان">خوزستان</div>
                                <div class="item" data-value="زنجان">زنجان</div>
                                <div class="item" data-value="سمنان">سمنان</div>
                                <div class="item" data-value="سیستان و بلوچستان">سیستان و بلوچستان</div>
                                <div class="item" data-value="فارس">فارس</div>
                                <div class="item" data-value="قزوین">قزوین</div>
                                <div class="item" data-value="قم">قم</div>
                                <div class="item" data-value="کردستان"> کردستان</div>
                                <div class="item" data-value="کرمان">کرمان</div>
                                <div class="item" data-value="کرمانشاه">کرمانشاه</div>
                                <div class="item" data-value="کهگیلویه و بویراحمد"> کهگیلویه و بویراحمد</div>
                                <div class="item" data-value="گلستان"> گلستان</div>
                                <div class="item" data-value="گیلان">گیلان</div>
                                <div class="item" data-value="لرستان"> لرستان</div>
                                <div class="item" data-value="مازندران">مازندران</div>
                                <div class="item" data-value="مرکزی">مرکزی</div>
                                <div class="item" data-value="هرمزگان">هرمزگان</div>
                                <div class="item" data-value="همدان">همدان</div>
                                <div class="item" data-value="یزد"> یزد</div>
                            </div>
                        </div>
                    </div>
                    <div class="three wide required field">
                        <label>شهر</label>
                        <form:input path="city" placeholder="شهر" type="text"/>

                    </div>
                    <div class="nine wide required field">
                        <label>آدرس</label>
                        <form:input path="addr" placeholder="آدرس" type="text"/>

                    </div>
                </div>
                <div class="two fields">
                    <div class="field">
                        <label>درباره ی شرکت</label>
                        <form:textarea path="exp" placeholder="درباره ی شرکت"></form:textarea>
                    </div>
                    <div class="field">
                        <label>لوگوی شرکت</label>
                        <img class="ui tiny image" src="${pageContext.request.contextPath}/resources/img/image.png">
                        <br/>
                        <input placeholder="" type="text">
                    </div>

                </div>

                <input type="submit" class="ui centered blue submit button" value="ثبت"/>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
