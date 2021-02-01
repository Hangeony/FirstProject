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
<title>회원 탈퇴</title>
</head>
<body>
<u:navbar/>
<%-- <div class="container">
<h1> 회원탈퇴 </h1>
<form action="removeMember.do" method="post">
아이디  <br /> <input type="text" name="id" />
<c:if test="${errors.no }">잘 못 기입하셨습니다.</c:if>  
<c:if test="${errors.no1 }">이상한 사람 회원탈퇴 시키지마세요.</c:if> <br />
비밀번호 <br /> <input type="password" name="password" />
<c:if test="${errors.pw }">현재 암호를 입력하세요.</c:if>
<c:if test="${errors.noPw}">현재 암호가 일치하지 않습니다.</c:if>
<br />
<input type="submit" value="탈퇴" />
</form>
</div> --%>
<body>
    <section class="login-form container">
        <h1><a class="navbar-brand1" href="${root }/index.jsp"><i class="fab fa-google"></i></a></h1>
        <form action="${root }/removeMember.do" method="post">
        	<div class="error" id="error">
        	</div>
            <div class="int-area w-100">
                <input class="w-100" type="text" name="id" id="id" value="${param.id }" autocomplete="off" required>
                <label for="id">아이디</label>
                <small>
                <c:if test="${errors.no }">잘 못 기입하셨습니다.</c:if>  
				<c:if test="${errors.no1 }">이상한 사람 회원탈퇴 시키지마세요.</c:if>
                </small>
            </div>
            <div class="int-area w-100">
                <input class="w-100" type="password" name="password" value="${param.password }" id="pw" autocomplete="off" required>
                <label for="pw">비밀번호 </label>
                <small>
                <c:if test="${errors.pw }">현재 암호를 입력하세요.</c:if>
				<c:if test="${errors.noPw}">현재 암호가 일치하지 않습니다.</c:if>
                </small>
            </div> 
            <div class="btn-area">
                <button id ="btn" type="submit">회원탈퇴</button>
            </div>
         </form>
         <div class="caption">
             <a href="${root }/findid.do">아이디 찾기</a> |
             <a href="${root }/findpw.do">비밀 번호 찾기</a>
         </div>
    </section>



</body>
</html>