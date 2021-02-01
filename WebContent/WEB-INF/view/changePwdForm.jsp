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
<%-- <u:navbar/>
<form action="changePwd.do" method="post">
<p>
현재비밀번호  <br /> <input type="password" name="curPwd" />
<c:if test="${errors.curPwd }">현재 암호를 입력하세요.</c:if>
<c:if test="${errors.badCurPwd}">현재 암호가 일치하지 않습니다.</c:if>
</p>
<p>
새로운 비밀번호 <br /> <input type="password" name="newPwd"/>
<c:if test ="${errors.newPwd }">새로운 암호를 입력하시오 </c:if>
</p>
<input type="submit" value="비밀번호 변경" />
</form> --%>
<section class="login-form container">
        <h1><a class="navbar-brand1" href="${root }/index.jsp"><i class="fab fa-google"></i></a></h1>
        <form action="changePwd.do" method="post">
        	<div class="error" id="error">
        	</div>
            <div class="int-area w-100">
                <input class="w-100" type="password" name="curPwd" id="pw" autocomplete="off" required>
                <label for="id">비밀번호</label>
                <small>
               	<c:if test="${errors.curPwd }">현재 암호를 입력하세요.</c:if>
				<c:if test="${errors.badCurPwd}">현재 암호가 일치하지 않습니다.</c:if>
                </small>
            </div>
            <div class="int-area w-100">
                <input class="w-100" type="password" name="newPwd" id="pw" autocomplete="off" required>
                <label for="pw">새로운 비밀번호 </label>
                <small>
                <c:if test ="${errors.newPwd }">새로운 암호를 입력하시오 </c:if>
                </small>
            </div> 
            <div class="btn-area">
                <button id ="btn" type="submit">비밀번호 변경</button>
            </div>
         </form>
</section>

</body>
</html>