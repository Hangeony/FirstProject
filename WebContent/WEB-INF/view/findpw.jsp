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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<u:navbar/>
<div class="container">
<h1>비밀번호 찾기</h1>
<form action="findpw.do" method="post">
아이디 <br /><input type="text" name="id" /> <br />
<c:if test="${errors.noId }">없는 아이디 입니다.</c:if> <br />
<p>
  비밀번호는 ${userPw } 입니다.
</p>
<input type="submit" value="찾기" />
</form>
 <a href="index.jsp">[메인홈]</a>
</div>
</body>
</html>