<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>OAuth 로그인</title>
</head>
<body>
    <a href="/oauth2/authorization/google" class="btn btn-sm btn-success active" role="button">
        <img width="191" height="46" alt="구글 로그인" src = '../img/btn_google_signin_dark_pressed_web.png/'>
    </a><br>
    <a href="/oauth2/authorization/naver" class="btn btn-sm btn-success active" role="button">
        <img width="191" height="46" alt="네이버 로그인" src = '../img/btnG_완성형.png/'>
    </a><br>
    <a href="/oauth2/authorization/kakao" class="btn btn-third active" role="button">
        <img width="191" height="46" alt="카카오 로그인" src = '../img/kakao_login_large_narrow.png/'>
    </a>
</body>
</html>