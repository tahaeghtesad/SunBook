<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8" />
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
        <div class="ui grid">
            <div class="twelve wide column">
                <div class="ui piled segment">
                    <form action="" id="adv">
                        <div class="ui small form">
                            <h2 class="ui dividing blue header">ایجاد آگهی</h2>
                            <div class="three fields">
                                <div class="required field">
                                    <label>موقعیت</label>
                                    <input placeholder="نام" type="text">
                                </div>
                                <div class="required field">
                                    <label>تاریخ</label>
                                    <input placeholder="تاریخ" type="text">
                                </div>
                                <div class="field">
                                    <label>انقضا</label>
                                    <input placeholder="انقضا" type="text">
                                </div>
                            </div>
                            <div class="field">
                                <label>متن آگهی</label>
                                <textarea name="text" placeholder="متن آگهی"></textarea>
                            </div>
                            <input type="submit" class="ui centered blue submit button" value="ثبت"/>
                        </div>
                    </form>

                </div>
                <div class="ui piled segment">
                    <form action="#" id="post">
                        <div class="ui small form">
                            <h2 class="ui dividing blue header">ایجاد پست</h2>
                            <div class="field">
                                <label>متن</label>
                                <textarea name="text" class="text" placeholder="متن"></textarea>
                            </div>
                            <input type="submit" class="ui centered blue submit button" value="ثبت"/>
                            <h2 class="ui dividing blue header"></h2>
                        </div>
                    </form>
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
                                            <i class="like icon"></i> ${post.likes.size()} لایک
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${post.getClass().simpleName eq 'Advertisement'}">
                            <div class="event">
                                <div class="label">
                                    <i class="asterisk icon"></i>
                                </div>
                                <div class="content">
                                    <div class="summary">
                                        <a class="user" href="#">شرکت کمان</a> دو آگهی استخدام انتشار داده است
                                        <div class="date">
                                            15 ثانیه پیش
                                        </div>
                                    </div>
                                    <div class="extra text">
                                        <p><a href="#"><i class="circle icon"></i></a> نیروی متخصص برای مدیریت شبکه
                                        </p>
                                        <p><a href="#"><i class="red circle icon"></i></a> یک عدد منشی خانم</p>
                                    </div>
                                    <div class="meta">
                                        <a class="like"><i class="like icon"></i><strong>1,353</strong><input type="hidden" value="${post.id}"></a>
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

<script type="javascript">
    $(document).ready(function () {
        $('#post').submit(function (e) {
            e.preventDefault();
            var text = $('#post input[name="text"]').first().val();
            $.ajax({
                type: 'POST',
                url: '/newsfeed/post',
                data: {'text' : text},
                success: function (data) {
                    if (data == true){
                        $('.ui.large.feed').prepend(
                                '<div class="event">' +
                                '<div class="label">'+
                                '<img src="${pageContext.request.contextPath}/resources/img/image.png" alt="User Profile">'+
                                '</div>' +
                                '<div class="content">'+
                                '<div class="summary">'+
                                '<a href="#">'+
                                ${user.firstName} +
                                '</a>'+
                                'گفت: '+
                                '<div class="date">'+
                                new Date()+
                                '</div>'+
                                '</div>'+
                                '<div class="extra text">'+
                                text +
                                '</div>'+
                                '<div class="meta">'+
                                '<a class="like">'+
                                '<i class="like icon"></i> 0 لایک'+
                                '</a>'+
                                '</div>'+
                                '</div>'+
                                '</div>');
                    }
                    $(this).trigger('reset');
                }
            });
        });
        $('a.like').click(function (e) {
            e.preventDefault();
            var id = $(this).child('input').val();
            var likeCount = $(this).child('strong').text();

            $.ajax({
                type: 'POST',
                url: '/newsfeed/like/' + id,
                data: {'text' : text},
                success: function (data) {
                    if (data == true){
                        $(this).child('strong').text(likeCount + 1);
                    }
                }
            });
        });

    });
</script>

</body>

</html>
