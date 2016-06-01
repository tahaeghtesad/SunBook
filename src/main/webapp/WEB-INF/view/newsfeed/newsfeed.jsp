<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8" />
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/semantic/semantic.rtl.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/site.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/semantic/semantic.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/site.js"></script>
    <title>صفحه کاربری</title>
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
            <div class="twelve wide column">
                <div class="ui piled segment">
                    <form:form action="/nesfeed/advertise" method="post" modelAttribute="adv" class="ui small form" id="advForm">
                        <h2 class="ui dividing blue header">ایجاد آگهی</h2>
                        <div class="three fields">
                            <div class="required field">
                                <label>موقعیت</label>
                                <form:input path="ostan" placeholder="مکان"/>
                            </div>
                            <div class="required field">
                                <label>دستمزد</label>
                                <form:input path="salaryType" placeholder="دستمزد"/>
                            </div>
                            <div class="field">
                                <label>انقضا</label>
                                <form:input path="date" placeholder="انقضا" type="text"/>
                            </div>
                        </div>
                        <div class="field">
                            <label>متن آگهی</label>
                            <form:textarea path="text" placeholder="متن آگهی" />
                        </div>
                        <input type="submit" class="ui centered blue submit button" value="ثبت"/>
                    </form:form>
                </div>
                <div class="ui piled segment">
                    <form:form action="/newsfeed/post" id="postForm">
                        <div class="ui small form">
                            <h2 class="ui dividing blue header">ایجاد پست</h2>
                            <div class="field">
                                <label>متن</label>
                                <textarea name="text" class="text" placeholder="متن"></textarea>
                            </div>
                            <input type="submit" class="ui centered blue submit button" value="ثبت"/>
                            <h2 class="ui dividing blue header"></h2>
                        </div>
                    </form:form>
                </div>
                <div class="ui large feed">
                    <c:forEach items="${posts}" var="post">
                        <c:if test="${post.getClass().simpleName eq 'SimplePost'}">
                            <div class="event">
                                <div class="label">
                                    <img src="${pageContext.request.contextPath}/resources/img/image.png" alt="User Profile">
                                </div>
                                <div class="content">
                                    <div class="summary">
                                        <a href="#">${post.poster.firstName}</a> گفت:
                                        <div class="date">
                                            ${post.creationDate}
                                        </div>
                                    </div>
                                    <div class="extra text">
                                        ${post.text}
                                    </div>
                                    <div class="meta">
                                        <a class="like">
                                            <i class="like icon"></i><i class="count">${post.likes.size()}</i><input type="hidden" value="${post.id}">
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${post.getClass().simpleName eq 'AdvPost'}">
                            <div class="event">
                                <div class="label">
                                    <i class="asterisk icon"></i>
                                </div>
                                <div class="content">
                                    <div class="summary">
                                        <a class="user" href="#">${post.poster.firstname}</a> دو آگهی استخدام انتشار داده است
                                        <div class="date">
                                            15 ثانیه پیش
                                        </div>
                                    </div>
                                    <div class="extra text">
                                        <p><a href="#"><i class="circle icon"></i></a>${post.adv.text}
                                        </p>
                                        <p><a href="#"><i class="red circle icon"></i></a> ${post.adv.type}</p>
                                    </div>
                                    <div class="meta">
                                        <a class="like"><i class="like icon"></i><strong>${post.likes.size()}</strong><input type="hidden" value="${post.id}"></a>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${post.getClass().simpleName eq 'FollowPost'}">
                            <div class="event">
                                <div class="label">
                                    <img src="assets/img/image.png"  alt="userImage"/>
                                </div>
                                <div class="content">
                                    <div class="summary">
                                        <a class="user" href="#">طه</a> اکنون <a class="user" href="#">زهره</a> را دنبال می کند.
                                        <div class="date">
                                            5 دقیقه پیش
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${post.getClass().simpleName eq 'EmploymentPost'}">
                            <div class="event">
                                <div class="label">
                                    <i class="suitcase icon"></i>
                                </div>
                                <div class="content">
                                    <div class="summary">
                                        <a class="user" href="#">طه</a> در شرکت <a href="#" class="user">کمان</a> استخدام شد
                                        <div class="date">
                                            1 ثانیه پیش
                                        </div>
                                    </div>
                                    <div class="extra text">
                                        به عنوان مسئول شبکه
                                    </div>
                                    <div class="extra images">
                                        <a href="#"><img src="${pageContext.request.contextPath}/resources/img/image.png" /></a>
                                    </div>
                                    <div class="meta">
                                        <a class="like"><i class="like icon"></i>2,950</a>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
            <div class="ui vertical divider"><i class="spinner icon"></i></div>
            <div class="four wide column">
                <div class="ui card">
                    <div class="ui card">
                        <div class="image">
                            <img src="${pageContext.request.contextPath}/resources/img/image.png" alt="عکس پروفایل" />
                        </div>
                        <div class="content">
                            <h3 class="header">طه اقتصاد</h3>
                            <div class="meta">
                                <span class="username">tahaeghtesad</span>
                            </div>
                            <div class="description">
                                <div class="company">شرکت کمان</div>
                                <div class="awards" style="font-size: 70%;">هیچ دستاوردی ندارد</div>
                            </div>
                        </div>
                        <div class="extra content">
                            <i class="globe icon"></i>
                            <span>
                              شیراز، فارس
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#postForm').submit(function (e) {
            e.preventDefault();
            var text = $(this).find('textarea').val();
            var csrfToken = $("meta[name='_csrf']").attr("content");
            var csrfHeader = $("meta[name='_csrf_header']").attr("content");
            $.ajax({
                type: 'POST',
                url: '/newsfeed/post',
                data: {
                    text : text
                },
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(csrfHeader, csrfToken);
                },
                success: function (data) {
                    if (data == true){
                        location.reload();
                    }
                    $(this).trigger('reset');
                }
            });
        });
        $('#advForm').submit(function (e) {
            e.preventDefault();
            var content = $(this).find('textarea').val();
            var target = "/newsfeed/advertise";
            var csrfToken = $("meta[name='_csrf']").attr("content");
            var csrfHeader = $("meta[name='_csrf_header']").attr("content");
            $.ajax({
                type: 'POST',
                url: target,
                data: {
                    text: content
                },
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(csrfHeader, csrfToken);
                },
                success: function (data) {
                    location.reload();
                }
            });
        });
        $('a.like').on('click', function (e) {
            var id = $(this).children('input').val();
            var likeCount = parseInt($(this).text());
            $.ajax({
                type: 'GET',
                url: '/newsfeed/like/' + id,
                success: function (data) {
                    if (data == true){
                        $(this).children('i.count').text(likeCount + 1);
                    }
                }
            });
        });

    });
</script>

</body>

</html>
