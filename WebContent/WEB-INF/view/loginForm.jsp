<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<link rel="stylesheet" type="text/css" href="css/login.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<u:navbar/>
<%--
<div class="container">
<form action="login.do" method="post">
<c:if test="${errors.idOrPwNotMatch }">
<br />
아이디와 비빌먼호가 일치하지 않습니다
</c:if>
<p>
아이디 <br /> <input type="text" name="id" value="${param.id }" />
<br />
<c:if test="${errors.id }"> ID를 입력하세요 </c:if>
</p>
<p>
비밀번호 <br /> <input type="password" name="password" value="${param.password }" />
<br />
<c:if test="${errors.password }"> 비밀번호를 입력하세요 </c:if>
</p>
<input type="submit" value="로그인" />
</form>
</div>
 --%>
 <body>
    <section class="login-form container">
        <h1>
        <a class="navbar-brand1" href="${root }/index.jsp"><i class="fab fa-google"></i></a></h1>
        <form action="${root }/login.do" method="post">
        	<div class="error" id="error">
        	<c:if test="${errors.idOrPwNotMatch }">
				<br />
				아이디와 비빌먼호가 일치하지 않습니다
				</c:if>
        	</div>
            <div class="int-area w-100">
                <input type="text" name="id" class="w-100" id="id" value="${param.id }" autocomplete="off" required>
                <label for="id">아이디</label>
            </div>
            <div class="int-area w-100">
                <input type="password" class="w-100" name="password" value="${param.password }" id="pw" autocomplete="off" required>
                <label for="pw">비밀번호 </label>
            </div> 
            <div class="btn-area">
                <button id ="btn" type="submit">로그인</button>
            </div>
         </form>
         <div class="caption">
         	<a href="${root }/join.do">회원 가입 </a> |
             <a href="${root }/findid.do">아이디 찾기</a> |
             <a href="${root }/findpw.do">비밀 번호 찾기</a>
         </div>
    </section>
<script>
    let id = $('#id');
    let pw = $('#pw');
    let btn = $('#btn');

    $('#btn').on('click',function() {
        if($(id).val()  ==""){
            $(id).next('label').addClass('warning');
            setTimeout(function() {
                $('rabel').removeClass('warning');
            },1500);
        }
        else if($(pw).val()==""){
            $(pw).next('label').addClass('warning');
            setTimeout(function() {
                $('rabel').removeClass('warning');
            },1500);
        }
    });
</script>
</body>
</html>