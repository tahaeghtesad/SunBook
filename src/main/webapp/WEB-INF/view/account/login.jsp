<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/semantic/semantic.rtl.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/site.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/semantic/semantic.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/site.js"></script>
    <title>ورود</title>
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
        <a href="login.jsp" class="item left" id="login">
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

        <div class="ui grid">
            <div class="six wide centered column">
                <!-- End Of Header -->
                <h2 class="ui header green">ثبت نام</h2>
                <section id="loginForm">
                    <c:url value="/account/login-submit" var="loginUrl"/>
                    <form method="post" action="${loginUrl}" class="ui form" role="form">
                        <h4 class="ui dividing header blue">ورود با استفاده از حساب سایت</h4>
                        <%--@Html.ValidationSummary()--%>
                        <c:if test="${error ne null}">
                            <div class="validation-summary-errors">
                                <ul>
                                    <li>نام کاربری یا رمز عبور معتبر نیست.</li>
                                </ul>
                            </div>
                        </c:if>
                        <div class="ui piled segment">
                            <div class="field required">
                                <label>نام کاربری</label>
                                <div class="ui icon input">
                                    <input type="text" name="j_username" placeholder="taha" />
                                    <i class="user icon"></i>
                                </div>
                                <%--@Html.ValidationMessageFor(m => m.UserName)--%>
                            </div>
                            <div class="field required">
                                <label>رمز عبور</label>
                                <div class="ui icon input">
                                    <input type="password" name="j_password" placeholder="******" />
                                    <i class="lock icon"></i>
                                </div>
                                <%--@Html.ValidationMessageFor(m => m.Password)--%>
                            </div>
                            <div class="field">
                                <div class="ui toggle checkbox">
                                    <input type="checkbox" name="rememberMe" />
                                    <label>مرا فراموش نکن</label>
                                </div>
                            </div>
                        </div>
                        <div class="ui buttons">
                            <input type="submit" value="ورود" class="ui positive button" />
                            <div class="or"></div>
                            <a href="/" class="ui button" >لغو</a>
                        </div>
                        <p>
                            <a href="/register">ثبت نام</a> کنید اگر حساب ندارید
                        </p>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    </form>
                    <div class="ui loading segment">
                        <section id="socialLoginForm">
                            <h4 class="ui dividing red header">از روش دیگری برای ورود استفاده کنید</h4>
                            <div id="socialLoginList">
                                <p>
                                    <button type="submit" class="ui google plus button" id="google" name="provider" value="google" title="ورود با استفاده از حساب گوگل"><i class="icon google"></i>Google</button>
                                    <button type="submit" class="ui instagram button" id="instagram" name="provider" value="instagram" title="ورود با استفاده از حساب اینستاگرام"><i class="icon instagram"></i>Instagram</button>
                                    <button type="submit" class="ui facebook button" id="facebook" name="provider" value="facebook" title="ورود با استفاده از حساب فیسبوک"><i class="icon facebook"></i>Facebook</button>
                                </p>
                            </div>
                        </section>
                    </div>
                </section>
                <!-- Begin Of Footer -->
            </div>
        </div>
    </div>
</body>

</html>
