<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>فرم نمایه شخصی</title>

    
    <link rel="stylesheet" type="text/css" href="assets/semantic/semantic.rtl.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/site.css">
    <script type="text/javascript" src="assets/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" src="assets/semantic/semantic.min.js"></script>
    <script type="text/javascript" src="assets/js/site.js"></script>


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
            <div class="ui small form">
                <h2 class="ui centered dividing blue header">تغییر نمایه</h2>
                <div class="two fields">
                    <div class="required field">
                        <label>نام</label>
                        <input placeholder="نام" type="text">
                    </div>
                    <div class="required field">
                        <label>نام خانوادگی</label>
                        <input placeholder="نام خانوادگی" type="text">
                    </div>
                </div>
                <div class="three fields">
                    <div class="field">
                        <label>تاریخ تولد</label>
                        <input  type="date" >

                    </div>
                    <div class="field">
                        <label>استان</label>
                        <div class="ui fluid selection dropdown">
                            <input type="hidden" name="user">
                            <i class="dropdown icon"></i>
                            <div class="default text">استان</div>
                            <div class="menu">
                                <div class="item" data-value="AS">آذربایجان شرقی</div>
                                <div class="item" data-value="AQ">آذربایجان غربی</div>
                                <div class="item" data-value="Ardebil">اردبیل</div>
                                <div class="item" data-value="Esfahan">اصفهان</div>
                                <div class="item" data-value="Alborz">البرز</div>
                                <div class="item" data-value="Ilam">ایلام</div>
                                <div class="item" data-value="Bushehr">بوشهر</div>
                                <div class="item" data-value="Tehran">تهران</div>
                                <div class="item" data-value="Bakhtiari">	چهارمحال و بختیاری</div>
                                <div class="item" data-value="KhJonubi">خراسان جنوبی</div>
                                <div class="item" data-value="KhRazavi">	خراسان رضوی</div>
                                <div class="item" data-value="KhShomali">خراسان شمالی</div>
                                <div class="item" data-value="Khuzestan">خوزستان</div>
                                <div class="item" data-value="Zanjan">زنجان</div>
                                <div class="item" data-value="Semnan">سمنان</div>
                                <div class="item" data-value="Sistan">سیستان و بلوچستان</div>
                                <div class="item" data-value="Fars">فارس</div>
                                <div class="item" data-value="Ghazvin">قزوین</div>
                                <div class="item" data-value="Ghom">قم</div>
                                <div class="item" data-value="Kordestan">	کردستان</div>
                                <div class="item" data-value="Kerman">کرمان</div>
                                <div class="item" data-value="Kermanshah">کرمانشاه</div>
                                <div class="item" data-value="Kohkiluye">	کهگیلویه و بویراحمد</div>
                                <div class="item" data-value="Golestan">	گلستان</div>
                                <div class="item" data-value="Gilan">گیلان</div>
                                <div class="item" data-value="Lorestan">	لرستان</div>
                                <div class="item" data-value="Mazandaran">مازندران</div>
                                <div class="item" data-value="Markazi">مرکزی</div>
                                <div class="item" data-value="Hormozgan">هرمزگان</div>
                                <div class="item" data-value="Hamedan">همدان</div>
                                <div class="item" data-value="Yazd">	یزد</div>
                            </div>
                        </div>
                    </div>
                    <div class=" field">
                        <label>جنسیت</label>
                        <div class="ui form">
                            <div class="inline centered fields">
                                <div class="field">
                                    <div class="ui radio checkbox">
                                        <input type="radio" name="example2" checked="checked">
                                        <label>مونث</label>
                                    </div>
                                </div>
                                <div class="field">
                                    <div class="ui radio checkbox">
                                        <input type="radio" name="example2">
                                        <label>مذکر</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="two fields">
                    <div class="field">
                        <label>رشته</label>
                        <input placeholder="رشته" type="text">
                    </div>
                    <div class="field">
                        <label>میزان تحصیلات</label>
                        <div class="ui fluid selection dropdown">
                            <input type="hidden" name="user">
                            <i class="dropdown icon"></i>
                            <div class="default text">میزان تحصیلات</div>
                            <div class="menu">
                                <div class="item" data-value="AS">سیکل</div>
                                <div class="item" data-value="AQ">دیپلم</div>
                                <div class="item" data-value="Ardebil">فوق دیپلم</div>
                                <div class="item" data-value="Esfahan">لیسانس</div>
                                <div class="item" data-value="Alborz">فوق لیسانس</div>
                                <div class="item" data-value="Ilam">دکترا</div>
                                <div class="item" data-value="Ilam">فوق دکترا</div>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="field">
                    <label>موقعیت شغلی فعلی</label>
                    <input placeholder="موقعیت شغلی فعلی" type="text">
                </div>

                <div class="two fields">
                    <div class="field">
                            <label>درباره ی من</label>
                            <textarea placeholder="درباره ی من"></textarea>
                    </div>
                    <div class="field">
                            <label>توانایی ها</label>
                            <textarea placeholder="توانایی ها"></textarea>
                    </div>

                </div>

                <div class="ui centered blue submit button">ثبت</div>
            </div>
        </div>
        </div>
    </div>
</body>
</html>